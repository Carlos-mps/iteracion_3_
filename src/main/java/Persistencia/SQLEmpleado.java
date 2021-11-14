package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Cliente;

public class SQLEmpleado {
	private final static String SQL = PersistenciaBancAndes.SQL;
	private PersistenciaBancAndes pp;


	public SQLEmpleado (PersistenciaBancAndes pp)
	{
	    this.pp = pp;
	}
	public String buscarTipoEmpleadoPorId (PersistenceManager pm, long numeroId) 
	{
	    Query q = pm.newQuery(SQL, "SELECT TIPOEMPLEADO FROM " + pp.darTablaEmpleado() + " WHERE NUMEROID = ?");
	    q.setResultClass(Cliente.class);
	    q.setParameters(numeroId);
	    return (String) q.executeUnique();




	}

}
