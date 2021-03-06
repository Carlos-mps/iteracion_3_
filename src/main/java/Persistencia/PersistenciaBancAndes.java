package Persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Negocio.Cliente;
import Negocio.CuentaNatural;
import Negocio.CuentasJuridicas;
import Negocio.Oficina;
import Negocio.OperacionesBancarias;
import Negocio.Prestamo;
import Negocio.PuntoDeAtencion;
import Negocio.Usuario;









public class PersistenciaBancAndes {
	
	private static Logger log = Logger.getLogger(PersistenciaBancAndes.class.getName());

	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaBancAndes instance;
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUsuario sqlUsuario;
	private SQLOficina sqlOficina;
	private SQLCuentasJuridicas sqlCuentasJuridicas;
	private SQLUtil sqlUtil;
	private SQLPuntoDeAtencion sqlPuntoDeAtencion;
	private SQLPrestamo sqlPrestamo;
	private SQLCliente sqlCliente;
	private SQLCuentaNatural sqlCuentaNatural;
	private SQLEmpleado sqlEmpleado;
	private SQLOperacionesBancarias sqlOperacionesBancarias;
	private PersistenciaBancAndes (){
		BasicConfigurator.configure();
		pmf = JDOHelper.getPersistenceManagerFactory("bancAndes");		
		crearClasesSQL ();		
		tablas = new LinkedList<String> ();
		tablas.add ("BancAndes_sequence");
		tablas.add ("USUARIO");
		tablas.add ("EMPLEADO");
		tablas.add ("OFICINA");
		tablas.add ("PUNTODEATENCION");
		tablas.add ("CAJEROSPUNTOATENCION");
		tablas.add ("CLIENTE");
		tablas.add ("ADMINISTRADOR");
		tablas.add ("CUENTASJURIDICAS");
		tablas.add ("OPERACIONESBANCARIAS");
		tablas.add ("OPERACIONCUENTA");
		tablas.add ("OPERACIONCDT");
		tablas.add ("OPERACIONACCIONES");
		tablas.add ("OPERACIONINVERSION");
		tablas.add ("PRESTAMO");
		tablas.add ("CUOTAMINIMAPRESTAMO");
		tablas.add ("OPERACIONPRESTAMO");
		tablas.add ("CUENTANATURAL");
		
		
	}
	
	private PersistenciaBancAndes (JsonObject tableConfig) {
		BasicConfigurator.configure();
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
		
	}
	
	public static PersistenciaBancAndes getInstance () {
		
		if (instance == null)
		{
			instance = new PersistenciaBancAndes ();
		}
		return instance;
		
	}
	
