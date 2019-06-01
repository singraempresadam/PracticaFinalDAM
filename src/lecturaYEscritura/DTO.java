package lecturaYEscritura;

public class DTO <T>{
	private DAO miDao;
	private String path;
	
	public DTO(String path)
	{
		super();
		assert path != null;
		miDao = new DAO();
		this.path = path;
	}
	public T leer() {
		return (T) miDao.leer(this.path);
	}
	public boolean grabar (T t) {
		
		return miDao.grabar(this.path, t);
	}
}
