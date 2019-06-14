package modelo.clasesDatos;

import java.io.Serializable;

public class Consulta implements Serializable{
	private String idConsulta;
	private boolean[][] libre = new boolean[8][5];
	
	
	public Consulta(String idConsulta, boolean[][] libre) {
		super();
		this.setIdConsulta(idConsulta);
		this.setLibre(libre);
	}
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	public boolean[][] getLibre() {
		return libre;
	}
	public void setLibre(boolean[][] libre) {
		this.libre = libre;
	}
	public void cambiarTurnoMañanaEntero()
	{
		for (int i = 0; i < this.getLibre().length-4; i++) {
			for (int j = 0; j < this.getLibre()[i].length; j++) {
				this.getLibre()[i][j]=false;
			}
		}
	}
	public boolean ComprobarTurnoMañanaEntero()
	{
		boolean retorno=true;
		for (int i = 0; i < this.getLibre().length-4; i++) {
			for (int j = 0; j < this.getLibre()[i].length; j++) {
				if(!this.getLibre()[i][j]) retorno=false;
			}
		}
		return retorno;
	}
	public void cambiarTurnoTardeEntero()
	{
		for (int i = 4; i < this.getLibre().length; i++) {
			for (int j = 0; j < this.getLibre()[i].length; j++) {
				this.getLibre()[i][j]=false;
			}
		}
	}
	public boolean ComprobarTurnoTardeEntero()
	{
		boolean retorno=true;
		for (int i = 4; i < this.getLibre().length; i++) {
			for (int j = 0; j < this.getLibre()[i].length; j++) {
				if(!this.getLibre()[i][j]) retorno=false;
			}
		}
		return retorno;
	}
	
}
