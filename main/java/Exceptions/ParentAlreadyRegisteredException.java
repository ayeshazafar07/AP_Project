package Exceptions;
public class ParentAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParentAlreadyRegisteredException(String msg)
	{
		super(msg);
	}
	
}