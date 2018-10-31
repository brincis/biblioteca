package it.cb.biblioteca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.exceptions.ValidateException;

public class LocalDateUtils{

	public static final String DATE_FORMAT_STANDARD= "dd/MM/yyyy";
	

	public static LocalDate formatFromStringToDate(String dateStr) throws ValidateException {
		LocalDate retData = null;	
		//SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STANDARD);
		
		try {
		retData = LocalDate.parse(dateStr);
		retData.format(DateTimeFormatter.ofPattern(DATE_FORMAT_STANDARD));
//		retData = sdf.parse(dateStr);
		}catch(Exception e){
			//code di sicurezza dati
			throw new ValidateException(e,ErrorCodes.ERROR_CODE_VALIDATION_WRONG_DATE_FORMAT);
		}
		
//		java.sql.Date data1 = new java.sql.Date(data.getTime());
//		//java.sql.Date data2 = new java.sql.;
//		System.out.println("Datajava util: "+data+" DataSql: "+ data1);
		return retData;
	}
}
