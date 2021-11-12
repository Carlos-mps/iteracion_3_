package Negocio;

public interface VOUsuario {

	public long getNumeroDocumento();
	
	public String getTipoDocumento ();
	
	public String getLogin ();
	
	public String getPalabraClave ();
	
	public String getNombre ();
	
	public String getNacionalidad ();
	
	public String getDireccionFisica ();
	
	public String getDireccionElectronica ();
	
	public long getTelefono ();
	
	public String getCiudad ();
	
	public String getDepartamento ();
	
	public long getCodigoPostal ();
	
	@Override
	public String toString ();
}
