package control.paraUis;

public class ValidadoresDatos {
	private static void validarFechas() {
		String fecha = "([0][1-9]|[12][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/([1][9][0-9][0-9]|[2][0][0-9][0-9]|[2][1][0][0])";
	}

	private static void validarDomicilio() {
		String domicilio = "^[c][a][l][l][e][ ]|^[a][v][e][n][i][d][a][ ]";
	}

	private static void validarDosisPaciente() {
		String dosis = "[1-9][ ][m][g]|[1-9][ ][g]|[1-9][0-9][ ][m][g]|[1-9][0-9][ ][g]|[1-9][0-9][0-9][ ][m][g]|[1-9][0-9][0-9][ ][g]|[1][0][0][0][ ][m][g]|[1][0][0][0][ ][g]";
		
	}
}
