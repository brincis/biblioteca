package it.cb.biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.utils.ConnectionUtils;


/*
 * Classe aderente al pattern Singleton che rappresenta il comportameto cenralizzato di tutte  
 * Rispetto al progetto biblioteca (in cui avevo DababaseUtils) lo converto in pattern SingleTon 
 * per averlo sempre in pancia all'applixazione, instanziarlo solo una volta via costruttore
 */
public class ServiceManager { 
	
	private static ServiceManager _istance;
	private ConnectionUtils cu;
	private DataSource ds;

	private ServiceManager() {
	//	initRemoteService();
	}	
	
	public synchronized static ServiceManager getIstance() {	
		if(_istance==null) {
			_istance = new ServiceManager();
		}
		return _istance;
	}
	
	public void initDatabase(ConnectionUtils cu) {
		
		this.cu = cu;
		if("0".equals(cu.getDatabasePropertiesConnectionType())) {
		try{
			Class.forName(cu.getDatabasePropertiesDriver());
			
		}catch (ClassNotFoundException cnfe) {
			System.err.println("Errore nel caricamento del driver");
			cnfe.printStackTrace();
			System.exit(0);// Se un programma termina senza aver incontrato problemi, il codice di errore
							// deve essere zero (0).
		} 
		}
	}
		

	

	Connection openConnection() throws SQLException, SQLException {
	Connection openConn=null;
	if("0".equals(cu.getDatabasePropertiesConnectionType())){
			openConn= DriverManager.getConnection(cu.getDatabasePropertiesUrl(), // "jdbc:mysql://192.90.90.1:3306//nomedB",
					cu.getDatabasePropertiesUsername(),
					cu.getDatabasePropertiesPassword());
	}else if("1".equals(cu.getDatabasePropertiesConnectionType())) {
				openConn = getDataSource().getConnection();
				// TODO Auto-generated catch block
	}		
	return openConn;
	}

private DataSource getDataSource() throws SQLException  {
	if (ds == null) {
		Context context;
		try {
			context = new InitialContext();

		Context envContext  = (Context)context.lookup(cu.getDatabasePropertiesJavaEnv());
		this.ds =(javax.sql.DataSource)envContext.lookup(cu.getDatabasePropertiesJndiName());
		} catch (NamingException ne) {
			// TODO Auto-generated catch block
			throw new SQLException(ne);
		}
	}
	return ds;
}
}


	

