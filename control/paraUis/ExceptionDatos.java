package control.paraUis;

public class ExceptionDatos extends Exception{
	String msg;
	public ExceptionDatos(String msg) {
		super(msg);
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	
}
