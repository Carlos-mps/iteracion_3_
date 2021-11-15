package Negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface VOPrestamo {

	public BigDecimal getId ();
	
	public BigDecimal getMonto () ;
	
	public BigDecimal getInteres ();
	
	public BigDecimal getNumCuotas ();
	
	public BigDecimal getDiaPago ();
	
	public String getEstado ();
	
	public String getTipoPrestamo ();
	
	public BigDecimal getIdCliente ();
	
	public String getOficina ();
	
	public String toString2 ();
	
}
