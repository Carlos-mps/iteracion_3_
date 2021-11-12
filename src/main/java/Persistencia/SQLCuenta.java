package Persistencia;
import Negocio.Cuenta;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


class SQLCuenta {
	 
private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLCuenta (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarCuenta (PersistenceManager pm,long numeroUnico , String tipoCuenta , int saldo , String estado , long numeroIDCliente ) 
		{
		 
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCuenta () + "(numeroUnico, tipoCuenta, saldo, estado, numeroIDCliente, fechaCreacionCuenta) values (?, ?, ?, ?, ?, SYSDATE)");
	        q.setParameters(numeroUnico, tipoCuenta, saldo, estado, numeroIDCliente);	     
	        return (long) q.executeUnique();
		}
	 
	 public long  eliminarCuenta (PersistenceManager pm,long numeroUnico ) 
		{
		 
	        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuenta () + " SET ESTADO = 'Cerrada', SALDO = 0 WHERE NUMEROUNICO = ?"  );     
	        q.setParameters(numeroUnico);	        
	        return (long) q.executeUnique();
	        
		}

	
	 public Cuenta darCuentaPorNumeroUnico (PersistenceManager pm, long numeroUnico) 
		{
		 
	        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta () + " WHERE NUMEROUNICO = ?");
	        q.setResultClass(Cuenta.class);
	        q.setParameters(numeroUnico);
			return (Cuenta) q.executeUnique();
			}

	public List<Cuenta> darCuentaParaCliente(PersistenceManager pm, long numeroIDCliente ){
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCuenta () + " WHERE NUMEROIDCLIENTE = ?");
	q.setResultClass(Cuenta.class);
	q.setParameters(numeroIDCliente);
	return (List<Cuenta>) q.executeList();
	}


}
