package Negocio;

public class OperacionCuenta  implements VOOperacionCuenta{

	
	private long idOperacionCuenta;
	
	private String tipoOpeCuenta;
	
	
	
	public OperacionCuenta() {
		
		this.idOperacionCuenta = 0;
		this.tipoOpeCuenta = "";
	}
	
	public OperacionCuenta (long idOperacionCuenta, String tipoOpeCuenta) {
		this.idOperacionCuenta = idOperacionCuenta;
		this.tipoOpeCuenta = tipoOpeCuenta;
	}

	
	public long getIdOperacionCuenta () {
		return idOperacionCuenta;
	}
	
	public void setIdOperacionCuenta (long idOperacionCuenta) {
		this.idOperacionCuenta = idOperacionCuenta;
	}
	
	public String getTipoOpeCuenta () {
		return tipoOpeCuenta;
	}
	
	public void setTipoOpeCuenta (String tipoOpeCuenta) {
		this.tipoOpeCuenta = tipoOpeCuenta;
	}
	
	@Override
	public String toString () {
		return "OperacionCuenta [ idOperacionCuenta=" + idOperacionCuenta 
				+ ", tipoOpeCuenta=" + tipoOpeCuenta + "]";
	}
	
}
