package Negocio;

public class Usuario implements VOUsuario {
	private long numeroDocumento;
	
	private String tipoDocumento;
	
	private String login;
	
	private String palabraClave;
	
	private String nombre;
	
	private String nacionalidad;
	
	private String direccionFisica;
	
	private String direccionElectronica;
	
	private long telefono;
	
	private String ciudad;
	
	private String departamento;
	
	private long codigoPostal;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
		this.numeroDocumento = 0;
		this.tipoDocumento = "";
		this.login = "";
		this.palabraClave = "";
		this.nombre = "";
		this.nacionalidad = "";
		this.direccionFisica = "";
		this.direccionElectronica = "";
		this.telefono = 0;
		this.ciudad = "";
		this.departamento = "";
		this.codigoPostal = 0;
			
	}
	
	public Usuario(long numeroDocumento, String tipoDocumento, String login, String palabraClave, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, long telefono, String ciudad, String departamento, long codigoPostal) {
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.login = login;
		this.palabraClave = palabraClave;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.direccionFisica = direccionFisica;
		this.direccionElectronica = direccionElectronica;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.codigoPostal = codigoPostal;
		
		
	}
	
	
	public long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setId (long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public String getTipoDocumento () {
	return tipoDocumento;
		
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getLogin () {
		return login;
	}
	
	public void setLogin (String login) {
		this.login = login;
	}
	
	public String getPalabraClave () {
		return palabraClave;
	}
	public void setPalabraClave (String palabraClave) {
		this.palabraClave = palabraClave;
	}
	
	public String getNombre () {
		return nombre;
	}
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNacionalidad () {
		return nacionalidad;
	}
	public void setNacionalidad (String nacionalidad) {
		this.nacionalidad= nacionalidad;
	}
	
	public String getDireccionFisica () {
		return direccionFisica;
	}
	public void setDireccionFisica (String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}
	public String getDireccionElectronica () {
		return direccionElectronica;
	}
	public void setDireccionElectronica (String direccionElectronica) {
		this.direccionElectronica = direccionElectronica;
	}
	public long getTelefono () {
		return telefono;
	}
	public void setTelefono (long telefono) {
		this.telefono = telefono;
	}
	
	public String getCiudad () {
		return ciudad;
	}
	public void setCiudad (String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepartamento () {
		return departamento;
	}
	public void setDepartamento (String departamento) {
		this.departamento = departamento;
	}
	
	public long getCodigoPostal () {
		return codigoPostal;
	}
	public void setCodigoPostal (long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Override
	public String toString () {
		return "Usuario [numeroDocumento =" + numeroDocumento + ", tipoDocumento= " + tipoDocumento 
				+ ", login=" + login + ", palabraClave=" + palabraClave 
				+ ", nombre=" + nombre + ",nacionalidad=" + nacionalidad + ", direccionFisica=" 
				+ direccionFisica + ", direccionElectronica=" + direccionElectronica 
				+ ", telefono=" + telefono + ", ciudad=" + ciudad + ", departamento=" + departamento 
				+ ", codigoPostal=" + codigoPostal + "]";
	}

}


