package Negocio;

import java.sql.Timestamp;

public interface VOOperacionCDT {
	
	
	public long getIdOperacionCDT ();
	
	public String getTipoOpePrestamo ();
	
	public Timestamp getFechaVencimiento ();
	
	public int getTasaRendimiento ();
	
	@Override
	public String toString();
}
