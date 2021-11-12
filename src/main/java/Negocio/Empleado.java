package Negocio;

public class Empleado implements VOEmpleado {
	
	
	private long numeroId;
	private String tipoEmpleado;
	private String tipoDocumentoUsuario;
	
	
	public Empleado() {
		this.numeroId = 0;
		this.tipoEmpleado ="";
		this.tipoDocumentoUsuario = "";
	}

	
	public Empleado (long numeroId, String tipoEmpleado, String tipoDocumentoUsuario) {
		this.numeroId = numeroId;
		this.tipoEmpleado = tipoEmpleado;
		this.tipoDocumentoUsuario = tipoDocumentoUsuario;
	}
	
	
	public long getNumeroId () {
		return numeroId;
	}
	public void setNumeroId (long numeroId) {
		this.numeroId = numeroId;
	}
	
	public String getTipoEmpleado () {
		return tipoEmpleado;	
	}
	
	public void setTipoEmpleado (String tipoEmpleado ) {
		this.tipoEmpleado = tipoEmpleado;
	}
	
	public String getTipoDocumentoUsusario () {
		return tipoDocumentoUsuario;
	}
	public void setTipoPDocumentoUsuario (String tipoDocumentoUsuario) {
		this.tipoDocumentoUsuario = tipoDocumentoUsuario;
	}
	
	
	@Override
	public String toString () {
		return "Cliente [ numeroId=" + numeroId + ", tipoEmpleado=" + tipoEmpleado
				+ "tipoDocumentoUsuario=" + tipoDocumentoUsuario + "]";
	}
	
}
