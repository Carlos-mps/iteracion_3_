package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLPrestamo {
	
	private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLPrestamo (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarPrestamo (PersistenceManager pm,long id, long monto, long interes, int numCuotas,int diaPago,String estado,  String tipoPrestamo, long idCliente) 
		{
		 
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPrestamo () + "(id, monto, interes, numCuotas, diaPago, estado,tipoPrestamo,idCliente) values (?, ?, ?, ?, ?, ?,?,?)");
	        q.setParameters(id, monto, interes, numCuotas, diaPago,estado,tipoPrestamo,idCliente);	     
	        return (long) q.executeUnique();
		}
	 
	 public long  eliminarPrestamo (PersistenceManager pm,long id ) 
		{
		 
	        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPrestamo () +  " SET ESTADO = 'Cerrado', MONTO = 0 WHERE ID = ?"  );     
	        q.setParameters(id);	        
	        return (long) q.executeUnique();
	        
		}

}
