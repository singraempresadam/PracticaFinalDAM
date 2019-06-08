package modelo.clasesDatos;

import java.io.Serializable;
import java.util.regex.Pattern;

public abstract class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6999668079478952039L;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String idUnico;
	public Persona(String nombre,String apellidos, String telefono, String direccion, String idUnico) {
		super();
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setApellidos(apellidos);
		this.setDireccion(direccion);
		this.setIdUnico(idUnico);
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
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
	public void setApellidos(String apellidos) {
		assert apellidos!=null&&validaApellidos(apellidos).isResultado();
		this.apellidos = apellidos;
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
	public static Respuesta validaApellidos(String apellidos) {
		return new Respuesta(Pattern.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$", apellidos), "Los apellidos no cumplen con los requisitos");
	}
	public static Respuesta validaTelefono(String telefono) {
		return new Respuesta(Pattern.matches("[67]\\d{8}", telefono), "El telefono no cumple con los requisitos") ;
	}
	public static Respuesta validaDireccion(String direccion) {
		return new Respuesta(Pattern.matches("^[\\s\\S]{0,30}$", direccion), "El direccion no cumple con los requisitos")   ;
	}
	public static Respuesta validaIdUnico(String idUnico) {
		return new Respuesta(Pattern.matches("\\d{9}", idUnico), "El idUnico no cumple con los requisitos");
	}
}
