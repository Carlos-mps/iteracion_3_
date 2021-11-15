package Persistencia;

import java.math.BigDecimal;
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
	 
	 public BigDecimal adicionarPrestamo (PersistenceManager pm,BigDecimal idA, BigDecimal monto, BigDecimal interes, BigDecimal numCuotas,BigDecimal diaPago,String estado,  String tipoPrestamo, BigDecimal idCliente) 
		{
		 
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPrestamo () + "(id, monto, interes, numCuotas, diaPago, estado,tipoPrestamo,idCliente) values (?, ?, ?, ?, ?, ?,?,?)");
	        q.setParameters(idA, monto, interes, numCuotas, diaPago,estado,tipoPrestamo,idCliente);	     
	        return (BigDecimal) q.executeUnique();
		}
	 
	 public long  eliminarPrestamo (PersistenceManager pm,long id ) 
		{
		 
	        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPrestamo () +  " SET ESTADO = 'Cerrado', MONTO = 0 WHERE ID = ?"  );     
	        q.setParameters(id);	        
	        return (long) q.executeUnique();
	        
		}

	public List <Prestamo> darPrestamosGerenteGeneral (PersistenceManager pm)
	{
		System.out.println("paso 3");
		Query q = pm.newQuery(SQL, "SELECT id, monto, interes, numcuotas, diaPago, estado, tipoPrestamo, idCliente FROM " + pp.darTablaPrestamo ()  );
		q.setResultClass(Prestamo.class);
		System.out.println("Paso 4 ----------------------------------------------------------------------------");
		return (List<Prestamo>) q.executeList();
		
		
			}
		
	

	public List <Prestamo> darPrestamosCliente (PersistenceManager pm, BigDecimal idCliente)
	{
		Query q = pm.newQuery(SQL, "SELECT  id, monto, interes, numcuotas, diaPago, estado, tipoPrestamo, idCliente  FROM " + pp.darTablaPrestamo () + " WHERE IDCLIENTE = ?");
		q.setResultClass(Prestamo.class);
		q.setParameters(idCliente);
		return (List<Prestamo>)q.executeList();
	}

}
