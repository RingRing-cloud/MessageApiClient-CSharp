package be.ringring.message.exception;

/**
 * The class {@link MessageException} is a form of Throwable that indicates conditions that a reasonable application might want to catch.<br />
 * <u>This is a checked exception :</u> it means that the exception need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
**/
public class MessageException extends Exception {

	private static final long serialVersionUID = 467608285393991692L;

	/** 
	 * The {@link Error} who provide precision about the exception.
	**/
	
	private Error error;
	
	/**
	 * Constructs a new MessageException with the specified {@link Error}. The Original cause is not saved. 
	 * @param error The {@link Error} of the exception.
	**/
	
	public MessageException(Error error) {
		this(error, null);
	}
	
	/**
	 * Constructs a new MessageException with the specified cause and a detailed {@link Error}
	 * @param error The {@link Error of the exception}
	 * @param t The throwable
	**/
	
	public MessageException(Error error, Throwable cause) {
		super(cause);
		this.error = error;
	}
	
	/**
	 * Get the {@link Error} of the MessageException.
	 * @return Return the {@link Error} who have been raised with the exception. 
	**/
	
	public Error getError() {
		return this.error;
	}
	
}
