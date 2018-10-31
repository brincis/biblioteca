package it.cb.biblioteca.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.model.Bibliotecario;
import it.cb.biblioteca.model.Studente;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.QueryStm;

public class UtenteDao extends GenericDao{

 	public List<UtenteVo> getUtentiCensiti() throws DataException {

		List<UtenteVo> listaUtentiBiblioteca = new ArrayList<UtenteVo>();

		String queryAllUtenti = QueryStm.QUERY_LISTA_UTENTI;
		try {

			Connection conn= getConnection();
			Statement statement = conn.createStatement();
			ResultSet result =  statement.executeQuery(queryAllUtenti);
			
			int id=0;
			String nome = null;
			String cognome = null;
			String usrn = null;
			String pwd = null;
			String cf = null;
			String role = null;
			
			while (result.next()) {
				id= result.getInt("idutente");
				nome=result.getString("nome");
				cognome = result.getString("cognome");
				usrn = result.getString("username");
				pwd = result.getString("password");
				cf = result.getString("cf");	
				role = result.getString("descrizione_ruolo");
				
				UtenteVo user = new UtenteVo();
				if(id!=0) {
					switch(role){
					case "Studente":{
					user = new Studente(nome, cognome,cf, usrn, pwd);		
					user.setId(id);
				    break;
				}
					case "Bibliotecario":{
				    user = new Bibliotecario(nome, cognome,cf, usrn, pwd);
				    user.setId(id);
				    break;
					}case "null":{
				     break;
			    }
			default:{
				user = new UtenteVo(nome, cognome,cf, usrn, pwd);
				//user.setId(id);
                break;
				}
					}
			
					}
				listaUtentiBiblioteca.add(user);
			} 
		}catch (SQLException sqle) {
			throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
		} 
		finally {
			closeConnection();
		}
		//TO DO return utentiCensiti;
		return listaUtentiBiblioteca;
	}

	public UtenteVo findUtenteByUsernameAndPassword(String username, String password) throws DataException {
		UtenteVo retUser = null;
//		String getUtentiQuery = "SELECT * FROM utente WHERE username = '" 
//								+ username 
//								+ "' AND password ='" 
//								+ password
//								+ "'";
		
		String queryGetUtente = "select * from utente where username = ? and password = ?";
		String queryGetRole = "SELECT ruolo.descrizione_ruolo as result " + 
				"FROM umana_biblio.ruolo, umana_biblio.utente, umana_biblio.utente_ruolo " + 
				"WHERE ruolo.idruolo = utente_ruolo.idruolo AND " + 
				"utente_ruolo.idutente = utente.idutente AND " + 
				"utente.username = ? ";
		
		try {

			Connection conn= getConnection();
			PreparedStatement pstatement = conn.prepareStatement(queryGetUtente);
			pstatement.setString(1, username);
			pstatement.setString(2, password);
			ResultSet result =  pstatement.executeQuery();
			
			int id=0;
			String nome = null;
			String cognome = null;
			String usr = null;
			String pwd = null;
			String cf = null;
			String role = null;
			
			while (result.next()) {
				
				id= result.getInt("idutente");
				nome=result.getString("nome");
				cognome = result.getString("cognome");
				usr = result.getString("username");
				pwd = result.getString("password");
				cf = result.getString("cf");				
				break;
			}
			
			PreparedStatement pstatement2 = conn.prepareStatement(queryGetRole);
			pstatement2.setString(1, usr);
			ResultSet result2 =  pstatement2.executeQuery();

			if(result2.next()) {
				role = result2.getString("result");
			}
			if(id!=0) {
			switch(role){
			case "Studente":{
				retUser = new Studente(nome, cognome,cf, usr, pwd);		
				retUser.setId(id);
				break;
				}
			case "Bibliotecario":{
				retUser = new Bibliotecario(nome, cognome,cf, usr, pwd);
				retUser.setId(id);
				break;
			}case "null":{
				break;
			}
			default:{
				retUser = new UtenteVo(nome, cognome,cf, usr, pwd);
				retUser.setId(id);
                break;
			}
			}
			
			}
		} catch (SQLException sqle) {
			throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
		} 
		finally {
			closeConnection();
		}
		

		return retUser;
	}

	public int insertUtente(UtenteVo user) throws SQLException {
		int inserted =0;
		int idUser=0;

		
		try {
		Connection conn = getConnection();
		String queryInsertUser = QueryStm.QUERY_SET_NEW_USER_BY_REG;
		PreparedStatement pStm = conn.prepareStatement(queryInsertUser);	
		

		pStm = conn.prepareStatement(queryInsertUser);
		
		pStm.setNString(1, user.getUsername());
		pStm.setNString(2,user.getPassword());
		pStm.setNString(3, user.getNome());
		pStm.setNString(4, user.getCognome());
		pStm.setNString(5, user.getCf());
		conn.setAutoCommit(false);// apro la TRANSAZIONE!!!
		inserted = pStm.executeUpdate(); 
		
		//devo farmi dire l'id dell'utente inserito in tabella dopo questo statement;
		
		String query = "SELECT idutente FROM umana_biblio.utente WHERE utente.username=? AND utente.password=?";

		pStm = conn.prepareStatement(query);
		pStm.setNString(1, user.getUsername());
		pStm.setNString(2,user.getPassword());
		ResultSet res =  pStm.executeQuery();
		if(res.next()) {
			idUser= res.getInt("idutente");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return idUser;

	}
	 
	
}
