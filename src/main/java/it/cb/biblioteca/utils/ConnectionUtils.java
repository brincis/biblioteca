package it.cb.biblioteca.utils;

public class ConnectionUtils {
	
	
	private String databasePropertiesConnectionType;
	private String databasePropertiesDriver;
	private String databasePropertiesUrl;
	private String databasePropertiesUsername;
	private String databasePropertiesPassword;
	private String databasePropertiesJavaEnv;
	private String databasePropertiesJndiName;
	
	
	public String getDatabasePropertiesConnectionType() {
		return databasePropertiesConnectionType;
	}
	public void setDatabasePropertiesConnectionType(String databaseProperties_connectionType) {
		this.databasePropertiesConnectionType = databaseProperties_connectionType;
	}
	public String getDatabasePropertiesDriver() {
		return databasePropertiesDriver;
	}
	public void setDatabasePropertiesDriver(String databaseProperties_driver) {
		this.databasePropertiesDriver = databaseProperties_driver;
	}
	public String getDatabasePropertiesUrl() {
		return databasePropertiesUrl;
	}
	public void setDatabasePropertiesUrl(String databaseProperties_url) {
		this.databasePropertiesUrl = databaseProperties_url;
	}
	public String getDatabasePropertiesUsername() {
		return databasePropertiesUsername;
	}
	public void setDatabasePropertiesUsername(String databaseProperties_username) {
		this.databasePropertiesUsername = databaseProperties_username;
	}
	public String getDatabasePropertiesPassword() {
		return databasePropertiesPassword;
	}
	public void setDatabasePropertiesPassword(String databaseProperties_password) {
		this.databasePropertiesPassword = databaseProperties_password;
	}
	public String getDatabasePropertiesJavaEnv() {
		return databasePropertiesJavaEnv;
	}
	public void setDatabasePropertiesJavaEnv(String databaseProperties_javaEnv) {
		this.databasePropertiesJavaEnv = databaseProperties_javaEnv;
	}
	public String getDatabasePropertiesJndiName() {
		return databasePropertiesJndiName;
	}
	public void setDatabasePropertiesJndiName(String databaseProperties_jdiName) {
		this.databasePropertiesJndiName = databaseProperties_jdiName;
	}
	

}
