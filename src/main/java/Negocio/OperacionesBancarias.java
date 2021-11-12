package Negocio;
import java.sql.Timestamp;

public class OperacionesBancarias implements VOOperacionesBancarias {

	private long id;
	
	private int valor;
	
	private Timestamp fechaHora;
	
	private long numeroCuenta;
	
	private long empleado;
	
	private long administrador;
	
	
	
	
	
	public OperacionesBancarias() {
		this.id = 0;
		this.valor = 0;
		this.fechaHora = new Timestamp(0);
		this.numeroCuenta = 0;
		this.empleado = 0;
		this.administrador = 0;
	}
	
	
	public OperacionesBancarias (long id, int valor, Timestamp fechaHora, long numeroCuenta, long empleado, long administrador) {
		this.id =  id;
		this.valor = valor;
		this.fechaHora = fechaHora;
		this.numeroCuenta = numeroCuenta;
		this.empleado = empleado;
		this.administrador = administrador;
	}
	
	public long getId () {
		return id;
	}
	public void setId (long id) {
		this.id =    id;
	}
	
	public long getValor () {
		return valor;
	}
	public void setValor (int valor) {
		this.valor = valor;
	}
	
	public Timestamp getFechaHora () {
		return fechaHora;
	}
	public void setFechaHora (Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public long getNumeroCuenta () {
		return numeroCuenta;
	}
	public void setNumeroCuenta (long numeroCuenta) {
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
	
	@Override
	public String toString () {
		return "OperacionesBancarias [id=" + id + ", valor=" + valor + ", fechaHora=" + fechaHora 
				+ ", numeroCuenta=" + numeroCuenta + ", empleado=" + empleado + ", administrador=" 
				+ administrador + "]";
	}
	
	
	
	
}
