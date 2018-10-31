package it.cb.biblioteca.model;

public class UtenteVo extends BaseMapper{
	

	private static final String USER_ROLE = null;
	//fields
	//private static int idx = 0;
	public String getUserRole() {
		return USER_ROLE;
	}
	
	
	private int id;
	private String nome;
	private String cognome;
	private String cf;
	private String username;
	private String password;
	
	//methods

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//	public long getId() {
//		return id;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UtenteVo other = (UtenteVo) obj;
//		if (cf == null) {
//			if (other.cf != null)
//				return false;
//		} else if (!cf.equals(other.cf))
//			return false;
//		if (cognome == null) {
//			if (other.cognome != null)
//				return false;
//		} else if (!cognome.equals(other.cognome))
//			return false;
//		if (id != other.id)
//			return false;
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		return true;
//	}
//	//metodo creatore nuovo utente che mi restituisca il suo id
	
//	public static int newIdUserGenerator() {
//		//incrementUser();
//		idx++;		
//
//		return idx;
//	}
//	private void incrementUser(){
//		idx++;		
//	}

	
	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", username=" + username
				+ ", password=" + password + "]";
	}
	//.ctors
	public UtenteVo(String nome, String cognome, String cf, String username, String password){
		this.nome = nome;
		this.cognome=cognome;
		this.cf=cf;
		this.username=username;	
		this.password=password;
	}

	public UtenteVo() {
	}
	@Override
	public String getTableName() {
		return "utente";
	}
	@Override
	public String getTablePKName() {
		return "idutente";
	}
	@Override
	public int getTablePKValue() {
		// TODO Auto-generated method stub
		return this.getId();
	}
	
}
