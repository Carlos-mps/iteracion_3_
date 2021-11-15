package Persistencia;

import java.math.BigDecimal;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;



class SQLUtil {
	
	private final static String SQL = PersistenciaBancAndes.SQL;
	
	private PersistenciaBancAndes pp;
	
	public SQLUtil (PersistenciaBancAndes pp)
	{
		this.pp = pp;
	}
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqBancAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public BigDecimal nextval2 (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqBancAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        BigDecimal resp = (BigDecimal) q.executeUnique();
        return resp;
	}

}
