package Negocio;

public interface VOOficina {

	public String getNombre () ;
	
	public String getDireccion ();
	
	public long getNumPuntosAtencion ();
	
	public long  getIdEmpleado ();
	
	@Override
	public String toString ();
}
