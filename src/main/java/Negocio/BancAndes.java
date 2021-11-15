package Negocio;

import java.math.BigDecimal;
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

	
	public CuentasJuridicas adicionarCuentaJuridica(String tipoCuenta , int saldo  , long numeroIDCliente )
	{
        log.info ("Adicionando cuenta: " );
        CuentasJuridicas cuenta = pp.adicionarCuentaJuridica (tipoCuenta ,saldo ,numeroIDCliente);
        log.info ("Adicionando cuenta: " + cuenta);
        return cuenta;
	}
	
	public CuentaNatural adicionarCuentaNatural(String tipoCuenta , int saldo  , long numeroIDCliente )
	{
        log.info ("Adicionando cuenta: " );
        CuentaNatural cuenta = pp.adicionarCuentaNatural (tipoCuenta ,saldo ,numeroIDCliente);
        log.info ("Adicionando cuenta: " + cuenta);
        return cuenta;
	}
	public Prestamo adicionarPrestamo(  BigDecimal monto, BigDecimal interes, BigDecimal numCuotas,BigDecimal diaPago,  String tipoPrestamo, BigDecimal idCliente )
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
	public CuentasJuridicas darCuentaPorNumero(long numeroUnico)
	{
		log.info ("Buscando cuenta por numero: " + numeroUnico);
		CuentasJuridicas cuenta = pp.darCuentaPorNumeroUnico (numeroUnico);
		log.info ("Buscando cuenta por numero: " + cuenta);
		return cuenta;
	}

	
	
	public long eliminarCuentaJuridica (long numeroUnico)
	{
        log.info ("Eliminando cuenta por id: " + numeroUnico);
        long resp = pp.eliminarCuentaJuridica (numeroUnico);
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
	for (CuentasJuridicas cuenta : pp.darCuentaParaCLiente (numeroIDCliente))
	{
		cuentas.add (cuenta);
	}
	log.info ("obteniendo cuentas: " + cuentas.size());
	return cuentas;
}
public Cliente darClientePorNumero (long numeroIDCliente)
{
	log.info ("Buscando cliente por numero: " + numeroIDCliente);
	Cliente cliente = pp.darCliente (numeroIDCliente);
	log.info ("Buscando cliente por numero: " + cliente);
	return cliente;

}

public String darTipoPersona (long numeroId)
{
	log.info ("Buscando tipo de persona por numero: " + numeroId);
	String tipo = pp.darTipoPersona (numeroId);
	log.info ("Buscando tipo de persona por numero: " + tipo);
	return tipo;
}

public String buscarTipoEmpleado (long numeroId)
{
	log.info ("Buscando tipo de empleado por numero: " + numeroId);
	String tipo = pp.buscarTipoEmpleadoId(numeroId);
	log.info ("Buscando tipo de empleado por numero: " + tipo);
	return tipo;
}

public List <Prestamo> darPrestamos (){
	log.info ("Buscando Prestamos");
	return pp.darPrestamos();
}
public List <OperacionesBancarias> darOperacionesBancarias (){
	log.info ("Buscando Operaciones Bancarias");
	System.out.println("paso 2.1-------------------------------------------");
	return pp.darOperacionesBancarias();
}

public List <OperacionesBancarias> darOperacionesCliente (BigDecimal numeroCuenta){
	log.info ("Buscando Operaciones Bancarias");
	System.out.println("paso 2.1-------------------------------------------");
	return pp.darOperacionesCliente(numeroCuenta);
}

public List <Prestamo> darPrestamosCliente (BigDecimal numeroIDCDecimal){
	log.info ("Buscando Prestamos");
	return pp.darPrestamosCliente( numeroIDCDecimal);
}



}
