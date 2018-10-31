package it.cb.biblioteca.exceptions;

public class AuthenticationException extends BibliotecaException {

	
	private static final long serialVersionUID = 1L;

	public AuthenticationException() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(String message, String errCode) {
		super(message, errCode);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(Throwable cause,String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(String message, Throwable cause,String errorCode) {
		super(message,cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,String errorCode) {
		super(message,cause, enableSuppression, writableStackTrace,errorCode);
		// TODO Auto-generated constructor stub
	}

}
