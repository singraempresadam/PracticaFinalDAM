package modelo;

import java.util.regex.Pattern;

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
	public String getTelefono() {
		return telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getIdUnico() {
		return idUnico;
	}
	
	public void setNombre(String nombre) { 
		assert nombre!=null&&validaNombre(nombre).isResultado();
		this.nombre = nombre;
	}
	public void setTelefono(String telefono) {
		assert telefono!=null&&validaTelefono(telefono).isResultado();
		this.telefono = telefono;
	}
	public void setDireccion(String direccion) {
		assert direccion!=null&&validaDireccion(direccion).isResultado();
		this.direccion = direccion;
	}
	public void setIdUnico(String idUnico) {
		assert idUnico!=null&&validaIdUnico(idUnico).isResultado();
		this.idUnico = idUnico;
	}
	
//VALIDADORES
	
	public static Respuesta validaNombre(String nombre) {
		return new Respuesta(Pattern.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$", nombre), "El nombre no cumple con los requisitos");
	}
	public static Respuesta validaTelefono(String telefono) {
		return new Respuesta(Pattern.matches("[67]\\d{8}", telefono), "El telefono no cumple con los requisitos") ;
	}
	public static Respuesta validaDireccion(String direccion) {
		return new Respuesta(Pattern.matches("{30}", direccion), "El direccion no cumple con los requisitos")  ;
	}
	public static Respuesta validaIdUnico(String idUnico) {
		return new Respuesta(Pattern.matches("\\d{9}", idUnico), "El idUnico no cumple con los requisitos");
	}
}
