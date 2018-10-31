package it.cb.biblioteca.model;

public class Studente extends UtenteVo {

	@Override
	public String toString() {
		return "[" + super.toString() + "]";
	}


	private static final String USER_ROLE = "studente";
	
	public String getUserRole() {
		return USER_ROLE;
	}


	public Studente(String nome, String cognome, String cf, String username, String password) {
		super(nome, cognome, cf, username, password);	
		// TODO Auto-generated constructor stub
	}


	public Studente() {
		// TODO Auto-generated constructor stub
	}

}
