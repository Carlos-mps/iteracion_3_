package Negocio;

public class OperacionInversion  implements VOOperacionInversion{

	private long idOperacionInversion;
	
	private String  tipoOpeInversion;

	public OperacionInversion() {
		
		this.idOperacionInversion = 0;
		this.tipoOpeInversion = "";
		
	}
	
	public OperacionInversion (long idOperacionInversion, String  tipoOpeInversion) {
		this.idOperacionInversion = idOperacionInversion;
		this.tipoOpeInversion = tipoOpeInversion;
	}
	
	
	public long getIdOperacionInversion () {
		return idOperacionInversion;
	}
	public void setIdOperacionInversion (long idOperacionInversion) {
		this.idOperacionInversion = idOperacionInversion;
	}
	
	public String getTipoOpeInversion () {
		return tipoOpeInversion;
	}
	public void  setTipoOpeInversion (String  tipoOpeInversion) {
		this.tipoOpeInversion = tipoOpeInversion;
	}

	@Override
	public String toString () {
		return "OperacionInversion [ idOperacionInversion=" + idOperacionInversion 
				+ ", tipoOpeInversion" + tipoOpeInversion + "]"; 
	}
}
