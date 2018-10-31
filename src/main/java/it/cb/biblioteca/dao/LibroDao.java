package it.cb.biblioteca.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.model.BaseMapper;
import it.cb.biblioteca.model.Libro;

public class LibroDao extends GenericDao{
	
	public BaseMapper findLibroBibliotecaByISBN(String isbn) throws DataException{
		// List<LibroBiblioteca> listaLibroBibliotecaByISBN= new ArrayList<LibroBiblioteca>();	
		 String queryGetLibriDisponibiliByISBN = "SELECT libro.* FROM umana_biblio.libro\n" + 
		 		"WHERE libro.isbn=?" ;
		 Libro libroByIsbn=null;
		 
		 try {
			 	Connection conn = getConnection();
				PreparedStatement pstatement = conn.prepareStatement(queryGetLibriDisponibiliByISBN);
				pstatement.setString(1, isbn);
				ResultSet result =  pstatement.executeQuery();
						
				int idlibro=0;
				String titolo=null;
				String autore=null;
				String isbndb=null;
				
				while (result.next()) {
					result.getInt("idlibro");
					result.getString("titolo");
					result.getString("autore");
					result.getString("isbn");
					break;
				}	
				libroByIsbn = new Libro(titolo,autore,isbndb);
				libroByIsbn.setIdlibro(idlibro);
				
			}  catch (SQLException sqle) {
				throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
			} 
			finally {
				closeConnection();
			}
		 return libroByIsbn;
	}

	public HashMap<String,ArrayList<Integer>> avaiabilityLibroBibliotecaByISBN(String isbn) throws DataException{
		// List<LibroBiblioteca> listaLibroBibliotecaByISBN= new ArrayList<LibroBiblioteca>();
		HashMap<String,ArrayList<Integer>> mappaLibroByISBN = new HashMap<String,ArrayList<Integer>>();
		 String queryGetLibriDisponibiliByISBN = "SELECT libro.* FROM umana_biblio.libro,umana_biblio.librobiblioteca, umana_biblio.noleggio\n" + 
		 		"		 WHERE libro.isbn=? AND librobiblioteca.idnoleggio=noleggio.idnoleggio";
		 try {
			 	Connection conn = getConnection();
				PreparedStatement pstatement = conn.prepareStatement(queryGetLibriDisponibiliByISBN);
				pstatement.setString(1, isbn);
				ResultSet result =  pstatement.executeQuery();
				List<Integer> idLibriByISBN  = new ArrayList<Integer>();				
				while (result.next()) {
					idLibriByISBN.add(result.getInt("idlibro"));
				break;
				}									
			}  catch (SQLException sqle) {
				throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_GENERIC_ERROR);
			} 
			finally {
				closeConnection();
			}
		 
		 return mappaLibroByISBN;
	}
}
