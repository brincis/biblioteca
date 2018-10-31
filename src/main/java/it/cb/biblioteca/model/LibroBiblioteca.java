package it.cb.biblioteca.model;

public class LibroBiblioteca extends Libro{

	boolean prestito = false;
	
	public boolean isPrestito() {
		return prestito;
	}
	public void setPrestito(boolean prestito) {
		this.prestito = prestito;
	}
	
	//.ctors
	public LibroBiblioteca() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LibroBiblioteca(String titolo, String autore, String annoPub) {
		super(titolo, autore, annoPub);
		// TODO Auto-generated constructor stub
	}
	
	@Override	
	public String toString() {
		return "LibroBiblioteca [prestito=" + prestito + "]";
	}
	
}
