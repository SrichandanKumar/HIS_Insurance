package in.Insurance.Exception;

public class NoResourceCreatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoResourceCreatedException() {

		super();
	}

	public NoResourceCreatedException(String msg) {

		super(msg);
	}
}
