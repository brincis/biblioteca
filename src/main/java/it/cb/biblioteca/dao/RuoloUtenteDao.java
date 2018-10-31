package it.cb.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.cb.biblioteca.model.UtenteVo;

public class RuoloUtenteDao extends GenericDao{

	public int setRuoloUtente(UtenteVo user, int idUtente) throws SQLException {
		
		Connection conn= getConnection();
		int inserted =0;
		
		try {
		String role = user.getUserRole();
		int idruolo=0;
		if(idUtente!=0) {
			switch(role){
			case "studente":{
				idruolo=1;
			}
			case "bibliotecario":{
				idruolo=2;
		    break;
			}
			}
		}
		//chiedere come fare questa query
		String querySetRuolo = "INSERT into umana_biblio.utente_ruolo (idutente,idruolo) values ('?','?')";
		PreparedStatement pStm = conn.prepareStatement(querySetRuolo);				
		pStm.setInt(1, idUtente);
		pStm.setInt(2,idruolo);
		inserted = pStm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//set Ruolo per id in tab ruoloutnete
		return inserted;
	}
}

