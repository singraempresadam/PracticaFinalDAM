package modelo.clasesDatos;

import java.io.Serializable;
import java.time.LocalTime;

public class Horario implements Serializable {


	LocalTime horaInicio;
	LocalTime horaFin;
	boolean [] dias;

	
	public Horario(LocalTime horaInicio, LocalTime horaFin, boolean [] dias) {
		super();
		this.setHoraInicio(horaInicio);
		this.setHoraFin(horaFin);
		this.setDias(dias);
	}
	
	public static boolean[][] generarHorario(Horario prueba){
		boolean[][] horario = new boolean[prueba.horaFin.getHour()-prueba.horaInicio.getHour()][5];
		for (int i = 0; i < horario.length; i++) {
			for (int j = 0; j < horario[i].length; j++) {
				horario[i][j]=prueba.dias[j];
			}
		}
		return horario;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public boolean[] getDias() {
		return dias;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		assert horaInicio != null;
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(LocalTime horaFin) {
		assert horaFin != null;
		this.horaFin = horaFin;
	}

	public void setDias(boolean[] dias) {
		assert dias!=null && dias.length>0;
		this.dias = dias;
	}
	
}
