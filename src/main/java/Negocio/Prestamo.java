package Negocio;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Prestamo implements VOPrestamo{
	
	
	private BigDecimal id;
	private BigDecimal monto;
	private BigDecimal interes;
	private BigDecimal numCuotas;
	private BigDecimal diaPago;
	private String estado;
	private String tipoPrestamo;
	private BigDecimal idCliente;
	private String oficina;
	
	
	
	
	public Prestamo() {
		this.id = new BigDecimal(0);
		this.monto = new BigDecimal(0);
		this.interes = new BigDecimal(0);
		this.numCuotas = new BigDecimal(0);
		this.diaPago = new BigDecimal(0);
		this.estado = "";
		this.tipoPrestamo = "";
		this.idCliente = new BigDecimal(0);
		this.oficina = "";
		
	}
	
	
	public Prestamo (BigDecimal id, BigDecimal monto , BigDecimal interes , BigDecimal numCuotas , BigDecimal diaPago,String estado ,  String tipoPrestamo, BigDecimal idCliente, String oficina) {
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
	
	public Prestamo (BigDecimal id, BigDecimal monto, BigDecimal interes, BigDecimal numCuotas, BigDecimal diaPago,String estado,  String tipoPrestamo, BigDecimal idCliente) {
		this.id = id;
		this.monto = monto;
		this.interes = interes ;
		this.numCuotas = numCuotas ;
		this.diaPago = diaPago ;
		this.estado = estado ;
		this.tipoPrestamo = tipoPrestamo ;
		this.idCliente = idCliente;
		
	}
	
	public BigDecimal getId () {
		return id;
	}
	public void setId (BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getMonto () {
		return monto;
	}
	public void setMonto (BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getInteres () {
		return interes;
	}
	
	public void setInteres (BigDecimal interes) {
		this.interes = interes;
	}
	
	public BigDecimal getNumCuotas () {
		return numCuotas;
	}
	public void setNumCuotas ( BigDecimal numCuotas) {
		this.numCuotas = numCuotas ;
	}
	public BigDecimal getDiaPago () {
		return diaPago;
	}
	public void setDiaPago (BigDecimal diaPago) {
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
	public BigDecimal getIdCliente () {
		return idCliente;
	}
	public void setIdCliente ( BigDecimal idCliente) {
		this.idCliente = idCliente;
	}
	public String getOficina () {
		return oficina;
	}
	public void setOficina ( String oficina) {
		this.oficina = oficina;
	}
	
	@Override
	public String toString2 () {
		return "Prestamo [id=" + id + ", monto=" + monto + ", interes" + interes
				+ ", numCuotas=" + numCuotas + ", diaPago" + diaPago 
				+ ", estado" + estado + ", tipoPrestamo=" + tipoPrestamo 
				+ ", idCliente" + idCliente + ", oficina" +  oficina + "]";
	}
	
}
