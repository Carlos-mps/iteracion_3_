package Negocio;

public class CuotaMinimaPrestamo implements VOCuotaMinimaPrestamo {

	private long idPrestamo;
	
	private long valorCuotaMinima;
	
	
	
	public CuotaMinimaPrestamo() {
		this.idPrestamo = 0;
		this.valorCuotaMinima = 0;
	}
	
	public CuotaMinimaPrestamo (long idPrestamo, long valorCuotaMinima) {
		this.idPrestamo = idPrestamo;
		this.valorCuotaMinima = valorCuotaMinima;
	}
	
	public long getIdPrestamo () {
		return idPrestamo;
	}
	public void setIdPrestamo (long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public long getValorCuotaMinima () {
		return valorCuotaMinima;
	}
	public void setValorCuotaMinima (long valorCuotaMinima) {
		this.valorCuotaMinima = valorCuotaMinima;
	}
	
	@Override
	public String toString () {
		return "CuotaMinimaPrestamo [idPrestamo=" + idPrestamo
				+ ", valorCuotaMinimaPrestamo" + valorCuotaMinima
				+ "]";
	}
}
