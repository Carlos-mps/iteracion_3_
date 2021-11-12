package Negocio;

import java.sql.Date;
import java.sql.Timestamp;

import jdk.jfr.Timespan;

public class Cuenta  implements VOCuenta{

	private long numeroUnico;
	
	private String tipoCuenta;
	
	private int saldo;
	
	private String estado;
	
	private long numeroIdCliente;
	
	private long numeroIdEmpleado;
	
	private Timestamp fechaCreacionCuenta;
	
	private Timestamp fechaUltimoMovimiento; 
	
	
	
	
	
	public Cuenta() {
		this.numeroUnico = 0;
		this.tipoCuenta = "";
		this.saldo = 0;
		this.estado = "";
		this.numeroIdCliente = 0;
		this.numeroIdEmpleado =0;
		this.fechaCreacionCuenta = new Timestamp(0);
		this.fechaUltimoMovimiento = new Timestamp(0);
		
	}
	
	public Cuenta (long numeroUnico, String tipoCuenta, int saldo, String estado, long numeroIdCliente, Timestamp fechaCreacionCuenta, Timestamp fechaUltimoMovimiento ) {
		this.numeroUnico = numeroUnico;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.estado = estado;
		this.numeroIdCliente = numeroIdCliente; 	
		this.fechaCreacionCuenta = fechaCreacionCuenta;
		this.fechaUltimoMovimiento =  fechaUltimoMovimiento;
	}
	
	public Cuenta (long numeroUnico, String tipoCuenta, int saldo, String estado, long numeroIdCliente ) {
		this.numeroUnico = numeroUnico;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.estado = estado;
		this.numeroIdCliente = numeroIdCliente; 	
	
	}

	
	
	public long getNumeroUnico () {
		return numeroUnico;
	}
	public void setNumeroUnico (long numeroUnico) {
		this.numeroUnico = numeroUnico;
	}
	public String getTipoCuenta () {
		return tipoCuenta;
	}
	public void setTipoCuenta (String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public int getSaldo () {
		return saldo;
	}
	public void setSaldo (int saldo) {
		this.saldo = saldo;
	}
	public String getEstado () {
		return estado;
	}
	public void setEstado (String estado) {
		this.estado = estado;
	}
	public long  getNumeroIdCliente () {
		return numeroIdCliente;
	}
	public void setNumeroIdCliente (long numeroIdCliente) {
		this.numeroIdCliente = numeroIdCliente;
	}
	
	public long getNumeroIdEmpleado () {
		return numeroIdEmpleado;
	}
	public void setNumeroIdEmpleado (long numeroIdEmpleado) {
		this.numeroIdEmpleado = numeroIdEmpleado;
	}
	public Timestamp getFechaCreacionCuenta () {
		return fechaCreacionCuenta;
	}
	public void setFechaCreacionCuenta (Timestamp fechaCreacionCuenta) {
		this.fechaCreacionCuenta = fechaCreacionCuenta;
	}
	
	public Timestamp getFechaUltimoMovimiento () {
		return fechaUltimoMovimiento;
	}
	public void setFechaUltimoMovimiento (Timestamp fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}
	
	
	@Override
	public String toString () {
		return "Cuenta[ numeroUnico=" + numeroUnico + ", tipoCuenta=" + tipoCuenta 
				+ ", saldo" + saldo + ", estado" + estado + ", numeroIdCliente" 
				+ numeroIdCliente + ", numeroIdEmpleado" + numeroIdEmpleado 
				+ ", fechaCreacionCuenta=" + fechaCreacionCuenta 
				+ ", fechaUltimoMovimiento" + fechaUltimoMovimiento + "]";
	}
}
