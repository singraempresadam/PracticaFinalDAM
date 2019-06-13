package modelo.enumeraciones;

public enum Turno {
	mañana(10),
	tarde(16);
	
	private int hora;
	
	private Turno(int hora) {
		this.setHora(hora);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
}
