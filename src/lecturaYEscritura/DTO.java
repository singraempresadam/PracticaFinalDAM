package lecturaYEscritura;

public class DTO <Object>{
	private DAO miDao;
	private String ruta;
	
	public DTO(String ruta)
	{
		super();
		assert ruta != null;
		miDao = new DAO();
		this.ruta = ruta;
	}
	public Object leer() {
		return (Object) miDao.leer(this.ruta);
	}
	public boolean grabar (Object objeto) {
		
		return miDao.grabar(this.ruta, objeto);
	}
}
