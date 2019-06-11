package modelo.enumeraciones;

public enum Days {
	lunes(0,"Lunes","MONDAY"),
	Martes(1,"Martes", "TUESDAY"),
	Miercoles(2,"Miercoles", "WEDNESDAY"),
	Jueves(3,"Jueves","THURSDAY"),
	Viernes(4,"Viernes","FRIDAY");
	
	
	private int plusDays;
	private String nombreCastellano;
	private String nombreIngles;
	
	private Days(int plusDays, String nombreCastellano, String nombreIngles) {
		this.setPlusDays(plusDays);
		this.setNombreCastellano(nombreCastellano);
		this.setNombreIngles(nombreIngles);
	}

	public int getPlusDays() {
		return plusDays;
	}

	public void setPlusDays(int plusDays) {
		this.plusDays = plusDays;
	}

	public String getNombreCastellano() {
		return nombreCastellano;
	}

	public void setNombreCastellano(String nombreCastellano) {
		this.nombreCastellano = nombreCastellano;
	}

	public String getNombreIngles() {
		return nombreIngles;
	}

	public void setNombreIngles(String nombreIngles) {
		this.nombreIngles = nombreIngles;
	}
	
	
}
