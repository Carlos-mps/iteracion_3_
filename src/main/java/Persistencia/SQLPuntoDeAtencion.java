package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLPuntoDeAtencion {
	
	private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLPuntoDeAtencion (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarPuntoDeAtencion (PersistenceManager pm,long id , String tipoPunto , String localizacion , String oficina ) 
		{
		    
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPuntoDeAtencion () + "(id, tipoPuntoAtencion , localizacion, oficina) values (?, ?, ?, ?)");
	        q.setParameters(id, tipoPunto, localizacion, oficina);	     
	        return (long) q.executeUnique();
		}


}
