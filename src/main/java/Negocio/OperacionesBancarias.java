package Negocio;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OperacionesBancarias implements VOOperacionesBancarias {

	private BigDecimal id;
	
	private BigDecimal valor;
	
	private Timestamp fechaHora;
	
	private BigDecimal numeroCuenta;
	
	private long empleado;
	
	private long administrador;
	
	
	
	
	
	public OperacionesBancarias() {
		this.id = new BigDecimal(0);
		this.valor = new BigDecimal(0);
		this.fechaHora = new Timestamp(0);
		this.numeroCuenta = new BigDecimal(0);
		this.empleado = 0;
		this.administrador = 0;
	}
	
	
	public OperacionesBancarias (BigDecimal id, BigDecimal valor, Timestamp fechaHora, BigDecimal numeroCuenta, long empleado, long administrador) {
		this.id =  id;
		this.valor = valor;
		this.fechaHora = fechaHora;
		this.numeroCuenta = numeroCuenta;
		this.empleado = empleado;
		this.administrador = administrador;
	}
	
	public BigDecimal getId () {
		return id;
	}
	public void setId (BigDecimal id) {
		this.id =    id;
	}
	
	public BigDecimal getValor () {
		return valor;
	}
	public void setValor (BigDecimal valor) {
		this.valor = valor;
	}
	
	public Timestamp getFechaHora () {
		return fechaHora;
	}
	public void setFechaHora (Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public BigDecimal getNumeroCuenta () {
		return numeroCuenta;
	}
	public void setNumeroCuenta (BigDecimal numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public long getEmpleado () {
		return empleado;
	}
	public void setEmpleado (long empleado) {
		this.empleado =  empleado;
	}
	public long getAdministrador () {
		return administrador;
	}
	public void setAdministrador (long administrador) {
		this.administrador = administrador;
	}
	
	/*@Override
	public String toString () {
		return "OperacionesBancarias [id=" + id + ", valor=" + valor + ", fechaHora=" + fechaHora 
				+ ", numeroCuenta=" + numeroCuenta + ", empleado=" + empleado + ", administrador=" 
				+ administrador + "]";
	}
	
	*/
	
	
}
