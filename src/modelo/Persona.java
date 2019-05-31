package modelo;

public abstract class Persona {
	private String nombre;
	private String telefono;
	private String direccion;
	private String idUnico;
	
	public Persona(String nombre, String telefono, String direccion, String idUnico) {
		super();
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setIdUnico(idUnico);
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getIdUnico() {
		return idUnico;
	}
	public void setIdUnico(String idUnico) {
		this.idUnico = idUnico;
	}
	
}
