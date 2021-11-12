package Negocio;

public class PuntoDeAtencion implements VOPuntoDeAtencion {
	
	private long id;
	
	private String tipoPuntoAtencion;
	
	private String localizacion;
	
	private String oficina;
	
	
	public PuntoDeAtencion() {
		this.id =0;
		this.tipoPuntoAtencion = "";
		this.localizacion = "";
		this.oficina = "";
	}
	
	public PuntoDeAtencion (long id, String tipoPuntoAtencion, String localizacion, String oficina ) {
		
		this.id = id;
		this.tipoPuntoAtencion = tipoPuntoAtencion;
		this.localizacion = localizacion;
		this.oficina = oficina;
		
	}
	
	
	public long getId () {
		return id;
	}
	public void setId (long id) {
		this.id= id;
	}
	
	public String getTipoPuntoAtencion () {
		return tipoPuntoAtencion;
	}
	
	public void setTipoPuntoAtencion (String tipoPuntoAtencion) {
		this.tipoPuntoAtencion = tipoPuntoAtencion;
	}
	
	public String getLocalizacion () {
		return localizacion;
	}
	
	public void setLocalizacion (String localizacion) {
		this.localizacion = localizacion;

	}
	
	public String getOficina () {
		return oficina;
	}
	
	
	public void setOficina (String oficina) {
		this.oficina = oficina;
	}
	
	@Override
	public String toString () {
		return "PuntoDeAtencion [ id=" + id + ", tipoPuntoAtencion" + tipoPuntoAtencion
				+ ", localizacion" + localizacion + ", oficina" + oficina + "]";
		
		
		
		
	}
	
}
