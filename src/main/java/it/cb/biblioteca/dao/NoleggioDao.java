package it.cb.biblioteca.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.model.Bibliotecario;
import it.cb.biblioteca.model.LibroBiblioteca;
import it.cb.biblioteca.model.Noleggio;
import it.cb.biblioteca.model.Studente;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.DateUtils;
import it.cb.biblioteca.utils.QueryStm;


public class NoleggioDao extends GenericDao {
	public List<Noleggio> getLibriNoleggiati(UtenteVo utenteVo) throws DataException{
		 List<Noleggio> listaNoleggiUtente= new ArrayList<Noleggio>();	
		 String queryGetLibriNoleggiati=  QueryStm.QUERY_LISTA_LIBRI_NOLEGGIATI_BY_USER;
		 try {
			 	Connection conn = getConnection();
			 	PreparedStatement pstatement = conn.prepareStatement(queryGetLibriNoleggiati);
				pstatement.setLong(1, utenteVo.getId());
				ResultSet result =  pstatement.executeQuery();
				
				int idlibro=0;
				int idnoleggio=0;				
				String isbn = null;
				Date datainizio = null;
				Date datafine = null;
				Noleggio nol= null;
				
				while (result.next()) {
				idnoleggio = result.getInt("idnoleggio");
				idlibro = result.getInt("idlibro");
				isbn = result.getString("isbn");
				datainizio = result.getDate("data_inizio");
				datafine = result.getDate("data_fine");
				nol = new Noleggio(idnoleggio,datainizio.toLocalDate(), datafine.toLocalDate(), utenteVo.getId(),isbn, idlibro);
				listaNoleggiUtente.add(nol);
				result.next();
				}									
			}  catch (SQLException sqle) {
				throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
			} 
			finally {
						closeConnection();
				}
		 return listaNoleggiUtente;
	}

	/**
	 * @author Bri
	 *		metodo che setta il nuovo noleggio update()
	 * @throws DataException 
	 * @throws DataSourceException 
	 */
	public int noleggiaLibroById(int idlibro, LocalDate datainizio, int idutente) throws DataException {

		int inserted = 0;
		String querySetNoleggio = QueryStm.QUERY_SET_NEW_NOLEGGIO_BY_IDUSER_IDLIBRO;
		
		try {
			
		 	Connection conn = getConnection();
			conn.setAutoCommit(false);// apro la TRANSAZIONE!!!
			
			PreparedStatement pStm = conn.prepareStatement(querySetNoleggio);
			pStm.setInt(1, idlibro);
			pStm.setDate(2,java.sql.Date.valueOf(datainizio));
			pStm.setInt(3, idutente);
			inserted = pStm.executeUpdate();
			
			
			// TO DO...
//			if(tms1 != tms2) {
//				conn.rollback();
//			}else {
			conn.commit(); // chiudo la TRANSAZIONE!!!
			inserted = 1;
//			}

		} catch (SQLException sqle) {
			try {
				rollbackTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
		} finally {
			closeConnection();
		}
		return inserted;

	}

	
	public List<Integer> numeroNoleggiTerminati() throws DataException {
		List<Integer> numeroNoleggiTerminati=new ArrayList<Integer>();
		String queryGetNoleggiTerminati=  QueryStm.QUERY_LISTA_NOLEGGI_TERMINATI;
		 Connection conn = null;
		 try {
			 	conn = getConnection();
			 	Statement statement = this.connection.createStatement();
			 	ResultSet result =  statement.executeQuery(queryGetNoleggiTerminati);
						
			 	//HO PROBLEMI CON .next()
				while (result.next()) {
				numeroNoleggiTerminati.add(result.getInt("idnoleggio"));
				}									
			}  catch (SQLException sqle) {
				throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
			} 
			finally {
				closeConnection();		
				}

		return numeroNoleggiTerminati;
	}
	
	public static int cancellaTuttiNoleggiRestituiti() {//update da taskHAndler
		int inserted = 0;
        
		
		
		
		
		
		return inserted;
	}
	
	
}
