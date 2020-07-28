package db;

public class DbIntegreityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntegreityException (String msg) {
		super(msg);
	}

}
