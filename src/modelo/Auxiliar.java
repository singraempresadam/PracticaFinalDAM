package modelo;

public class Auxiliar {
	String dia;
	String hora;
	boolean disponible;
	
	
	public Auxiliar(String dia, String hora, boolean disponible) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.disponible = disponible;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
