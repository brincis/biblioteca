package it.cb.biblioteca.handlers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.cb.biblioteca.dao.LibroDao;
import it.cb.biblioteca.dao.NoleggioDao;
import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.model.BaseMapper;
import it.cb.biblioteca.model.LibroBiblioteca;
import it.cb.biblioteca.model.Negozio;
import it.cb.biblioteca.model.Noleggio;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.services.NoleggioService;
import it.cb.biblioteca.utils.OrariBiblioteca;

public class MenuHandler {
	private Biblio biblioteca;	
	private static UtenteVo currentUser;


	private static Scanner scanner = new Scanner(System.in);
	public void displayMenu(UtenteVo us) throws NumberFormatException {
		currentUser = us;
		StringBuilder sb = new StringBuilder();		
		if(us.getUserRole().equals("studente")) {
		sb.append("Digita uno tra i menu disponibili:\n");
		sb.append("\t1. Noleggia libro\n");
		sb.append("\t2. Restituisci libro\n");
		sb.append("\t3. Elenco prestiti\n");
		sb.append("\t0. Per uscire\n");
		
		System.out.println("Benvenuto "+us.getUserRole().toString()+" "+us.getNome().toString());
		System.out.println(sb);

		
	}else if (us.getUserRole().equals("bibliotecario")){
		

		sb.append("Digita uno tra i menu disponibili:\n");
		sb.append("\t1. Noleggia libro\n");
		sb.append("\t2. Restituisci libro\n");
		sb.append("\t3. Elenco prestiti\n");
		sb.append("\t4. Acquista libro\n");
		sb.append("\t5. Lista Utenti\n");
		sb.append("\t6. Registra UtenteVo\n");
		sb.append("\t7. Cancella noleggi restituiti\n");
		sb.append("\t0. Per uscire\n");
		System.out.println("Benvenuto "+us.getUserRole().toString()+" "+us.getNome().toString());
		System.out.println(sb);		
	}
		String menuChoice = scanner.nextLine();
		try {
			manageMenu(Integer.parseInt(menuChoice), us);
		} catch (DataException e) {
			// TODO Auto-generated catch block
			System.out.println("errore di digitazione");
			e.printStackTrace();
		}	

	}
	public void manageMenu(int menu, UtenteVo currentUser) throws DataException {
		//LibroBiblioteca libro=null;
		switch(menu) {
		case 0:{
			System.out.println("Arrivederci e grazie");
			System.exit(0);
		}
		case 1:{
			System.out.println("Hai selezionato Noleggia Libro");
			System.out.println("Inserisci titolo: ");
			String titolo = scanner.nextLine();
			System.out.println("Inserisci autore: ");
			String autore = scanner.nextLine();
			System.out.println("Inserisci isbn: ");
			String isbn=scanner.nextLine();;//cal db		
			HashMap<String,ArrayList<Integer>> avaiabilityLibroBibliotecaByISBN=avaiabilityLibroBibliotecaByISBN(isbn);
			if(isbn!=null) {
				if(avaiabilityLibroBibliotecaByISBN.isEmpty()) {//dimmi se ho copie  a disposione
				System.out.println("Libro non presente in biblioteca");
				System.exit(0);				
			}	
				System.out.println("Il Libro è presente in biblioteca, "+"vuoi noleggiarlo?(digita si/no)");
				String noleggiaConfirmation = scanner.nextLine();				
				if(noleggiaConfirmation=="si") {
					
					if (OrariBiblioteca.isOpen(LocalDateTime.now())) {//check orari if ok 
					//check result 1/0  try catch
					NoleggioService nolServ = new NoleggioService();
					nolServ.noleggiaLibroById(avaiabilityLibroBibliotecaByISBN.get(isbn).get(0), currentUser);
					
					System.exit(0);
					break;
					}else {
						System.out.println("La biblioteca ora è chiusa!");

					}
				}
		}
		}
		case 2:{
			System.out.println("Hai selezionato Restituisci libro");
			break;
		}
		case 3:{
			System.out.println("Hai selezionato Elenco prestiti");
			try {
				List<Noleggio> listaLibriNoleggiati= elencoPrestiti(currentUser);
				listaLibriNoleggiati.forEach(
					x->{ System.out.println(x.toString());
				});// metodo pi� contratto 
			}catch(DataException dt) {
				System.out.println("Elenco non trasmettibile");
			}
			break;
		}
		case 4:{
			System.out.println("Hai selezionato Acquista libro");
			break;
		}
		case 5:{
			System.out.println("Hai selezionato Lista Utenti");
			List<UtenteVo> listaUtentiBiblioteca = getListaUtentiCensiti();
			listaUtentiBiblioteca.forEach(x->{
				System.out.println(x.toString()+" "+ x.getUserRole());
				});// metodo pi� contratto 
			break;
		}
		case 6:{
			System.out.println("Hai selezionato Registra nuovo utente");
			break;
		}
		case 7:{
			System.out.println("Hai selezionato cancella libri restituiti");
			NoleggioService nolServ = new NoleggioService();
			nolServ.numeroNoleggiTerminati();
			break;
		}
		}
	}
	
	private HashMap<String,ArrayList<Integer>> avaiabilityLibroBibliotecaByISBN(String isbn) throws DataException {
		
		LibroDao ld = new LibroDao();
		HashMap<String,ArrayList<Integer>> numeroLibriDisponibiliPerISBN = ld.avaiabilityLibroBibliotecaByISBN(isbn);
		if(numeroLibriDisponibiliPerISBN.isEmpty()) {
			System.out.println("Non Ci sono  copie disponibili");
		}else{
			System.out.println("Ci sono "+numeroLibriDisponibiliPerISBN+" copie disponibili");
		}
		return numeroLibriDisponibiliPerISBN;
		//biblioteca.noleggiaLibro(libro);

	}
//	private int noleggiaLibroById(int idlibro) throws DataException {
//		LocalDate datainizio = LocalDate.now();
//		return NoleggioDao.noleggiaLibroById(idlibro,datainizio,currentUser.getId());
//		 
//	}
//	private void restituisciLibro(LibroBiblioteca libro) {
//		biblioteca.restituisciLibro(libro);
//	}
	private List<Noleggio> elencoPrestiti(UtenteVo user) throws DataException {
		NoleggioDao nl=new NoleggioDao();
		return nl.getLibriNoleggiati(user);
	}
	private void acquistaLibro(BaseMapper libro, Negozio negozio) {
		biblioteca.acquistaLibro(libro);
	}
	private List<UtenteVo> getListaUtentiCensiti() throws DataException{
	UtenteDao ud=new UtenteDao();
	return ud.getUtentiCensiti();
	}
	

}
