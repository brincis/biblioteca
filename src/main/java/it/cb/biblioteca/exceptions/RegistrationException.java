package it.cb.biblioteca.exceptions;

public class RegistrationException extends BibliotecaException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationException() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationException(String message, String errCode) {
		super(message, errCode);
		// TODO Auto-generated constructor stub
	}

	public RegistrationException(Throwable cause,String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public RegistrationException(String message, Throwable cause,String errorCode) {
		super(message,cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public RegistrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,String errorCode) {
		super(message,cause, enableSuppression, writableStackTrace,errorCode);
		// TODO Auto-generated constructor stub
	}

}
