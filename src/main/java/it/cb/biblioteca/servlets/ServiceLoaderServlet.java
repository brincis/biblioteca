package it.cb.biblioteca.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import it.cb.biblioteca.dao.ServiceManager;
import it.cb.biblioteca.utils.ConnectionUtils;

public class ServiceLoaderServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);	
		
		ConnectionUtils cu = new ConnectionUtils();
		cu.setDatabasePropertiesConnectionType(getInitParameter("DATABASE_CONNECTION_TYPE"));
		cu.setDatabasePropertiesDriver(getInitParameter("DATABASE_DRIVER"));
		cu.setDatabasePropertiesUrl(getInitParameter("DATABASE_URL"));
		cu.setDatabasePropertiesUsername(getInitParameter("DATABASE_USERNAME"));
		cu.setDatabasePropertiesPassword(getInitParameter("DATABASE_PASSWORD"));
		cu.setDatabasePropertiesJndiName(getInitParameter("JNDI_NAME"));
		cu.setDatabasePropertiesJavaEnv(getInitParameter("JAVA_ENV"));

		try{
			ServiceManager.getIstance().initDatabase(cu);
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
