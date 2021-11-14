package Negocio;

import java.sql.Timestamp;

public class CuentaNatural implements VOCuentaNatural {
	
	private long numeroUnicoNatural;
	private long numeroEmpleador;
	private String tipoCuenta;
	private int saldo;
	private String estado;
	private Timestamp fechaCreacionCuenta;
	private Timestamp fechaUltimoMovimiento; 
	private int valorAPagar;
	private String frecuenciaPago;
	private Timestamp fechaAsocioacionCuenta;
	private long numeroIdCliente;
	
	
public CuentaNatural () {
	this.numeroUnicoNatural = 0;
	this.numeroEmpleador = 0;
	this.tipoCuenta = "";
	this.saldo = 0;
	this.estado = "";
	this.fechaCreacionCuenta = new Timestamp(0);
	this.fechaUltimoMovimiento = new Timestamp(0);
	this.valorAPagar = 0;
	this.frecuenciaPago = "";
	this.fechaAsocioacionCuenta = new Timestamp(0);
	this.numeroIdCliente = 0;
}

public CuentaNatural (long numeroUnicoNatural,long numeroEmpleador, String tipoCuenta,int saldo,String estado, Timestamp fechaCreacionCuenta, Timestamp fechaUltimoMovimiento,int valorAPagar, String frecuenciaPago,Timestamp fechaAsocioacionCuenta, long numeroIdCliente  )
{
	this.numeroUnicoNatural = numeroUnicoNatural;
	this.numeroEmpleador = numeroEmpleador;
	this.tipoCuenta = tipoCuenta;
	this.saldo = saldo;
	this.estado = estado;
	this.fechaCreacionCuenta = fechaCreacionCuenta;
	this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	this.valorAPagar = valorAPagar;
	this.frecuenciaPago = frecuenciaPago;
	this.fechaAsocioacionCuenta = fechaAsocioacionCuenta;
	this.numeroIdCliente = numeroIdCliente;
}

public CuentaNatural (long numeroUnicoNatural, String tipoCuenta, int saldo, String estado, long numeroIdCliente)
{
	this.numeroUnicoNatural = numeroUnicoNatural;
	this.tipoCuenta = tipoCuenta;
	this.saldo = saldo;
	this.estado = estado;
	this.numeroIdCliente = numeroIdCliente; 
}
public long getNumeroUnicoNatural() {
	return numeroUnicoNatural;
}
public void setNumeroUnicoNatural(long numeroUnicoNatural) {
	this.numeroUnicoNatural = numeroUnicoNatural;
}
public long getNumeroEmpleador() {
	return numeroEmpleador;
}
public void setNumeroEmpleador(long numeroEmpleador) {
	this.numeroEmpleador = numeroEmpleador;
}
public String getTipoCuenta() {
	return tipoCuenta;
}
public void setTipoCuenta(String tipoCuenta) {
	this.tipoCuenta = tipoCuenta;
}
public int getSaldo() {
	return saldo;
}
public void setSaldo(int saldo) {
	this.saldo = saldo;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public Timestamp getFechaCreacionCuenta() {
	return fechaCreacionCuenta;
}
public void setFechaCreacionCuenta(Timestamp fechaCreacionCuenta) {
	this.fechaCreacionCuenta = fechaCreacionCuenta;
}
public Timestamp getFechaUltimoMovimiento() {
	return fechaUltimoMovimiento;
}
public void setFechaUltimoMovimiento(Timestamp fechaUltimoMovimiento) {
	this.fechaUltimoMovimiento = fechaUltimoMovimiento;
}
public int getValorAPagar() {
	return valorAPagar;
}
public void setValorAPagar(int valorAPagar) {
	this.valorAPagar = valorAPagar;
}
public String getFrecuenciaPago() {
	return frecuenciaPago;
}
public void setFrecuenciaPago(String frecuenciaPago) {
	this.frecuenciaPago = frecuenciaPago;
}
public Timestamp getFechaAsocioacionCuenta() {
	return fechaAsocioacionCuenta;
}
public void setFechaAsocioacionCuenta(Timestamp fechaAsocioacionCuenta) {
	this.fechaAsocioacionCuenta = fechaAsocioacionCuenta;
}

public long  getNumeroIdCliente () {
	return numeroIdCliente;
}
public void setNumeroIdCliente (long numeroIdCliente) {
	this.numeroIdCliente = numeroIdCliente;
}

@Override
public String toString() {
	return "CuentaNatural [numeroUnicoNatural=" + numeroUnicoNatural + ", numeroEmpleador=" + numeroEmpleador
			+ ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + ", estado=" + estado + ", fechaCreacionCuenta="
			+ fechaCreacionCuenta + ", fechaUltimoMovimiento=" + fechaUltimoMovimiento + ", valorAPagar=" + valorAPagar
			+ ", frecuenciaPago=" + frecuenciaPago + ", fechaAsocioacionCuenta=" + fechaAsocioacionCuenta + "]";
}




}



