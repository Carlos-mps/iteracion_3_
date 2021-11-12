package Negocio;

import java.sql.Timestamp;

public interface VOCuenta {

	public long getNumeroUnico ();
	
	public String getTipoCuenta ();
	
	public int getSaldo ();
	
	public String getEstado ();
	
	public long  getNumeroIdCliente ();
	
	public long getNumeroIdEmpleado ();
	
	public Timestamp getFechaCreacionCuenta ();
	
	public Timestamp getFechaUltimoMovimiento ();
	
	@Override
	public String toString ();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
