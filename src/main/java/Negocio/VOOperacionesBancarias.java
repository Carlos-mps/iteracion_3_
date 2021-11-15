package Negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface VOOperacionesBancarias {

	public BigDecimal getId ();
	
	public BigDecimal getValor ();
	
	public Timestamp getFechaHora ();
	
	public BigDecimal getNumeroCuenta ();
	
	public long getEmpleado ();
	
	public long getAdministrador ();
	
	//@Override
	//public String toString ();
	
	
	
	
	
}
