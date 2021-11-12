package Negocio;

public class Cliente implements VOCliente{

	private long numeroId;
	
	private String tipoPersona;
	
	private String tipoDocumentoUsuario;
	
	
	
	public Cliente() {
		this.numeroId = 0;
		this.tipoPersona ="";
		this.tipoDocumentoUsuario = "";
	}
	
	public Cliente (long numeroId, String tipoPersona, String tipoDocumentoUsuario)
	{
		this.numeroId = numeroId;
		this.tipoPersona = tipoPersona;
		this.tipoDocumentoUsuario = tipoDocumentoUsuario;
		
	}
	
	
	
	public long getNumeroId () {
		return numeroId;
	}
	public void setNumeroId (long numeroId) {
		this.numeroId = numeroId;
	}
	
	public String getTipoPersona () {
		return tipoPersona;	
	}
	
	public void setTipoPersona (String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public String getTipoDocumentoUsusario () {
		return tipoDocumentoUsuario;
	}
	public void setTipoPDocumentoUsuario (String tipoDocumentoUsuario) {
		this.tipoDocumentoUsuario = tipoDocumentoUsuario;
	}
	
	
	
	@Override
	public String toString () {
		return "Cliente [ numeroId=" + numeroId + ", tipoPersona=" + tipoPersona
				+ "tipoDocumentoUsuario=" + tipoDocumentoUsuario + "]";
	}
}
