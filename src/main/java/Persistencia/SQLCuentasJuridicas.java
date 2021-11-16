package Persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.CuentasJuridicas;

class SQLCuentasJuridicas {
	 
private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLCuentasJuridicas (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarCuenta (PersistenceManager pm,long numeroUnico , String tipoCuenta , int saldo , String estado , long numeroIDCliente ) 
		{
		 
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCuentasJuridicas () + "(numeroUnico, tipoCuenta, saldo, estado, numeroIDCliente, fechaCreacionCuenta) values (?, ?, ?, ?, ?, SYSDATE)");
	        q.setParameters(numeroUnico, tipoCuenta, saldo, estado, numeroIDCliente);	     
	        return (long) q.executeUnique();
		}
	 
	 public long  eliminarCuenta (PersistenceManager pm,long numeroUnico ) 
		{
		 
	        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentasJuridicas () + " SET ESTADO = 'Cerrada', SALDO = 0 WHERE NUMEROUNICO = ?"  );     
	        q.setParameters(numeroUnico);	        
	        return (long) q.executeUnique();
	        
		}

	
	 public CuentasJuridicas darCuentaPorNumeroUnico (PersistenceManager pm, long numeroUnico) 
		{
		 
	        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuentasJuridicas () + " WHERE NUMEROUNICO = ?");
	        q.setResultClass(CuentasJuridicas.class);
	        q.setParameters(numeroUnico);
			return (CuentasJuridicas) q.executeUnique();
			}
	 
	 public BigDecimal darIdClienteJuridico(PersistenceManager pm, long numeroUnico) 
		{

			Query q = pm.newQuery(SQL, "SELECT NUMEROIDCLIENTE FROM " + pp.darTablaCuentasJuridicas () + " WHERE NUMEROUNICO = ?");			
			q.setParameters(numeroUnico);
			return (BigDecimal) q.executeUnique();
		}

	public List<CuentasJuridicas> darCuentaParaCliente(PersistenceManager pm, long numeroIDCliente ){
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuentasJuridicas () + " WHERE NUMEROIDCLIENTE = ?");
	q.setResultClass(CuentasJuridicas.class);
	q.setParameters(numeroIDCliente);
	return (List<CuentasJuridicas>) q.executeList();
	}

	
	

}
