package Negocio;

import java.sql.Timestamp;

public interface VOOperacionesBancarias {

	public long getId ();
	
	public long getValor ();
	
	public Timestamp getFechaHora ();
	
	public long getNumeroCuenta ();
	
	public long getEmpleado ();
	
	public long getAdministrador ();
	
	@Override
	public String toString ();
	
	
	
	
	
}
