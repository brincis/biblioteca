package it.cb.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.cb.biblioteca.exceptions.ConcurrentModificationException;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.model.BaseMapper;

public abstract class GenericDao {

	//.fields
	protected Connection connection;

	//.methods
	public Connection getConnection() {
		if(connection==null) {
			
			try {
				this.connection=ServiceManager.getIstance().openConnection();
			} catch (SQLException sqle) {
				// TODO Auto-generated catch block
				sqle.printStackTrace();
			}
		}
		return this.connection;
	}
	public void openTransaction() throws SQLException {
		if(this.connection!=null) {
			this.connection.setAutoCommit(false);
	}
	}
	
	public void commitTransaction() throws SQLException {
		if(this.connection!=null) {
		this.connection.commit();
		}
	}
	
	public void rollbackTransaction() throws SQLException {
		if(this.connection!=null) {
		this.connection.rollback();
	}
		}
		
	public void closeConnection() throws DataException  {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				throw new DataException(sqle, ErrorCodes.ERROR_CODE_DATABASE_CONNECTION_LOST);
			}
		}
		}
		
	//.ctors
	public GenericDao() {		
		}
	
	public GenericDao(Connection connection) {
			super();
			this.connection = connection;
		}

	public void selectForUpdate(BaseMapper mapper) throws ConcurrentModificationException {
		Connection conn=null;
		
		try {
			conn = getConnection();
		
		int version = 0;
		String queryGetVersion ="SELECT version FROM "+ mapper.getTableName()+" WHERE "+mapper.getTablePKName()+" =?"; 
		PreparedStatement pStm = conn.prepareStatement(queryGetVersion);		
		pStm.setObject(1, mapper.getTablePKValue());
		ResultSet rs = pStm.executeQuery();
		if(rs.next()) {
			version = rs.getInt("version");
		}
		if(mapper.getVersion() != version) {
			conn.rollback(); //throw di una nuova eccezione che prevede la rollback
			throw new ConcurrentModificationException("",ErrorCodes.ERROR_CODE_CUNCURRENT_USER_UPDATE);
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
