package Negocio;

public class CajerosPuntoAtencion implements VOCajerosPuntoAtencion{

	private long idPuntoAtencion ;
	private long idEmpleado;
	
	
	public CajerosPuntoAtencion() {
		this.idEmpleado = 0;
		this.idPuntoAtencion = 0;
	}
	public CajerosPuntoAtencion (long idPuntoAtencion, long idEmpleado) {
		this.idEmpleado = idEmpleado;
		this.idPuntoAtencion = idPuntoAtencion;
	}
	
	public long getIdPuntoAtencion () {
		return idPuntoAtencion;
	}
	public void setIdPuntoAtencion (long idPuntoAtencion) {
		this.idPuntoAtencion = idPuntoAtencion;
	}
	public long getIdEmpleado () {
		return idEmpleado;
	}
	public void setIdEmpleado (long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	@Override
	public String toString () {
		return "CajerosPuntoAtencion [idPuntoAtencion=" + idPuntoAtencion 
				+ ", idEmpleado=" + idEmpleado + "]";
	}

}
