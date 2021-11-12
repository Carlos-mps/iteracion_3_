package Negocio;

public class OperacionAcciones  implements VOOperacionAcciones{

	private long idOperacionAcciones;
	private int numAciones;
	private String TipoOpeAcciones;
	
	
	
	
	public OperacionAcciones() {
		 this.idOperacionAcciones = 0;
		 this.numAciones = 0;
		 this.TipoOpeAcciones = "";
	}
	
	public OperacionAcciones (long idOperacionesAcciones, int numAciones, String TipoOpeAcciones) {
		this.idOperacionAcciones = idOperacionesAcciones;
		this.numAciones = numAciones;
		this.TipoOpeAcciones = TipoOpeAcciones;
		
	}
	
	
	
	public long getIdOperacionAcciones () {
		return idOperacionAcciones;
	}
	
	public void setIdOperacionAcciones (long idOperacionesAcciones) {
		this.idOperacionAcciones = idOperacionesAcciones;
	}
	
	
	public int getNumAcciones () {
		return numAciones;
	}
	
	public void setNumAcciones (int numAciones) {
		this.numAciones = numAciones;
	}
	
	public String getTipoOpeAcciones () {
		return TipoOpeAcciones;
	}
	
	public void setTipoOpeAcciones (String TipoOpeAcciones) {
		this.TipoOpeAcciones = TipoOpeAcciones;
	}
	
	@Override
	public String toString () {
		return "OperacionAcciones [ idOperacionAcciones=" + idOperacionAcciones + ", numAcciones"
				+ numAciones + ", TipoOpeAcciones=" + TipoOpeAcciones + "]";
	}

}
