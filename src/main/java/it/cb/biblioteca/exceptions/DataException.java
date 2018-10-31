package it.cb.biblioteca.exceptions;

public class DataException extends BibliotecaException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DataException() {
		// TODO Auto-generated constructor stub
	}

	public DataException(String message, String errCode) {
		super(message, errCode);
		// TODO Auto-generated constructor stub
	}

	public DataException(Throwable cause,String errorCode) {
		super(cause, errorCode);
		// TODO Auto-generated constructor stub
	}

	public DataException(String message, Throwable cause,String errorCode) {
		super(message,cause, errorCode);
		// TODO Auto-generated constructor stub
	}
	public DataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,String errorCode) {
		super(message,cause, enableSuppression, writableStackTrace,errorCode);
		// TODO Auto-generated constructor stub
	}

}
