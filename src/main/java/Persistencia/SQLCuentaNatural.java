package Persistencia;

import java.math.BigDecimal;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCuentaNatural {
	private final static String SQL = PersistenciaBancAndes.SQL;
	private PersistenciaBancAndes pp;

	public SQLCuentaNatural (PersistenciaBancAndes pp) {
		this.pp = pp;
	}

	public long adicionarCuentaNatural (PersistenceManager pm, long numeroUnicoNatural, String tipoCuenta, int saldo, String estado, long numeroIDCliente  ) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCuentaNatural () + "(numeroUnicoNatural, tipoCuenta, saldo, estado, numeroIDCliente, fechaCreacionCuenta) values (?, ?, ?, ?, ?, SYSDATE)");
		q.setParameters(numeroUnicoNatural, tipoCuenta, saldo, estado, numeroIDCliente);	     
		return (long) q.executeUnique();
	}

	public long  eliminarCuentaNatural (PersistenceManager pm,long numeroUnico ) 
	{

		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentaNatural () + " SET ESTADO = 'Cerrada', SALDO = 0 WHERE NUMEROUNICO = ?"  );     
		q.setParameters(numeroUnico);	        
		return (long) q.executeUnique();

	} 

	public BigDecimal darIdClienteNatural(PersistenceManager pm, long numeroUnico) 
	{

		Query q = pm.newQuery(SQL, "SELECT NUMEROIDCLIENTE FROM " + pp.darTablaCuentaNatural () + " WHERE NUMEROUNICONATURAL = ?");	
		q.setParameters(numeroUnico);
		return (BigDecimal) q.executeUnique();
	}
	
	public long asociarCuentaNatural(PersistenceManager pm, long numeroUnicoNatural, long numeroEmpleador, long valorAPagar, String frecuenciaPago) 
	{

		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCuentaNatural () + " SET NUMEROEMPLEADOR = ? , VALORAPAGAR = ? , FRECUENCIAPAGO = ? , FECHAASOCIOACIONCUENTA = SYSDATE WHERE NUMEROUNICONATURAL = ?");		
		q.setParameters(numeroEmpleador,valorAPagar,frecuenciaPago,numeroUnicoNatural);
		return (long) q.executeUnique();
	}


}












