package Negocio;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.JsonObject;

import Persistencia.PersistenciaBancAndes;

public class BancAndes {
	
	private static Logger log = Logger.getLogger(BancAndes.class.getName());
	
	private PersistenciaBancAndes pp;

	public BancAndes() {
		
		pp = PersistenciaBancAndes.getInstance ();
		
	}
	
	public BancAndes (JsonObject tableConfig)
	{
		pp = PersistenciaBancAndes.getInstance (tableConfig);
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	public Usuario adicionarUsuario(long numeroDocumento, String tipoDocumento, String login, String palabraClave, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, long telefono, String ciudad, String departamento, long codigoPostal)
	{
        log.info ("Adicionando usuario: " + nombre);
        Usuario usuario = pp.adicionarUsuario (numeroDocumento, tipoDocumento, login, palabraClave, nombre, nacionalidad, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal);
        log.info ("Adicionando usuario: " + usuario);
        return usuario;
	}

	
	public Cuenta adicionarCuenta(String tipoCuenta , int saldo  , long numeroIDCliente )
	{
        log.info ("Adicionando cuenta: " );
        Cuenta cuenta = pp.adicionarCuenta (tipoCuenta ,saldo ,numeroIDCliente);
        log.info ("Adicionando cuenta: " + cuenta);
        return cuenta;
	}
	public Prestamo adicionarPrestamo(  long monto, long interes, int numCuotas,int diaPago,  String tipoPrestamo, long idCliente )
	{
        log.info ("Adicionando prestamo: " );
        Prestamo prestamo = pp.adicionarPrestamo (monto, interes, numCuotas, diaPago,tipoPrestamo,idCliente);
        log.info ("Adicionando prestamo: " + prestamo);
        return prestamo;
	}
	
	public PuntoDeAtencion adicionarPuntoDeAtencion( String tipoPunto , String localizacion , String oficina )
	{
        log.info ("Adicionando punto: " );
        PuntoDeAtencion punto = pp.adicionarPuntoDeAtencion (tipoPunto, localizacion, oficina);
        log.info ("Adicionando punto: ");
        return punto;
	}


	// adicionar una oficina
	public Oficina adicionarOficina(String nombre , String direccion , long numPuntosAtencion ,  long idEmpleado)
	{
        log.info ("Adicionando oficina: " + nombre);
        Oficina oficina = pp.adicionarOficina (nombre ,direccion ,numPuntosAtencion ,idEmpleado);
        log.info ("Adicionando oficina: " + oficina);
        return oficina;
	}
	
	// dar cuenta por numero numeroUnico
	public Cuenta darCuentaPorNumero(long numeroUnico)
	{
		log.info ("Buscando cuenta por numero: " + numeroUnico);
		Cuenta cuenta = pp.darCuentaPorNumeroUnico (numeroUnico);
		log.info ("Buscando cuenta por numero: " + cuenta);
		return cuenta;
	}

	
	
	public long eliminarCuenta (long numeroUnico)
	{
        log.info ("Eliminando cuenta por id: " + numeroUnico);
        long resp = pp.eliminarCuenta (numeroUnico);
        log.info ("Eliminando cuenta por Id: " + resp );
        return resp;
	}
	public long eliminarPrestamo (long id)
	{
        log.info ("Eliminando prestamo por id: " + id);
        long resp = pp.eliminarPrestamo (id);
        log.info ("Eliminando prestamo por Id: " + resp );
        return resp;
	}

public List <VOCuenta> darCuentaParaCliente (long numeroIDCliente)
{
	log.info ("Buscando cuentas...");
	List <VOCuenta> cuentas = new LinkedList <VOCuenta> ();
	for (Cuenta cuenta : pp.darCuentaParaCLiente (numeroIDCliente))
	{
		cuentas.add (cuenta);
	}
	log.info ("obteniendo cuentas: " + cuentas.size());
	return cuentas;
}

}
