package Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.naming.spi.DirStateFactory.Result;

import Negocio.Prestamo;

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

	public List <Prestamo> darPrestamosGerenteGeneral (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrestamo ()  );
		q.setResultClass(Prestamo.class);
		return (List<Prestamo>) q.executeList();
		
	}

	public List <Prestamo> darPrestamosCliente (PersistenceManager pm, long idCliente)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrestamo () + " WHERE IDCLIENTE = ?");
		q.setResultClass(SQLPrestamo.class);
		q.setParameters(idCliente);
		return q.executeList();
	}

}
