package it.cb.biblioteca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Noleggio extends BaseMapper{

	
	private int idnoleggio;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private int userId;
	private String isbn;
	private int libroId;
	private boolean noleggiato;
	
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public long getLibroId() {
		return libroId;
	}
	public void setLibroId(int libroId) {
		this.libroId=libroId;
	}
	public boolean isNoleggiato() {
		return noleggiato;
	}
	public void setNoleggiato(boolean noleggiato) {
		this.noleggiato = noleggiato;
	}
	
	public Noleggio() {
	}
	
	public Noleggio(int id, LocalDate dataInizio, LocalDate dataFine, int userId, String isbn, int libroId) {
		super();
		this.idnoleggio = id;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.userId = userId;
		this.isbn = isbn;
		this.libroId = libroId;
	}
	public Noleggio(int userId,String isbn, LocalDate dataQuery ) {
		this();
		this.userId=userId;
		this.isbn= isbn;
		this.dataInizio = dataQuery;
		this.dataFine = dataQuery.plusDays(26);
	}
	@Override
	public String toString() {
		return "Noleggio [dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", isbn=" + isbn + "]";
	}
	@Override
	public String getTableName() {
		return "noleggio";
	}
	@Override
	public String getTablePKName() {
		return "idnoleggio";
	}
	@Override
	public int getTablePKValue() {
		return this.idnoleggio;
	}
	
	
	
}
