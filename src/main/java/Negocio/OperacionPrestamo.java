package Negocio;

public class OperacionPrestamo implements VOOperacionPrestamo{

	private long idOperacionPrestamo;
	
	private String tipoOpePrestamo;
	
	private long idPrestamo;
	
	private int valorPagado;
	
	
	public OperacionPrestamo() {
		this.idOperacionPrestamo = 0;
		this.tipoOpePrestamo = "";
		this.idPrestamo = 0;
		this.valorPagado = 0;
	}
	
	public OperacionPrestamo (long idOperacionPrestamo, String tipoOpePrestamo, long idPrestamo, int valorPagado) {
		this.idOperacionPrestamo = idOperacionPrestamo;
		this.tipoOpePrestamo = tipoOpePrestamo;
		this.idPrestamo = idPrestamo;
		this.valorPagado = valorPagado;
	}
	
	
	public long getIdOperacionPrestamo () {
		return idOperacionPrestamo;
	}
	
	public void setIdOperacionPrestamo (long idOperacionPrestamo ) {
		this.idOperacionPrestamo = idOperacionPrestamo;
	}

	
	public String getTipoOpePrestamo () {
		return tipoOpePrestamo;
	}
	
	public void setTipoOpePrestamo (String tipoOpePrestamo) {
		this.tipoOpePrestamo = tipoOpePrestamo;
	}
	
	
	public long getIdPrestamo () {
		return idPrestamo;
	}
	
	public void setIdPrestamo (long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	
	public int getValorPagado () {
		return valorPagado;
	}
	
	public void setValorPagado (int valorPagado) {
		this.valorPagado = valorPagado;
	}
	
	@Override
	public String toString () {
		return "OperacionPrestamo [idOperacionPrestamo=" + idOperacionPrestamo 
				+ ", tipoOpePrestamo=" + tipoOpePrestamo + ", idPrestamo=" + idPrestamo 
				+ ", valorPagado" + valorPagado + "]";
	}
	
	
	
	
	}
