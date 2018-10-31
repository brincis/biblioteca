package it.cb.biblioteca.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;

import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.dto.UtenteDto;
import it.cb.biblioteca.exceptions.AuthenticationException;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.exceptions.ErrorCodes;
import it.cb.biblioteca.handlers.LoginHandler;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.UtenteUtils;

@WebServlet(value= {"/login","/logout"})
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if (session !=null) {
			session.removeAttribute("userInSession");
			session.invalidate();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("variabileUsrname");
		String password = req.getParameter("variabilePassword");
		String outPath = "";
		HttpSession session = req.getSession();
		UtenteDto loggedUser=null;
		try{
		if(checkLoginFields(username,password)) {
			req.setAttribute("username",username);
			req.setAttribute("password",password);
			
			LoginHandler lh= new LoginHandler();
			
				loggedUser = lh.autentica(username, password);
				outPath = "/WEB-INF/pages/welcomePage.jsp";

//			req.setAttribute("messageErr","utente trovato");
			session.setAttribute("userInSession",loggedUser);	
		}		
		}catch(AuthenticationException ae) {
			ae.printStackTrace();
			req.setAttribute("messageErr","utente non trovato");
			outPath = "/WEB-INF/pages/login.jsp";
		}	
		catch(DataException de) {
			de.printStackTrace();
			req.setAttribute("messageErr","utente non trovato");
			outPath = "/WEB-INF/pages/login.jsp";			
		}catch(ValidationException ve){
			ve.printStackTrace();
			outPath = "/WEB-INF/pages/login.jsp";
			req.setAttribute("messageErr","campi vuoti");			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("messageErr", e.getMessage());
			outPath = "/WEB-INF/pages/login.jsp";
		}
		
		
		getServletContext().getRequestDispatcher(outPath).forward(req,resp);

		}
	
	
	protected boolean checkLoginFields(String us, String pp) throws ValidationException {
		if(us.equals("") || pp.equals("")) {
			throw new ValidationException(LoginHandler.class.getName(),
					ErrorCodes.ERROR_CODE_VALIDATION_NULL_FIELD);
		}
		return true;		
	}
	

}
