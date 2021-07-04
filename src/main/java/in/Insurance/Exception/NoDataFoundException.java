package in.Insurance.Exception;

public class NoDataFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
	super();
	}
	
	public NoDataFoundException(String msg) {
		super(msg);
		}
	
}
