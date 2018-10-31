package it.cb.biblioteca.dto;

public class UtenteDto {

	
	private String nome;
	private String cognome;
	private String cf;
	
	private String username;
	private String password;
	private String email;
	
	private String fraseDiRecupero;
	private String rispostaFraseDiRecupero;

	private String enabled;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFraseDiRecupero() {
		return fraseDiRecupero;
	}
	public void setFraseDiRecupero(String fraseDiRecupero) {
		this.fraseDiRecupero = fraseDiRecupero;
	}
	public String getRispostaFraseDiRecupero() {
		return rispostaFraseDiRecupero;
	}
	public void setRispostaFraseDiRecupero(String rispostaFraseDiRecupero) {
		this.rispostaFraseDiRecupero = rispostaFraseDiRecupero;
	}
	
}