	public static PersistenciaBancAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaBancAndes (tableConfig);
		}
		return instance;
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	private void crearClasesSQL ()
	{
		
		sqlUsuario = new SQLUsuario(this);
		sqlOficina = new SQLOficina(this);
		sqlUtil = new SQLUtil(this);
		sqlCuentasJuridicas = new SQLCuentasJuridicas(this);
		sqlPuntoDeAtencion = new SQLPuntoDeAtencion(this);
		sqlPrestamo = new SQLPrestamo(this);
		sqlCliente = new SQLCliente(this);
		sqlCuentaNatural = new SQLCuentaNatural(this);
		sqlEmpleado = new SQLEmpleado(this);
		sqlOperacionesBancarias = new SQLOperacionesBancarias(this);
	}
	
	public String darSeqBancAndes ()
	{
		return tablas.get (0);
	}
	
	public String darTablaUsuario ()
	{
		return tablas.get (1);
	}
	public String darTablaEmpleado()
	{
		return tablas.get (2);
	}
	
	public String darTablaOficina ()
	{
		return tablas.get (3);
	}
	public String darTablaPuntoDeAtencion() {
		return tablas.get (4);
	}
	
	
	public String darTablaCuentasJuridicas ()
	{
		return tablas.get (8);
	}
	
	public String darTablaPrestamo ()
	{
		return tablas.get (14);
	}
	public String darTablaCliente ()
	{
		return tablas.get (6);
	}
	public String darTablaOperacionesBancarias ()
	{
		return tablas.get (9);
	}
	
	public String darTablaCuentaNatural () {
		return tablas.get(17);
	}
	
	
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	private BigDecimal nextval1 ()
	{
		BigDecimal resp =  sqlUtil.nextval2 (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}
	
	
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	public Usuario adicionarUsuario(long numeroDocumento, String tipoDocumento, String login, String palabraClave, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, long telefono, String ciudad, String departamento, long codigoPostal) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, numeroDocumento, tipoDocumento, login, palabraClave, nombre, nacionalidad, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal);
            tx.commit();

            log.trace ("Inserci???n de Usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Usuario (numeroDocumento, tipoDocumento, login, palabraClave, nombre, nacionalidad, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	public Oficina adicionarOficina(String nombre , String direccion , long numPuntosAtencion ,  long idEmpleado ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long tuplasInsertadas = sqlOficina.adicionarOficina(pm, nombre ,direccion ,numPuntosAtencion ,idEmpleado );
            tx.commit();

            log.trace ("Inserci???n de Oficina: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Oficina (nombre ,direccion ,numPuntosAtencion ,idEmpleado );
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public CuentasJuridicas adicionarCuentaJuridica(  String tipoCuenta , int saldo  , long numeroIDCliente  ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            long numeroUnicoA =  nextval ();
            String activa = "Activa";            
            long tuplasInsertadas = sqlCuentasJuridicas.adicionarCuenta(pm,numeroUnicoA, tipoCuenta, saldo, activa, numeroIDCliente);
            
            tx.commit();

            log.trace ("Inserci???n de Cuenta: " + numeroUnicoA + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new CuentasJuridicas (numeroUnicoA, tipoCuenta, saldo, activa, numeroIDCliente);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public CuentaNatural adicionarCuentaNatural(  String tipoCuenta , int saldo  , long numeroIDCliente  ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            long numeroUnicoNatural =  nextval ();
            String activa = "Activa";            
            long tuplasInsertadas = sqlCuentaNatural.adicionarCuentaNatural(pm, numeroUnicoNatural, tipoCuenta, saldo, activa, numeroIDCliente);
            
            tx.commit();

            log.trace ("Inserci???n de Cuenta: " + numeroUnicoNatural + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new CuentaNatural (numeroUnicoNatural, tipoCuenta, saldo, activa, numeroIDCliente);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Prestamo adicionarPrestamo(   BigDecimal monto, BigDecimal interes, BigDecimal numCuotas,BigDecimal diaPago,  String tipoPrestamo, BigDecimal idCliente  ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            BigDecimal idA =  nextval1 ();
            String activo = "Activo";            
            BigDecimal tuplasInsertadas = sqlPrestamo.adicionarPrestamo(pm,idA,monto, interes, numCuotas, diaPago,activo,tipoPrestamo,idCliente);
            
            tx.commit();

            log.trace ("Inserci???n de Prestamo: " + idA + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Prestamo (idA,monto, interes, numCuotas, diaPago,activo,tipoPrestamo,idCliente);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public PuntoDeAtencion adicionarPuntoDeAtencion( String tipoPunto , String localizacion , String oficina ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            long id =  nextval ();
                        
            long tuplasInsertadas = sqlPuntoDeAtencion.adicionarPuntoDeAtencion(pm,id, tipoPunto, localizacion, oficina);
            
            tx.commit();

            log.trace ("Inserci???n de Punto: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new PuntoDeAtencion (id, tipoPunto, localizacion, oficina);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long eliminarCuentaJuridica (long numeroUnico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuentasJuridicas.eliminarCuenta (pm, numeroUnico);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	//dar cuenta por numeroUnico
	public CuentasJuridicas darCuentaPorNumeroUnico (long numeroUnico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			CuentasJuridicas resp = sqlCuentasJuridicas.darCuentaPorNumeroUnico (pm, numeroUnico);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
			}
		}
	public long eliminarPrestamo (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPrestamo.eliminarPrestamo (pm, id);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	public List <CuentasJuridicas> darCuentaParaCLiente(long numeroIDCliente){
	
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			List <CuentasJuridicas> resp = sqlCuentasJuridicas.darCuentaParaCliente(pm, numeroIDCliente);
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
			}
		}

		//busca un cliente por su numeroId
	 public Cliente darCliente(long numeroID) {
	        PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx=pm.currentTransaction();		
	    try{
			tx.begin();
			Cliente resp = sqlCliente.buscarClientePorId(pm, numeroID);
			tx.commit();
			return resp;

		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
			}
		}

		// get the tipo de persona por su numeroId
		public String darTipoPersona(long numeroID) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx=pm.currentTransaction();
			try
			{
				tx.begin();
				String resp = sqlCliente.darTipoPersona(pm, numeroID);
				tx.commit();
				return resp;

			}
			catch (Exception e)
			{
//				e.printStackTrace();
				log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
				return null;
			}
			finally
			{
				if (tx.isActive())
				{
					tx.rollback();
				}
				pm.close();
				}
			}
		
		public BigDecimal darIdClienteNatural(long numeroID) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx=pm.currentTransaction();
			try
			{
				tx.begin();
				BigDecimal resp = sqlCuentaNatural.darIdClienteNatural(pm, numeroID);
				tx.commit();
				return resp;

			}
			catch (Exception e)
			{
//				e.printStackTrace();
				log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
				return null;
			}
			finally
			{
				if (tx.isActive())
				{
					tx.rollback();
				}
				pm.close();
				}
			}
		public BigDecimal darIdClienteJuridico(long numeroID) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx=pm.currentTransaction();
			try
			{
				tx.begin();
				BigDecimal resp = sqlCuentasJuridicas.darIdClienteJuridico(pm, numeroID);
				tx.commit();
				return resp;

			}
			catch (Exception e)
			{
//				e.printStackTrace();
				log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
				return null;
			}
			finally
			{
				if (tx.isActive())
				{
					tx.rollback();
				}
				pm.close();
				}
			}


			//get the tipo de empleado por su numeroId
			public String buscarTipoEmpleadoId(Long numeroId)
			{
				PersistenceManager pm = pmf.getPersistenceManager();
				Transaction tx = pm.currentTransaction();
				try
				{
					tx.begin();
					String resp = sqlEmpleado.buscarTipoEmpleadoPorId(pm, numeroId);
					tx.commit();
					
					return resp;
				}
				catch (Exception e)
				{
//					e.printStackTrace();
					log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
					return null;
				}
				finally
				{
					if (tx.isActive())
					{
						tx.rollback();
					}
					pm.close();
				}
			}
			 
			
			//get the prestamo por idCliente
			public List <Prestamo> darPrestamosCliente (BigDecimal idCliente)
			{
				PersistenceManager pm = pmf.getPersistenceManager();
				Transaction tx = pm.currentTransaction();
				try
				{
					tx.begin();
					List <Prestamo> resp = sqlPrestamo.darPrestamosCliente(pm, idCliente);
					tx.commit();
					
					return resp;
				}
				catch (Exception e)
				{
//					e.printStackTrace();
					log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
					return null;
				}
				finally
				{
					if (tx.isActive())
					{
						tx.rollback();
					}
					pm.close();
				}
			}

			public List<OperacionesBancarias> darOperacionesCliente (BigDecimal numeroCuenta)
			{
				PersistenceManager pm = pmf.getPersistenceManager();
				Transaction tx = pm.currentTransaction();
				try
				{
					tx.begin();
					List<OperacionesBancarias> resp = sqlOperacionesBancarias.darOperacionesCliente(pm, numeroCuenta);
					tx.commit();
					
					return resp;
				}
				catch (Exception e)
				{
//					e.printStackTrace();
					log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
					return null;
				}
				finally
				{
					if (tx.isActive())
					{
						tx.rollback();
					}
					pm.close();
				}
			}


			//get the prestamo por su numeroId
			public List<Prestamo> darPrestamos (){
				System.out.println("paso 2");
				PersistenceManager pm = pmf.getPersistenceManager();
				Transaction tx=pm.currentTransaction();
				try
				{
					tx.begin();
					List<Prestamo> resp = sqlPrestamo.darPrestamosGerenteGeneral(pm);
					tx.commit();
					return resp;
				}
				catch (Exception e)
				{
//					e.printStackTrace();
					log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
					return null;
				}
				finally
				{
					if (tx.isActive())
					{
						tx.rollback();
					}
					pm.close();
				}
			}
			
			public long asociarCuentaNatural(long numeroUnicoNatural, long numeroEmpleador, long valorAPagar, String frecuenciaPago) 
			{
				PersistenceManager pm = pmf.getPersistenceManager();
		        Transaction tx=pm.currentTransaction();
		        try
		        {
		            tx.begin();
		            long resp = sqlCuentaNatural.asociarCuentaNatural (pm, numeroUnicoNatural,numeroEmpleador,valorAPagar,frecuenciaPago);
		            tx.commit();

		            return resp;
		        }
		        catch (Exception e)
		        {
//		        	e.printStackTrace();
		        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
		            return -1;
		        }
		        finally
		        {
		            if (tx.isActive())
		            {
		                tx.rollback();
		            }
		            pm.close();
		        }
			}

			public List<OperacionesBancarias> darOperacionesBancarias (){
				System.out.println("paso 2_____________________________");
				PersistenceManager pm = pmf.getPersistenceManager();
				Transaction tx=pm.currentTransaction();
				try
				{
					tx.begin();
					List<OperacionesBancarias> resp = sqlOperacionesBancarias.darOperacionesGerente(pm);
					tx.commit();
					return resp;
				}
				catch (Exception e)
				{
//					e.printStackTrace();
					log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
					return null;
				}
				finally
				{
					if (tx.isActive())
					{
						tx.rollback();
					}
					pm.close();
				}
			}

			


	
	}

