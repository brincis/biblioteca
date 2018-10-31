package it.cb.biblioteca.utils;
public interface QueryStm {

	
	public final String QUERY_UPDATE_FINE_NOLEGGIO_DATE= "UPDATE umana_biblio.noleggio SET data_fine = ? WHERE noleggio.idnoleggio=?";

	public final String QUERY_MAP_LIBRI_DISPONIBILI_BY_ISBN = "SELECT libro.* FROM umana_biblio.libro, umana_biblio.noleggio\r\n" + 
			"		 		WHERE libro.isbn='isbnebano' AND libro.idlibro=noleggio.idlibro AND noleggio.data_fine!=null";


	public final String QUERY_LISTA_LIBRI_NOLEGGIATI_BY_USER = "SELECT titolo,isbn,data_inizio,data_fine,idnoleggio,noleggio.idlibro "+
			"FROM umana_biblio.libro,umana_biblio.noleggio " + 
			"WHERE noleggio.idutente=? AND noleggio.idlibro=libro.idlibro";
	public final String QUERY_SET_NEW_NOLEGGIO_BY_IDUSER_IDLIBRO = "INSERT into umana_biblio.noleggio (data_inizio,idutente,idlibro) "+
			"values (?,?,?)";
	public final String QUERY_SET_NEW_USER_BY_REG="INSERT into umana_biblio.utente (username,password,nome,cognome,cf)"+ 
														"values (?,?,?,?,?)";

	public final String QUERY_LISTA_NOLEGGI_TERMINATI = "SELECT idnoleggio FROM umana_biblio.noleggio WHERE statonoleggio=1";

	public final String QUERY_LISTA_UTENTI = "select utente.idutente, utente.username, utente.password,"+
			"utente.nome, utente.cognome, utente.cf ,ruolo.descrizione_ruolo "+
			"from umana_biblio.ruolo, umana_biblio.utente, umana_biblio.utente_ruolo "+ 
			"WHERE ruolo.idruolo = utente_ruolo.idruolo AND "+  
			"utente_ruolo.idutente = utente.idutente";
}
