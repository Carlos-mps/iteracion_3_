package Negocio;

public class Administrador implements VOAdministrador {
	
	
	private long  numeroIdAdministrador;
	private String tipoDocumentoAdministrador;
	
	
	public Administrador() {
		this.numeroIdAdministrador = 0;
		this.tipoDocumentoAdministrador = "";
		
	}
	
	public Administrador (long numeroIdAdministrador, String tipoDocumentoAdministrador)
	{
		this.numeroIdAdministrador = numeroIdAdministrador;
		this.tipoDocumentoAdministrador = tipoDocumentoAdministrador;
	}

	
	
	public long getNumeroIdAdministrador () {
		return numeroIdAdministrador;
	}
	
	public void setNumeroIdAdministrador (long numeroIdAdministrador) {
		this.numeroIdAdministrador = numeroIdAdministrador;
	}

	public String getTipoDocumentoAdministrador () {
	return tipoDocumentoAdministrador;
	}

	public void setTipoDocumentoAdministrador( String tipoDocumentoAdministrador) {
		this.tipoDocumentoAdministrador = tipoDocumentoAdministrador;
	}
	
	@Override
	public String toString () {
		return "Administrador [ numeroIdAdministrador=" + numeroIdAdministrador 
				+ ", tipoDocumentoAdministrador=" + tipoDocumentoAdministrador + "]";
		
		
	}
	
}




