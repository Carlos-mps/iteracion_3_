package Interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
<<<<<<< Updated upstream
import java.util.LinkedList;
=======
>>>>>>> Stashed changes
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import Negocio.BancAndes;
import Negocio.OperacionesBancarias;
import Negocio.Prestamo;
import Negocio.VOCliente;
import Negocio.VOCuenta;
import Negocio.VOCuentaNatural;
import Negocio.VOOficina;
import Negocio.VOPrestamo;
import Negocio.VOPuntoDeAtencion;
import Negocio.VOUsuario;




@SuppressWarnings("serial")


public class Interfaz extends JFrame implements ActionListener{

	private static Logger log = Logger.getLogger(Interfaz.class.getName());

	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 

	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

	private JsonObject tableConfig;

	private BancAndes bancAndes;

	private JsonObject guiConfig;

	private PanelDatos panelDatos;

	private JMenuBar menuBar;

	public Interfaz() {

		guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);         

		configurarFrame ( );
		if (guiConfig != null) 	   
		{
			crearMenu( guiConfig.getAsJsonArray("menuBar") );
		}

		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		bancAndes = new BancAndes (tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos ( );

		setLayout (new BorderLayout());
		add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
		add( panelDatos, BorderLayout.CENTER ); 

	}

	private JsonObject openConfig (String tipo, String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontr� un archivo de configuraci�n v�lido: " + tipo);
		} 
		catch (Exception e)
		{
			//				e.printStackTrace ();
			log.info ("NO se encontr� un archivo de configuraci�n v�lido");			
			JOptionPane.showMessageDialog(null, "No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}

	private void configurarFrame(  )
	{
		int alto = 0;
		int ancho = 0;
		String titulo = "";	

		if ( guiConfig == null )
		{
			log.info ( "Se aplica configuraci�n por defecto" );			
			titulo = "BancAndes APP Default";
			alto = 300;
			ancho = 500;
		}
		else
		{
			log.info ( "Se aplica configuraci�n indicada en el archivo de configuraci�n" );
			titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocation (50,50);
		setResizable( true );
		setBackground( Color.WHITE );

		setTitle( titulo );
		setSize ( ancho, alto);        
	}

	private void crearMenu(  JsonArray jsonMenu )
	{    	
		// Creaci�n de la barra de men�s
		menuBar = new JMenuBar();       
		for (JsonElement men : jsonMenu)
		{
			// Creaci�n de cada uno de los men�s
			JsonObject jom = men.getAsJsonObject(); 

			String menuTitle = jom.get("menuTitle").getAsString();        	
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu( menuTitle);

			for (JsonElement op : opciones)
			{       	
				// Creaci�n de cada una de las opciones del men�
				JsonObject jo = op.getAsJsonObject(); 
				String lb =   jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem( lb );
				mItem.addActionListener( this );
				mItem.setActionCommand(event);

				menu.add(mItem);
			}       
			menuBar.add( menu );
		}        
		setJMenuBar ( menuBar );	
	}

	public void adicionarUsuario( )
	{
		try 
		{	    		
			String numeroDocumentoStr = JOptionPane.showInputDialog (this, "Numero del documento?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String tipoDocumento = JOptionPane.showInputDialog (this, "Tipo del documento?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String login = JOptionPane.showInputDialog (this, "Login?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String palabraClave = JOptionPane.showInputDialog (this, "Palabra clave?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String nombre = JOptionPane.showInputDialog (this, "nombre?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String nacionalidad = JOptionPane.showInputDialog (this, "nacionalidad?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String direccionFisica = JOptionPane.showInputDialog (this, "Direccion fisica?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String direccionElectronica = JOptionPane.showInputDialog (this, "Direccion electronica?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String telefonoStr = JOptionPane.showInputDialog (this, "Telefono?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String ciudad = JOptionPane.showInputDialog (this, "Ciudad?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String departamento = JOptionPane.showInputDialog (this, "Departamento?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			String codigoPostalStr = JOptionPane.showInputDialog (this, "Codigo postal?", "Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);

			if (numeroDocumentoStr != null && tipoDocumento != null && login != null && palabraClave != null && nombre != null && nacionalidad != null && 
					direccionFisica != null && direccionElectronica != null && telefonoStr != null && ciudad != null && departamento != null && codigoPostalStr != null)
			{
				long numeroDocumento = Long.valueOf (numeroDocumentoStr);
				long telefono = Long.valueOf (telefonoStr);
				long codigoPostal = Long.valueOf (codigoPostalStr);

				VOUsuario tb = bancAndes.adicionarUsuario (numeroDocumento,tipoDocumento,login,palabraClave,nombre,nacionalidad,direccionFisica,direccionElectronica
						,telefono,ciudad,departamento,codigoPostal);
				if (tb == null)
				{
					throw new Exception ("No se pudo agregar al Usuario: " + nombre);
				}
				String resultado = "En adicionarUsuario\n\n";
				resultado += "Usuario adicionado exitosamente: " + tb;
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada ");
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void adicionarOficina( )
	{
		try 
		{	    		
			String nombre = JOptionPane.showInputDialog (this, "Nombre de la oficina?", "Adicionar Oficina", JOptionPane.QUESTION_MESSAGE);
			String direccion = JOptionPane.showInputDialog (this, "Direccion?", "Adicionar Oficina", JOptionPane.QUESTION_MESSAGE);
			String numPuntosAtencionSrt = JOptionPane.showInputDialog (this, "Numero de puntos de atencion?", "Adicionar Oficina", JOptionPane.QUESTION_MESSAGE);
			String idEmpleadoSrt = JOptionPane.showInputDialog (this, "Numero de documento del gerente?", "Adicionar Oficina", JOptionPane.QUESTION_MESSAGE);

			if (nombre != null && direccion != null && numPuntosAtencionSrt != null && idEmpleadoSrt != null )
			{
				long numPuntosAtencion = Long.valueOf (numPuntosAtencionSrt);
				long idEmpleado = Long.valueOf (idEmpleadoSrt);	    			

				VOOficina tb = bancAndes.adicionarOficina(nombre , direccion ,numPuntosAtencion ,  idEmpleado );
				if (tb == null)
				{
					throw new Exception ("No se pudo agregar la oficina: " + nombre);
				}
				String resultado = "En adicionarOficina\n\n";
				resultado += "Oficina adicionada exitosamente: " + tb;
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada ");
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void darCuentaPorNumero ( ){
		try{
			long numeroCuenta = Long.parseLong(JOptionPane.showInputDialog(this, "Ingrese el numero de cuenta", "Dar cuenta por numero", JOptionPane.QUESTION_MESSAGE));
			VOCuenta cuenta = bancAndes.darCuentaPorNumero(numeroCuenta);
			if (cuenta == null)
			{
				throw new Exception ("No se pudo encontrar la cuenta con numero: " + numeroCuenta);
			}
			String resultado = "En darCuentaPorNumero\n\n";
			resultado += "Cuenta: " + cuenta;
			resultado += "\n Operaci�n terminada";
			panelDatos.actualizarInterfaz(resultado);
		}
		catch (Exception e){
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}





	public void adicionarCuenta( )
	{
		try 
		{	    		
			String tipoCuenta = JOptionPane.showInputDialog (this, "Tipo cuenta?", "Adicionar Cuenta", JOptionPane.QUESTION_MESSAGE);
			String saldoSrt = JOptionPane.showInputDialog (this, "saldo?", "Adicionar Cuenta", JOptionPane.QUESTION_MESSAGE);
			String numeroIDClienteSrt = JOptionPane.showInputDialog (this, "Num documento cliente?", "Adicionar Cuenta", JOptionPane.QUESTION_MESSAGE);


			if (tipoCuenta != null && saldoSrt != null && numeroIDClienteSrt!= null )
			{
				int saldo = Integer.valueOf (saldoSrt);
				long numeroIDCliente = Long.valueOf (numeroIDClienteSrt);	    			


				if (bancAndes.darTipoPersona (numeroIDCliente).equals("Juridica")) {
					VOCuenta tb = bancAndes.adicionarCuentaJuridica (tipoCuenta,saldo,numeroIDCliente);


					if (tb == null)
					{
						throw new Exception ("No se pudo agregar la cuenta: " );
					}
					String resultado = "En adicionarCuenta\n\n";
					resultado += "Cuenta adicionada exitosamente: " + tb;
					resultado += "\n Operaci�n terminada";
					panelDatos.actualizarInterfaz(resultado);
				}
				else if (bancAndes.darTipoPersona (numeroIDCliente).equals("Natural")) {
					VOCuentaNatural tb = bancAndes.adicionarCuentaNatural (tipoCuenta,saldo,numeroIDCliente);

					if (tb == null)
					{
						throw new Exception ("No se pudo agregar la cuenta: " );
					}
					String resultado = "En adicionarCuenta\n\n";
					resultado += "Cuenta adicionada exitosamente: " + tb;
					resultado += "\n Operaci�n terminada";
					panelDatos.actualizarInterfaz(resultado);
				}
				else
				{
					panelDatos.actualizarInterfaz("Operaci�n cancelada ");
				}
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void adicionarPrestamo( )
	{
		try 
		{	    		
			String montoSrt = JOptionPane.showInputDialog (this, "Monto del prestamo?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
			String interesSrt = JOptionPane.showInputDialog (this, "Interes?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
			String numCuotasSrt = JOptionPane.showInputDialog (this, "Num de cuotas?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
			String diaPagoSrt = JOptionPane.showInputDialog (this, "Dia de pago?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
			String tipoPrestamo = JOptionPane.showInputDialog (this, "Tipo de prestamo?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
			String idClienteSrt = JOptionPane.showInputDialog (this, "Num documento cliente?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);


			if (montoSrt != null && interesSrt != null && numCuotasSrt!= null&& diaPagoSrt != null && tipoPrestamo != null && idClienteSrt!= null )
			{
				int numCuotas = Integer.valueOf (numCuotasSrt);
				int diaPago = Integer.valueOf (diaPagoSrt);
				long monto = Long.valueOf (montoSrt);	 
				long interes = Long.valueOf (interesSrt);
				long idCliente = Long.valueOf (idClienteSrt);

				VOPrestamo tb = bancAndes.adicionarPrestamo (monto,interes,numCuotas,diaPago,tipoPrestamo,idCliente);
				if (tb == null)
				{
					throw new Exception ("No se pudo agregar el prestamo: " );
				}
				String resultado = "En adicionarPrestamo\n\n";
				resultado += "Prestamo adicionado exitosamente: " + tb;
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
<<<<<<< Updated upstream
	    }
	   public void adicionarPrestamo( )
	    {
	    	try 
	    	{	    		
	    		String montoSrt = JOptionPane.showInputDialog (this, "Monto del prestamo?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		String interesSrt = JOptionPane.showInputDialog (this, "Interes?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		String numCuotasSrt = JOptionPane.showInputDialog (this, "Num de cuotas?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		String diaPagoSrt = JOptionPane.showInputDialog (this, "Dia de pago?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		String tipoPrestamo = JOptionPane.showInputDialog (this, "Tipo de prestamo?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		String idClienteSrt = JOptionPane.showInputDialog (this, "Num documento cliente?", "Adicionar Prestamo", JOptionPane.QUESTION_MESSAGE);
	    		
	    			   		
	    		if (montoSrt != null && interesSrt != null && numCuotasSrt!= null&& diaPagoSrt != null && tipoPrestamo != null && idClienteSrt!= null )
	    		{
	    			BigDecimal numCuotas = BigDecimal.valueOf(Integer.valueOf (numCuotasSrt));
	    			BigDecimal diaPago = BigDecimal.valueOf(Integer.valueOf (diaPagoSrt));
	    			BigDecimal monto = BigDecimal.valueOf(Long.valueOf (montoSrt)) ;	 
	    			BigDecimal interes = BigDecimal.valueOf(Long.valueOf (interesSrt)); 
	    			BigDecimal idCliente = BigDecimal.valueOf(Long.valueOf (idClienteSrt)) ;

	        		VOPrestamo tb = bancAndes.adicionarPrestamo (monto,interes,numCuotas,diaPago,tipoPrestamo,idCliente);
	        		if (tb == null)
	        		{
	        			throw new Exception ("No se pudo agregar el prestamo: " );
	        		}
	        		String resultado = "En adicionarPrestamo\n\n";
	        		resultado += "Prestamo adicionado exitosamente: " + tb;
	    			resultado += "\n Operaci�n terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    		else
	    		{
	    			panelDatos.actualizarInterfaz("Operaci�n cancelada ");
	    		}
			} 
	    	catch (Exception e) 
	    	{
//				e.printStackTrace();
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
=======
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada ");
>>>>>>> Stashed changes
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void adicionarPuntoDeAtencion( )
	{
		try 
		{	    		
			String tipoPunto = JOptionPane.showInputDialog (this, "Tipo punto?", "Adicionar Punto", JOptionPane.QUESTION_MESSAGE);
			String localizacion = JOptionPane.showInputDialog (this, "localizacion?", "Adicionar Punto", JOptionPane.QUESTION_MESSAGE);
			String oficina = JOptionPane.showInputDialog (this, "oficina?", "Adicionar Punto", JOptionPane.QUESTION_MESSAGE);


			if (tipoPunto != null && localizacion != null  )
			{

				VOPuntoDeAtencion tb = bancAndes.adicionarPuntoDeAtencion (tipoPunto,localizacion,oficina);
				if (tb == null)
				{
					throw new Exception ("No se pudo agregar el punto: " );
				}
				String resultado = "En adicionarPunto\n\n";
				resultado += "Punto adicionada exitosamente: " + tb;
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada ");
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void eliminarCuenta( )
	{
		try 
		{
			String numeroUnicoStr = JOptionPane.showInputDialog (this, "Id de la cuenta?", "Borrar cuenta", JOptionPane.QUESTION_MESSAGE);
			if (numeroUnicoStr != null)
			{
				long numeroUnico = Long.valueOf (numeroUnicoStr);    		
				long tbEliminados = bancAndes.eliminarCuentaJuridica (numeroUnico);
				String resultado = "En cerrar Cuenta\n\n";
				resultado += tbEliminados + " cuenta cerrada\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void eliminarPrestamo( )
	{
		try 
		{
			String idSrt = JOptionPane.showInputDialog (this, "Id del prestamo?", "Borrar prestamo", JOptionPane.QUESTION_MESSAGE);
			if (idSrt != null)
			{
				long id = Long.valueOf (idSrt);    		
				long tbEliminados = bancAndes.eliminarPrestamo (id);
				String resultado = "En cerrar prestamo\n\n";
				resultado += tbEliminados + " prestamo cerrado\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}


	public void darCuentaParaCliente (){
		try {
			String idClienteStr = JOptionPane.showInputDialog (this, "Id del cliente?", "Dar cuenta", JOptionPane.QUESTION_MESSAGE);
			if (idClienteStr != null)
			{
				long idCliente = Long.valueOf (idClienteStr);    		
				List <VOCuenta> cuentas = bancAndes.darCuentaParaCliente (idCliente);
				String resultado = "En dar cuenta\n\n";
				resultado += "\n " +  cuentas.size() + " cuentas encontradas\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}
		} catch (Exception e) {

			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	public void darClientes (){
		try {
			String idClienteStr = JOptionPane.showInputDialog (this, "Id del cliente?", "Dar cliente", JOptionPane.QUESTION_MESSAGE);
			if (idClienteStr != null)
			{
				long idCliente = Long.valueOf (idClienteStr);    		
				VOCliente cliente = bancAndes.darClientePorNumero (idCliente);
				String resultado = "En dar cliente\n\n";
				resultado += "\n " +  cliente + " cliente encontrado\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}

		}catch (Exception e) {

			e.printStackTrace();
			String resultado = generarMensajeError(e);
		}
	}


	//dar tipoEmpleado por su id
	public void darTipoEmpleadoPorId (){
		try { 
			String idTipoEmpleadoStr = JOptionPane.showInputDialog (this, "Id del tipo de empleado?", "Dar tipo de empleado", JOptionPane.QUESTION_MESSAGE);
			if (idTipoEmpleadoStr != null)
			{
				long idTipoEmpleado = Long.valueOf (idTipoEmpleadoStr);    		
				String tipoEmpleado = bancAndes.buscarTipoEmpleado(idTipoEmpleado);
				String resultado = "En dar tipo de empleado\n\n";
				resultado += "\n " +  tipoEmpleado + " tipo de empleado encontrado\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}
		}catch (Exception e) {

			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}

	}
	//dar tipoPersona por su id
	public void darTipoPersona (){
		try {
			String idTipoPersonaStr = JOptionPane.showInputDialog (this, "Id del tipo de persona?", "Dar tipo de persona", JOptionPane.QUESTION_MESSAGE);
			if (idTipoPersonaStr != null){
				long idTipoPersona = Long.valueOf (idTipoPersonaStr);    		
				String tipoPersona = bancAndes.darTipoPersona (idTipoPersona);
				String resultado = "En dar tipo de persona\n\n";
				resultado += "\n " +  tipoPersona + " tipo de persona encontrado\n";
				resultado += "\n Operaci�n terminada";
				panelDatos.actualizarInterfaz(resultado);
			}
			else
			{
				panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}

		} catch (Exception e) {
			//e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}




	public List <Prestamo> darPrestamosGerenteGeneral ()
	{
<<<<<<< Updated upstream
		String resultado = null;
		
		List <Prestamo> lista = new LinkedList<>();
		
			String tipoUsuario = JOptionPane.showInputDialog(this, "Que persona es cliente o empleado?", "dar tipo Usuario", JOptionPane.QUESTION_MESSAGE);
			
		if (tipoUsuario.equals("empleado")) {
		
			String idEmpleado = JOptionPane.showInputDialog(this, "ingrese el numero de identificacion", "dar numero de documento", JOptionPane.QUESTION_MESSAGE);
			
				long idEmpleado2 = Long.valueOf(idEmpleado);
				
				String tipoEmpleado = bancAndes.buscarTipoEmpleado(idEmpleado2);
				
				
		if (tipoEmpleado.equals("Gerente general")) {
		
			 lista = bancAndes.darPrestamos();
			for (Prestamo a : lista) {
				
				resultado = "id: " +  a.getId().toString()+ " monto: " + a.getMonto().toString()+ " interes: " + a.getInteres().toString() + " numeroCuotas: " 
						+ a.getNumCuotas().toString()+ " diaPago: " + a.getDiaPago().toString() + " estado: " + a.getEstado().toString() + " tipoPrestamo: " + a.getTipoPrestamo().toString()
						+ " idCliente " + a.getIdCliente().toString() ;
				panelDatos.actualizarInterfaz2(resultado);
				
			}
		}
		else {
			panelDatos.actualizarInterfaz("no es un gerente");
		}
		
		}
		if (tipoUsuario.equals("cliente")) {
		String idCliente = JOptionPane.showInputDialog(this, "ingrese el numero de identificacion", "dar numero de documento", JOptionPane.QUESTION_MESSAGE);
		BigDecimal idCliente2 = BigDecimal.valueOf(Long.valueOf(idCliente));
		lista = bancAndes.darPrestamosCliente(idCliente2);
		for (Prestamo a : lista) {
				
			resultado = "id: " +  a.getId().toString()+ " monto: " + a.getMonto().toString()+ " interes: " + a.getInteres().toString() + " numeroCuotas: " 
					+ a.getNumCuotas().toString()+ " diaPago: " + a.getDiaPago().toString() + " estado: " + a.getEstado().toString() + " tipoPrestamo: " + a.getTipoPrestamo().toString()
					+ " idCliente " + a.getIdCliente().toString() ;
			panelDatos.actualizarInterfaz2(resultado);
			
		}
		}
			
			return lista;
	}

	public List <OperacionesBancarias> darOperacionesBancarias (){
		List <OperacionesBancarias> lista = new LinkedList<>();
		String resultado = null;
		String tipoUsuario = JOptionPane.showInputDialog(this, "Que persona es cliente o empleado?", "dar tipo Usuario", JOptionPane.QUESTION_MESSAGE);
		if (tipoUsuario.equals("empleado")) {
			String tipoEmpleado = JOptionPane.showInputDialog(this, "ingrese el numero de identificacion", "dar numero de documento", JOptionPane.QUESTION_MESSAGE);
			long idEmpleado2 = Long.valueOf(tipoEmpleado);
			String empleadoTipo = bancAndes.buscarTipoEmpleado(idEmpleado2);
			if (empleadoTipo.equals("Gerente general")) {
			
		lista = bancAndes.darOperacionesBancarias();
		resultado = " Bienvenido Gerente, Estos son los prestamos" ;
		panelDatos.actualizarInterfaz(resultado);
		for (OperacionesBancarias a : lista) {
			
			resultado = " id: " + a.getId().toString() + " valor: " + a.getValor().toString() + " fecha: " + a.getFechaHora().toString() + " numero cuenta: " + a.getNumeroCuenta();
			panelDatos.actualizarInterfaz2(resultado);
		}
			}
		}
		else {
			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		}
		
		if (tipoUsuario.equals("cliente")) {
			
			String numCuenta = JOptionPane.showInputDialog(this, "ingrese su numero de cuenta", "dar numero de cuenta", JOptionPane.QUESTION_MESSAGE);
			BigDecimal numCuenta2 = BigDecimal.valueOf(Long.valueOf(numCuenta));
			lista = bancAndes.darOperacionesCliente(numCuenta2);
			resultado = " Bienvenido Cliente, Estos son los prestamos" ;
			panelDatos.actualizarInterfaz(resultado);
			for (OperacionesBancarias a : lista) {
			
			resultado = " id: " + a.getId().toString() + " valor: " + a.getValor().toString() + " fecha: " + a.getFechaHora().toString() + " numero cuenta: " + a.getNumeroCuenta();
			panelDatos.actualizarInterfaz2(resultado);
		}
			
			
		}else {
			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
		}
		
		
		
		
		return lista;

	}
=======

		List <Prestamo> lista = bancAndes.darPrestamos();
		return lista;
>>>>>>> Stashed changes



	}


	public void asociarCuentaNatural() {

		try 
		{	    	

			String numeroIDEmpleadorSrt = JOptionPane.showInputDialog (this, "Ingrese su numero de documento", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);


			if ( numeroIDEmpleadorSrt!= null )
			{

				long numeroIDEmpleadorl = Long.valueOf (numeroIDEmpleadorSrt);			
				BigDecimal numeroIDEmpleador = BigDecimal.valueOf(numeroIDEmpleadorl);

				if (bancAndes.darTipoPersona (numeroIDEmpleadorl).equals("Juridica")) {
					String numeroIDEmpleadoSrt = JOptionPane.showInputDialog (this, "Ingrese el numero de documento del empleado", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);
					long numeroIDEmpleadol = Long.valueOf (numeroIDEmpleadoSrt);
					BigDecimal numeroIDEmpleado = BigDecimal.valueOf(numeroIDEmpleadol);
					if (bancAndes.darTipoPersona (numeroIDEmpleadol).equals("Juridica")) {
						String resultado = "No se puede asociar una cuenta juridica a otra cuenta juridica";				
						resultado += "\n Operaci�n terminada";
						panelDatos.actualizarInterfaz(resultado);
					}
					else {
						String numeroCuentaEmpleadoSrt = JOptionPane.showInputDialog (this, "Ingrese el numero de cuenta del empleado", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);
						long numeroCuentaEmpleado = Long.valueOf (numeroCuentaEmpleadoSrt);						
						if(numeroIDEmpleado.compareTo( bancAndes.darIdClienteNatural(numeroCuentaEmpleado))<0 || numeroIDEmpleado.compareTo( bancAndes.darIdClienteNatural(numeroCuentaEmpleado))>0 ) {
							String resultado = "Esta cuenta no pertenece al empleado";				
							resultado += "\n Operaci�n terminada";
							panelDatos.actualizarInterfaz(resultado);						
						}
						else {
							String numeroCuentaEmpleadorSrt = JOptionPane.showInputDialog (this, "Ingrese el numero de cuenta desde donde realizara los pagos", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);
							long numeroCuentaEmpleador = Long.valueOf (numeroCuentaEmpleadorSrt);
							if(numeroIDEmpleador.compareTo(bancAndes.darIdClienteJuridico(numeroCuentaEmpleador))<0 || numeroIDEmpleador.compareTo(bancAndes.darIdClienteJuridico(numeroCuentaEmpleador))>0 ) {
								String resultado = "Esta cuenta no le pertenece a usted";				
								resultado += "\n Operaci�n terminada";
								panelDatos.actualizarInterfaz(resultado);						
							}
							else {
								String valorAPagarSrt = JOptionPane.showInputDialog (this, "Ingrese valor a pagar", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);
								long valorAPagar = Long.valueOf (valorAPagarSrt);
								if(valorAPagar>0) {
									String frecuenciaPagoSrt = JOptionPane.showInputDialog (this, "Ingrese la frecuencia de pago, mensual o quincenal", "Asociar Cuenta", JOptionPane.QUESTION_MESSAGE);
									long tbEliminados = bancAndes.asociarCuentaNatural (numeroCuentaEmpleado,numeroCuentaEmpleador,valorAPagar,frecuenciaPagoSrt);
									String resultado = "Asociar Cuentaa\n\n";
									resultado += tbEliminados + " cuenta asociada\n";
									resultado += "\n Operaci�n terminada";
									panelDatos.actualizarInterfaz(resultado);
									
								}
								else {
									String resultado = "El valor a pagar tiene que ser mayor a cero";				
									resultado += "\n Operaci�n terminada";
									panelDatos.actualizarInterfaz(resultado);	
								}
							}
						}
					}

				}
				else if (bancAndes.darTipoPersona (numeroIDEmpleadorl).equals("Natural")) {
					String resultado = "Usted no puede realizar esta operacion";				
					resultado += "\n Operaci�n terminada";
					panelDatos.actualizarInterfaz(resultado);

				}
				else
				{
					panelDatos.actualizarInterfaz("Operaci�n cancelada ");
				}
			}
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}


	}






	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecuci�n\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para m�s detalles";
		return resultado;
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

	public void mostrarLogBancAndes ()
	{
		mostrarArchivo ("parranderos.log");
	}

	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}

	public void limpiarLogBancAndes ()
	{
		// Ejecuci�n de la operaci�n y recolecci�n de los resultados
		boolean resp = limpiarArchivo ("bancAndes.log");

		// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

	public void limpiarLogDatanucleus ()
	{
		// Ejecuci�n de la operaci�n y recolecci�n de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generaci�n de la cadena de caracteres con la traza de la ejecuci�n de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
			//				e.printStackTrace();
			return false;
		}
	}

	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
		try 
		{
			Method req = Interfaz.class.getMethod ( evento );			
			req.invoke ( this );
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

	public static void main( String[] args )
	{
		try
		{

			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			Interfaz interfaz = new Interfaz( );
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

}
