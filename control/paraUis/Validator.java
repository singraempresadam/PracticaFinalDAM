package control.paraUis;


import control.Controller;
import modelo.clasesDatos.Paciente;
import modelo.clasesDatos.Respuesta;

public class Validator{
	public Respuesta validarDatosPaciente(String datosPaciente, Controller control) throws ExceptionDatos
	{
		String datosFragmentados[]= datosPaciente.split("-");
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		
		Respuesta [] retornoArray= new Respuesta [5];
		try {
			retornoArray[0]=control.getValidatorNombre(datosFragmentados[0]);
			retornoArray[1]=control.getValidatorApellidos(datosFragmentados[1]);
			retornoArray[2]=control.getValidatorTelefono(datosFragmentados[2]);
			retornoArray[3]=control.getValidatorDireccion(datosFragmentados[3]);
			retornoArray[4]=control.getValidatorFechaDeNacimiento(datosFragmentados[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return new Respuesta(false,"Faltan parametros por introducir");
		}
		
		int i=0;
		while(retorno.isResultado() && i < retornoArray.length)
		{
			retorno=retornoArray[i];
			if(!retorno.isResultado()) throw new ExceptionDatos(retorno.getComentario());
			i++;
		}
		return retorno; 
	}

	public Respuesta validarDatosMedico(String datosMedico, Controller control) throws ExceptionDatos{
		String datosFragmentados[]= datosMedico.split("-");
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		
		Respuesta [] retornoArray= new Respuesta [4];
		try {
			retornoArray[0]=control.getValidatorNombre(datosFragmentados[0]);
			retornoArray[1]=control.getValidatorApellidos(datosFragmentados[1]);
			retornoArray[2]=control.getValidatorTelefono(datosFragmentados[2]);
			retornoArray[3]=control.getValidatorDireccion(datosFragmentados[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return new Respuesta(false,"Faltan parametros por introducir");
		}
		
		int i=0;
		while(retorno.isResultado() && i < retornoArray.length)
		{
			retorno=retornoArray[i];
			if(!retorno.isResultado()) throw new ExceptionDatos(retorno.getComentario());
			i++;
		}
		return retorno; 
	}
}
