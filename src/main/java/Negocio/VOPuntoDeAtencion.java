package Negocio;

public interface VOPuntoDeAtencion {

	
	public long getId ();
	
	public String getTipoPuntoAtencion ();
	
	public String getLocalizacion ();
	
	public String getOficina ();
	
	@Override
	public String toString ();
	
	
}
