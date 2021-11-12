package Negocio;

public interface VOOperacionPrestamo {

	
	public long getIdOperacionPrestamo ();
	
	public String getTipoOpePrestamo ();
	
	public long getIdPrestamo ();
	
	public int getValorPagado ();

	@Override
	public String toString ();
	
}
