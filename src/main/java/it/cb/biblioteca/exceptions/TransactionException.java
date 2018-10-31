package it.cb.biblioteca.exceptions;

public class TransactionException extends BibliotecaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionException() {
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String message, String errorCode) {
		super(message, errorCode);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(Throwable cause, String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String message, Throwable cause, String errorCode) {
		super(message, cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public TransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
			String errorCode) {
		super(message, cause, enableSuppression, writableStackTrace, errorCode);
		// TODO Auto-generated constructor stub
	}

}
