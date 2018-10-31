package it.cb.biblioteca.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.cb.biblioteca.model.BaseMapper;
import it.cb.biblioteca.model.LibroBiblioteca;
import it.cb.biblioteca.model.UtenteVo;

public class Biblio {
	//.fields
	
	private static Map<String,ArrayList<LibroBiblioteca>> libriBiblioteca = new HashMap<String,ArrayList<LibroBiblioteca>>();  	
	//private static List<UtenteVo> utentiCensiti;// pensa a renderlo un SET
	private static UtenteVo currentUser=null;
	

//	static {
//		utentiCensiti = new ArrayList<>();	
//		popolaUtenti();
//	}
	//private int param=0;

	//.methods
	public Map<String, ArrayList<LibroBiblioteca>> getLibri() {
		return libriBiblioteca;
	}
	public void setLibri(Map<String, ArrayList<LibroBiblioteca>> libri) {
		libriBiblioteca = libri;
	}
	
	
	
	public UtenteVo getCurrentUser() {
		return currentUser;
	}
	
	

	
	
//	public static void popolaUtenti() {
//		utentiCensiti.add(new UtenteVo("Primo","Utente1","PRUT0001", "user1", "pwd1"));
//		utentiCensiti.add(new UtenteVo("Secondo","Utente2","PRUT0002","user2", "pwd2"));
//		utentiCensiti.add(new UtenteVo("Terzo","Utente3","PRUT0003","user3", "pwd3"));
//		utentiCensiti.add(new UtenteVo("Quarto","Utente4","PRUT0004","user4", "pwd4"));
//		utentiCensiti.add(new UtenteVo("Quinto","Utente5","PRUT0005","user5", "pwd5"));
//		utentiCensiti.add(new UtenteVo("Sesto","Utente6","PRUT0006","user6", "pwd6"));
//		utentiCensiti.add(new UtenteVo("Settimo","Utente7","PRUT0007","user7", "pwd7"));
//		utentiCensiti.add(new UtenteVo("Ottavo","Utente8","PRUT0008","user8", "pwd8"));
//		utentiCensiti.add(new UtenteVo("Nono","Utente9","PRUT0009","user9", "pwd9"));
//		utentiCensiti.add(new UtenteVo("Decimo","Utente10","PRUT0010","user10", "pwd10"));
//	}
	
	public void popolaBiblio() {
//		this.add(new LibroBiblioteca("nomeLibro1","autore1","anno1"));
//		this.add(new LibroBiblioteca("nomeLibro2","autore2","anno2"));
//		this.add(new LibroBiblioteca("nomeLibro3","autore3","anno3"));
//		this.add(new LibroBiblioteca("nomeLibro3","autore3","anno3"));
//		this.add(new LibroBiblioteca("nomeLibro3","autore3","anno3"));
//		this.add(new LibroBiblioteca("nomeLibro4","autore4","anno4"));
//		this.add(new LibroBiblioteca("nomeLibro1","autore1","anno1"));
	}

	
	
	
	
	
	
	
//	public void add(Object obj) {
//		if(obj instanceof UtenteVo) {	
//		    System.out.println("stai inserendo un nuovo utente");
//			 newUser((UtenteVo)obj);
//		} else if( obj instanceof Libro) {
//		    System.out.println("stai inserendo un nuovo libro");
//		    newBook((Libro)obj);
//		  }
//	}
		
//	private void newUser(UtenteVo user) {
//		int idUtente=0;
//		if (utentiCensiti.isEmpty()) {
//			//int idUtente = user.newIdUserGenerator();
//			utentiCensiti.add(idUtente, user);
////			System.out.println("hai inserito l' utente "+ idUtente);
//		}else {
////		for(Integer key: utenti.keySet()) {
////			if(utenti.get(key).getNome() == user.getNome() 
////					&& utenti.get(key).getCognome() == user.getCognome() && 
////					utenti.get(key).getCf()==user.getCf()
////					) 
////			{
////				System.out.println("UtenteVo gi� censito");
////			}else {
////				idUtente = user.newIdUserGenerator();
////				utentiCensiti.add(idUtente, user);
////				System.out.println("stai inserendo l' utente "+ idUtente);
//		}
//		System.out.println("hai inserito l' utente "+ idUtente);
////			}
////		}
//	}
		
//	private void newBook(Libro book) {
//		
//		
//
//		if (libriBiblioteca.isEmpty()) {
//			libriBiblioteca.put(isbn.toString(), book);
//			//numeroCopieDisponibiliUpdate(book, param);
//			System.out.println("hai inserito il libro "+ isbn);
//		}else {
//			
////		for(Integer key: utenti.keySet()) {
////			if(utenti.get(key).getNome() == user.getNome() 
////					&& utenti.get(key).getCognome() == user.getCognome() && 
////					utenti.get(key).getCf()==user.getCf()
////					) 
////			{
////				System.out.println("UtenteVo gi� censito");
////			}else {
//			
//			libriBiblioteca.put(isbn.toString(), book);
//				//numeroCopieDisponibiliUpdate(book,param);
//				System.out.println("stai inserendo il libro "+ isbn);
//		
//		}
////			}
////		}
//	}

//	private void numeroCopieDisponibiliUpdate(Libro book,int param) {
//		int counter=0;
//		
////		for(String key: libri.keySet()) {
////			if(libri.get(key).equals(book)){
////				counter++;
////				libri.get(key).setNumeroCopieDisponibili(counter);
////			}		
////		}
//		switch(param) {
//		case 0: //nuovo acquisto +1
//		//	libri.get(key).setNumeroCopieDisponibili(counter);
//			for(String key: libriBiblioteca.keySet()) {
//				if(libriBiblioteca.get(key).equals(book)){
//					counter++;
//					libriBiblioteca.get(key).setNumeroCopieDisponibili(counter);
//				}		
//			}
//			break;
//		case 1: //prestito -1
//			for(String key: libriBiblioteca.keySet()) {
//				if(libriBiblioteca.get(key).equals(book)){
//					counter=libriBiblioteca.get(key).getNumeroCopieDisponibili()-1;
//					libriBiblioteca.get(key).setNumeroCopieDisponibili(counter);
//				}				
//			}
//			break;
//		case 2: //reso +1
//			for(String key: libriBiblioteca.keySet()) {
//				if(libriBiblioteca.get(key).equals(book)){
//					counter=libriBiblioteca.get(key).getNumeroCopieDisponibili()+1;
//					libriBiblioteca.get(key).setNumeroCopieDisponibili(counter);
//				}				
//			}
//			break;
//			default:
//		}
//		
//		
//	
//		
//	}
		
	public void noleggiaLibro(LibroBiblioteca libro) {
		//numeroCopieDisponibiliUpdate(book,1);
		if(libro.isPrestito()) {
			System.out.println("Il libro � gi� in prestito");
			
			//numeroCopieDisponibiliUpdate(book,1);
		}else {
			libro.setPrestito(true);
			System.out.println("Il prestito � concesso");
		}
	}
	public void restituisciLibro(LibroBiblioteca libro) {
		
			libro.setPrestito(false);
			System.out.println("Hai restituito il libro, grazie");	
	}
	public void elencoPrestiti(UtenteVo user) {
		// TODO Auto-generated method stub
		
	}
	public void acquistaLibro(BaseMapper libro) {
		// TODO Auto-generated method stub
		
	}
	//.ctors
	public Biblio() {
	}
	
	
	
	
	
}
