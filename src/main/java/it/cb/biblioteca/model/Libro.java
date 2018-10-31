package it.cb.biblioteca.model;


public class Libro extends BaseMapper{

	//.fields
	//private static int idx = 0;
	
	private int idlibro;
	private String isbn;
	private String titolo;
	private String autore;
	private String annoPub;
	//.methods	
	public int getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(int id) {
		this.idlibro=id;
	}
	public String getIsbn() {
		return isbn;
	}	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getAnnoPub() {
		return annoPub;
	}
	public void setAnnoPub(String annoPub) {
		this.annoPub = annoPub;
	}	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (annoPub == null) {
			if (other.annoPub != null)
				return false;
		} else if (!annoPub.equals(other.annoPub))
			return false;
		if (autore == null) {
			if (other.autore != null)
				return false;
		} else if (!autore.equals(other.autore))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	
	//.ctors
	public Libro(){
		
	}
	public Libro(String titolo, String autore, String annoPub){
		this();
		this.titolo = titolo;
		this.annoPub=annoPub;
		this.autore=autore;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + idlibro + ", isbn=" + isbn + ", titolo=" + titolo + ", autore=" + autore + ", annoPub="
				+ annoPub + "]";
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "libro";
	}
	@Override
	public String getTablePKName() {
		// TODO Auto-generated method stub
		return "idlibro";
	}
	@Override
	public int getTablePKValue() {
		// TODO Auto-generated method stub
		return this.getIdlibro();
	}

	
	
}
