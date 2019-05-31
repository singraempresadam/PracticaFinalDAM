package modelo;

public class Horario {

	Auxiliar [][] horario ;
	
	public Horario(String[] dias, String[] horas)
	{
		horario=new Auxiliar [horas.length][dias.length];
		for (int i = 0; i < dias.length; i++) {
			for (int j = 0; j < horas.length; j++) {
				horario[i][j]=new Auxiliar( dias[i], horas[i],false);
			}
		}
	}
}
