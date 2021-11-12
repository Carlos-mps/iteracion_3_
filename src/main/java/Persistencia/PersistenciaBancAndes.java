package Persistencia;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Negocio.Cuenta;
import Negocio.Oficina;
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
	private SQLCuenta sqlCuenta;
	private SQLUtil sqlUtil;
	private SQLPuntoDeAtencion sqlPuntoDeAtencion;
	private SQLPrestamo sqlPrestamo;
	
	private PersistenciaBancAndes (){
		
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
		tablas.add ("CUENTA");
		tablas.add ("OPERACIONESBANCARIAS");
		tablas.add ("OPERACIONCUENTA");
		tablas.add ("OPERACIONCDT");
		tablas.add ("OPERACIONACCIONES");
		tablas.add ("OPERACIONINVERSION");
		tablas.add ("PRESTAMO");
		tablas.add ("CUOTAMINIMAPRESTAMO");
		tablas.add ("OPERACIONPRESTAMO");
		
	}
	
	private PersistenciaBancAndes (JsonObject tableConfig) {
		
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
		sqlCuenta = new SQLCuenta(this);
		sqlPuntoDeAtencion = new SQLPuntoDeAtencion(this);
		sqlPrestamo = new SQLPrestamo(this);
		
	}
	
	public String darSeqBancAndes ()
	{
		return tablas.get (0);
	}
	
	public String darTablaUsuario ()
	{
		return tablas.get (1);
	}
	
	public String darTablaOficina ()
	{
		return tablas.get (3);
	}
	public String darTablaPuntoDeAtencion() {
		return tablas.get (4);
	}
	
	
	public String darTablaCuenta ()
	{
		return tablas.get (8);
	}
	
	public String darTablaPrestamo ()
	{
		return tablas.get (14);
	}
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
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

            log.trace ("Inserci�n de Usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
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

            log.trace ("Inserci�n de Oficina: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
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
	
	public Cuenta adicionarCuenta(  String tipoCuenta , int saldo  , long numeroIDCliente  ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            long numeroUnicoA =  nextval ();
            String activa = "Activa";            
            long tuplasInsertadas = sqlCuenta.adicionarCuenta(pm,numeroUnicoA, tipoCuenta, saldo, activa, numeroIDCliente);
            
            tx.commit();

            log.trace ("Inserci�n de Cuenta: " + numeroUnicoA + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Cuenta (numeroUnicoA, tipoCuenta, saldo, activa, numeroIDCliente);
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
	
	public Prestamo adicionarPrestamo(   long monto, long interes, int numCuotas,int diaPago,  String tipoPrestamo, long idCliente  ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin(); 
            long idA =  nextval ();
            String activo = "Activo";            
            long tuplasInsertadas = sqlPrestamo.adicionarPrestamo(pm,idA,monto, interes, numCuotas, diaPago,activo,tipoPrestamo,idCliente);
            
            tx.commit();

            log.trace ("Inserci�n de Prestamo: " + idA + ": " + tuplasInsertadas + " tuplas insertadas");
            
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

            log.trace ("Inserci�n de Punto: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
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
	
	public long eliminarCuenta (long numeroUnico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCuenta.eliminarCuenta (pm, numeroUnico);
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
	public Cuenta darCuentaPorNumeroUnico (long numeroUnico) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			Cuenta resp = sqlCuenta.darCuentaPorNumeroUnico (pm, numeroUnico);
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

	public List <Cuenta> darCuentaParaCLiente(long numeroIDCliente){
	
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			List <Cuenta> resp = sqlCuenta.darCuentaParaCliente(pm, numeroIDCliente);
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

	
	}

