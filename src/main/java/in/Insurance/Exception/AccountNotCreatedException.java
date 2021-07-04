package in.Insurance.Exception;

public class AccountNotCreatedException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AccountNotCreatedException() {
		
	}
	
	
	public AccountNotCreatedException(String msg) {
	
		super(msg);
	}
	
}
