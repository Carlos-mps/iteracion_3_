package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCuentaNatural {
	private final static String SQL = PersistenciaBancAndes.SQL;
	 private PersistenciaBancAndes pp;
	 
	 public SQLCuentaNatural (PersistenciaBancAndes pp) {
		 this.pp = pp;
	 }
	 
	 public long adicionarCuentaNatural (PersistenceManager pm, long numeroUnicoNatural, String tipoCuenta, int saldo, String estado, long numeroIDCliente  ) {
		 Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCuentaNatural () + "(numeroUnico, tipoCuenta, saldo, estado, numeroIDCliente, fechaCreacionCuenta) values (?, ?, ?, ?, ?, SYSDATE)");
	        q.setParameters(numeroUnicoNatural, tipoCuenta, saldo, estado, numeroIDCliente);	     
	        return (long) q.executeUnique();
	 }
	 
	 public long  eliminarCuentaNatural (PersistenceManager pm,long numeroUnico ) 
		{
		 
	        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentaNatural () + " SET ESTADO = 'Cerrada', SALDO = 0 WHERE NUMEROUNICO = ?"  );     
	        q.setParameters(numeroUnico);	        
	        return (long) q.executeUnique();
	        
		} 

	

	
	 
	 
	
	
	
	
	
	
	
}
