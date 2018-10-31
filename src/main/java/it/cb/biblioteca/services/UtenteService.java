package it.cb.biblioteca.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import it.cb.biblioteca.dao.RuoloUtenteDao;
import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.exceptions.ConcurrentModificationException;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.QueryStm;

public class UtenteService {

	private List<UtenteVo> getListaUtentiCensiti() throws DataException{
	UtenteDao ud=new UtenteDao();
	return ud.getUtentiCensiti();
	}
	
	public void insertUtente(UtenteVo user) throws DataException, ConcurrentModificationException {
		
		UtenteDao ud=new UtenteDao();
		RuoloUtenteDao ru = new RuoloUtenteDao();
		Connection conn=null;
		try {				
			ud.selectForUpdate(user); // controllo per la concomitanza di pi� transactions
			int idUtente = ud.insertUtente(user);
			//inserire metodo set ruolo
			ru.setRuoloUtente(user, idUtente);
			ru.commitTransaction();
			
			}catch(SQLException sqle) {
				try {
					ru.rollbackTransaction();
				} catch (SQLException e) {
					throw new DataException(sqle,ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
				}
				throw new DataException(sqle,ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
			}
		  finally {
			ru.closeConnection();
				
			}
		
	}
}
