package it.cb.biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.cb.biblioteca.dto.UtenteDto;

@WebServlet(value = {"/registrationStep1","/registrationStep2","/registrationSummary"})
public class NewUserServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		String path = req.getServletPath();
		String destPath=null;

		if("/registrationStep1".equals(path)) {
			UtenteDto newUserInSession = new UtenteDto();
			
			String nome = req.getParameter("variabileNome");
			String cognome = req.getParameter("variabileCognome");
			String cf = req.getParameter("variabileCf");		
			if(nome !=null && cognome !=null && cf!=null) {
			newUserInSession.setNome(nome);
			newUserInSession.setCognome(cognome);
			newUserInSession.setCf(cf);
			session.setAttribute("userInSessionToRegister",newUserInSession);				
			destPath = "/WEB-INF/pages/registrationStep2.jsp";
			}else {
				destPath = "/WEB-INF/pages/registrationStep1.jsp";
			}
			}else if("/registrationStep2".equals(path)) {
				String username = req.getParameter("variabileUsername");
				String password = req.getParameter("variabilePassword");
				if(username !=null && password !=null) {
				UtenteDto newUserInSession = (UtenteDto) session.getAttribute("userInSessionToRegister");
				newUserInSession.setUsername(username);
				newUserInSession.setPassword(password);
				session.setAttribute("userInSessionToRegister",newUserInSession);				
				destPath = "/WEB-INF/pages/registrationSummary.jsp";

				}else {
					destPath = "/WEB-INF/pages/registrationStep2.jsp";

				}

		}else if("/registrationSummary".equals(path)) {
			// TO DO: insert into DB the new user
		}
		getServletContext().getRequestDispatcher(destPath).forward(req,resp);
		return destPath;
	}
}
