package Negocio;

import java.sql.Timestamp;

public class OperacionCDT implements VOOperacionCDT {
	private long idOperacionCDT;
	private String tipoOpeCDT;
	private Timestamp fechaVencimiento;
	private int tasaRendimientos;
	
	
	
	public OperacionCDT() {
	this.idOperacionCDT = 0;
	this.tipoOpeCDT = "";
	this.fechaVencimiento = new Timestamp(0);
	this.tasaRendimientos = 0;
	
	}
	
	
	public OperacionCDT (long idOperacionCDT, String tipoOpeCDT, Timestamp fechaVencimiento, int tasaRendimientos) {
		this.idOperacionCDT = idOperacionCDT;
		this.tipoOpeCDT = tipoOpeCDT;
		this.fechaVencimiento = fechaVencimiento;
		this.tasaRendimientos = tasaRendimientos;
	}
	
	public long getIdOperacionCDT () {
		return idOperacionCDT;
	}
	
	public void setIdOperacionCDT (long idOperacionCDT) {
		this.idOperacionCDT = idOperacionCDT;
	}
	
	public String getTipoOpePrestamo () {
		return tipoOpeCDT;
	}
	public void setTipoOpePrestamo (String tipoOpeCDT) {
		this.tipoOpeCDT = tipoOpeCDT;
	}
	
	public Timestamp getFechaVencimiento () {
		return fechaVencimiento;
	}
	
	public void setFechaVencimiento (Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public int getTasaRendimiento () {
		return tasaRendimientos;
	}
	public void setTasaRendimiento (int tasaRendimientos) {
		this.tasaRendimientos = tasaRendimientos;
	}
	
	
	@Override
	public String toString() {
		return "OperacionCDT [ idOperacionCDT=" + idOperacionCDT + ", tipoOpeCDT=" + tipoOpeCDT
				+ ", fechaVencimiento=" + fechaVencimiento + ", tasaRendimientos=" + tasaRendimientos
				+ "]";
	}
	
	
}
