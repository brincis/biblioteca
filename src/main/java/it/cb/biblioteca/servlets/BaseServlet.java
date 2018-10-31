package it.cb.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String destPath=null;
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("userInSession")==null) {
			destPath = "/WEB-INF/pages/login.jsp";
			}else {
				destPath=execute(req,resp);
		}
		getServletContext().getRequestDispatcher(destPath).forward(req, resp);	
	}
	
	
	/**
	 * deve sempre restituire il path di arrivo della servlet
	 **/
	
	protected abstract String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected HttpSession getCurrentSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session == null ) {
			return session;
		}
		getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
		return null;
	}


}
