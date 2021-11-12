package Negocio;

import java.sql.Timestamp;

public interface VOPrestamo {

	public long getId ();
	
	public long getMonto () ;
	
	public long getInteres ();
	
	public int getNumCuotas ();
	
	public int getDiaPago ();
	
	public String getEstado ();
	
	public String getTipoPrestamo ();
	
	public long getIdCliente ();
	
	public String getOficina ();
	
	@Override
	public String toString ();
}
