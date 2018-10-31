package it.cb.biblioteca.model;

public class Bibliotecario extends UtenteVo {
	
	private static final String USER_ROLE = "bibliotecario";
	public String getUserRole() {
		return USER_ROLE;
	}
	public Bibliotecario(String nome, String cognome, String cf, String username, String password) {
		super(nome, cognome, cf, username, password);
		// TODO Auto-generated constructor stub
	}
	public Bibliotecario() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "[" + super.toString() + "]";
	}
	

}
