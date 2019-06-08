package modelo.clasesDatos;

public class Respuesta {
	private boolean resultado;
	private String comentario;
	
	public Respuesta (boolean resultado, String comentario)
	{
		super();
		this.setComentario(comentario);
		this.setResultado(resultado);
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
