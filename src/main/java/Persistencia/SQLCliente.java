package Persistencia;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import Negocio.Cliente;
public class SQLCliente {
private final static String SQL = PersistenciaBancAndes.SQL;
private PersistenciaBancAndes pp;


public SQLCliente (PersistenciaBancAndes pp)
{
    this.pp = pp;
}

//metodo que busca un cliente por su numeroId
public Cliente buscarClientePorId (PersistenceManager pm, long numeroId) 
{
    Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente() + " WHERE NUMEROID = ?");
    q.setResultClass(Cliente.class);
    q.setParameters(numeroId);
    return (Cliente) q.executeUnique();




}
public String darTipoPersona (PersistenceManager pm, long numeroId) 
		{
		 
	        Query q = pm.newQuery(SQL, "SELECT TIPOPERSONA FROM " + pp.darTablaCliente () + " WHERE NUMEROID = ?");
	        q.setResultClass(String.class);
	        q.setParameters(numeroId);
			return (String) q.executeUnique();
			}
		

}