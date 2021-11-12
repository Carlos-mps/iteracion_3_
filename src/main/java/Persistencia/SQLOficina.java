package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

 class SQLOficina {
	
	private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLOficina (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarOficina (PersistenceManager pm, String nombre , String direccion , long numPuntosAtencion ,  long idEmpleado ) 
		{		 
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOficina () + "(nombre , direccion , numPuntosAtencion , idEmpleado ) values (?, ?, ?, ?)");
	        q.setParameters(nombre ,direccion ,numPuntosAtencion ,idEmpleado );	      
	        return (long) q.executeUnique();
		}
	
		

}
