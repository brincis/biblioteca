package it.cb.biblioteca.exceptions;

public class BibliotecaException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	public String getErrorCode() {
		return errorCode;
	}
	
	public BibliotecaException() {
	}

	public BibliotecaException(String message,String errorCode) {
		super(message);
		this.errorCode=errorCode;
	}

	public BibliotecaException(Throwable cause,String errorCode) {
		super(cause);
		this.errorCode=errorCode;
	}

	public BibliotecaException(String message, Throwable cause,String errorCode) {
		super(message, cause);
		this.errorCode=errorCode;
	}

	public BibliotecaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,String errorCode) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode=errorCode;
	}

}
