package Persistencia;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUsuario {
	 
	 private final static String SQL = PersistenciaBancAndes.SQL;
	 
	 private PersistenciaBancAndes pp;
	 
	 public SQLUsuario (PersistenciaBancAndes pp)
		{
			this.pp = pp;
		}
	 
	 public long adicionarUsuario (PersistenceManager pm,long numeroDocumento, String tipoDocumento, String login, String palabraClave, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, long telefono, String ciudad, String departamento, long codigoPostal) 
		{
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario () + "(numeroDocumento, tipoDocumento, login, palabraClave, nombre, nacionalidad, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        q.setParameters(numeroDocumento, tipoDocumento, login, palabraClave, nombre, nacionalidad, direccionFisica, direccionElectronica, telefono, ciudad, departamento, codigoPostal);
	        return (long) q.executeUnique();
		}
	 
	 

}
