package it.cb.biblioteca.exceptions;

public interface ErrorCodes {

	//ERROR_CODE_1 : registration
	public static final String ERROR_CODE_REGISTRATION_WRONG_EMAIL_FORMAT = "ERR1002";

	//ERROR_CODE_2 : noleggio
	public static final String ERROR_CODE_VALIDATION_WRONG_DATE_FORMAT = "ERR2001";
	public static final String ERROR_CODE_VALIDATION_WRONG_ISBN = "ERR2002";
	public static final String ERROR_CODE_VALIDATION_NULL_FIELD = "ERR2003";



	//ERROR_CODE_3 : data

	public static final String ERROR_CODE_DATABASE_CONNECTION_LOST = "ERR3001";
	public static final String ERROR_CODE_DATABASE_GENERIC_ERROR = "ERR3002";

	
	//ERROR_CODE_4 : security
	public static final String ERROR_CODE_SECURITY_WRONG_LOGIN = "ERR4001";
	
	//ERROR_CODE_5 : registration
	public static final String ERROR_CODE_REGISTRATION_NULL_FIELD="ERR5001";
	//ERROR_CODE_6 : registration
	public static final String ERROR_CODE_CUNCURRENT_USER_UPDATE = "ERR6001";
	

	
}
