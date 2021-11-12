package Negocio;



public class Oficina implements VOOficina{
	
	private String nombre;
	
	private String direccion;
	
	private long numPuntosAtencion;
	
	private long idEmpleado;
	
	
	
	
	
	
	
	public Oficina() {
		this.nombre = "";
		this.direccion = "";
		this.numPuntosAtencion = 0;
		this.idEmpleado = 0;
	}
	
	
	public Oficina (String nombre, String direccion, long numPuntosAtencion, long idEmpleado ) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numPuntosAtencion = numPuntosAtencion;
		this.idEmpleado = idEmpleado;
	}

	
	
	public String getNombre () {
		return nombre;
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDireccion () {
		return direccion;
	}
	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	
	public long getNumPuntosAtencion () {
		return numPuntosAtencion;
	}
	
	public void setNumPuntosAtencion (int numPuntosAtencion) {
		this.numPuntosAtencion = numPuntosAtencion;
	}
	
	public long  getIdEmpleado () {
		return idEmpleado;
	}
	
	public void setIdEmpleado (long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	@Override
	public String toString () {
		return "Oficina [ nombre=" + nombre + ", direccion=" + direccion
				+ ", numPuntosAtencion=" + numPuntosAtencion 
				+ ", idEmpleado=" + idEmpleado + "]";
	}
	
	
	
	
	
}
