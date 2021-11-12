package Negocio;

import java.sql.Timestamp;

public class Prestamo implements VOPrestamo{
	
	
	private long id;
	private long monto;
	private long interes;
	private int numCuotas;
	private int diaPago;
	private String estado;
	private String tipoPrestamo;
	private long idCliente;
	private String oficina;
	
	
	
	
	public Prestamo() {
		this.id = 0;
		this.monto = 0;
		this.interes = 0;
		this.numCuotas = 0;
		this.diaPago = 0;
		this.estado = "";
		this.tipoPrestamo = "";
		this.idCliente = 0;
		this.oficina = "";
	}
	
	
	public Prestamo (long id, long monto, long interes, int numCuotas,int diaPago,String estado,  String tipoPrestamo, long idCliente, String oficina) {
		this.id = id;
		this.monto = monto;
		this.interes = interes ;
		this.numCuotas = numCuotas ;
		this.diaPago = diaPago ;
		this.estado = estado ;
		this.tipoPrestamo = tipoPrestamo ;
		this.idCliente = idCliente;
		this.oficina = oficina;
	}
	
	public Prestamo (long id, long monto, long interes, int numCuotas,int diaPago,String estado,  String tipoPrestamo, long idCliente) {
		this.id = id;
		this.monto = monto;
		this.interes = interes ;
		this.numCuotas = numCuotas ;
		this.diaPago = diaPago ;
		this.estado = estado ;
		this.tipoPrestamo = tipoPrestamo ;
		this.idCliente = idCliente;
		
	}
	
	public long getId () {
		return id;
	}
	public void setId (long id) {
		this.id = id;
	}
	public long getMonto () {
		return monto;
	}
	public void setMonto (long monto) {
		this.monto = monto;
	}
	public long getInteres () {
		return interes;
	}
	
	public void setInteres (long interes) {
		this.interes = interes;
	}
	
	public int getNumCuotas () {
		return numCuotas;
	}
	public void setNumCuotas ( int numCuotas) {
		this.numCuotas = numCuotas ;
	}
	public int getDiaPago () {
		return diaPago;
	}
	public void setDiaPago (int diaPago) {
		this.diaPago = diaPago ;
	}
	public String getEstado () {
		return estado;
	}
	public void setEstado (String estado) {
		this.estado = estado ;
	}
	public String getTipoPrestamo () {
		return tipoPrestamo;
	}
	public void setTipoPrestamo (String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo ;
	}
	public long getIdCliente () {
		return idCliente;
	}
	public void setIdCliente ( long idCliente) {
		this.idCliente = idCliente;
	}
	public String getOficina () {
		return oficina;
	}
	public void setOficina ( String oficina) {
		this.oficina = oficina;
	}
	
	@Override
	public String toString () {
		return "Prestamo [id=" + id + ", monto=" + monto + ", interes" + interes
				+ ", numCuotas=" + numCuotas + ", diaPago" + diaPago 
				+ ", estado" + estado + ", tipoPrestamo=" + tipoPrestamo 
				+ ", idCliente" + idCliente + ", oficina" +  oficina + "]";
	}
	
}
