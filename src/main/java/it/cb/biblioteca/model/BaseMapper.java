package it.cb.biblioteca.model;

public abstract class BaseMapper {

	private int version;
	

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public abstract String getTableName();
	public abstract String getTablePKName();
	public abstract int getTablePKValue();

}
