package modelo;

import java.time.LocalTime;

public class Horario {

	LocalTime horaInicio;
	LocalTime horaFin;
	boolean [] dias;
	
	
	public Horario(Horario horario)
	{
		this.horaInicio=horario.horaInicio;
		this.horaFin=horario.horaFin;
		this.dias=horario.dias;
	}
	
	public Horario(LocalTime horaInicio, LocalTime horaFin, boolean [] dias) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dias=dias;
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
	
	/*
	public static void main(String[] args) {
		LocalTime inicio = LocalTime.of(10,0);
		LocalTime fin = LocalTime.of(14, 0);
		boolean diass[] = {true, false, true, false, true};
		Horario prueba = new Horario(inicio, fin, diass);
		boolean [][] probando;
		probando=generarHorario(prueba);
		
		for (int i = 0; i < probando.length; i++) {
			for (int j = 0; j < probando[i].length; j++) {
				System.out.print(probando[i][j] + " ");
			}
			System.out.println();
		}
		
	}*/
}
