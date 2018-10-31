package it.cb.biblioteca.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.dto.UtenteDto;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.UtenteUtils;

@WebServlet(value = {"/gotoLogin","/gotouserList","/gotoRegistrationStep1"})
public class NavigatorServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		String outPath = "";
		
		if(path.equals("/gotoLogin")) {
			outPath= "/WEB-INF/pages/login.jsp";
		}else if(path.equals("/gotouserList")) {
		
			outPath = "/WEB-INF/pages/usersList.jsp";
			UtenteDao uDao = new UtenteDao();
			ArrayList<UtenteDto> listUtentiDto=new ArrayList<UtenteDto>();
			HttpSession session = req.getSession(false);
				try {
					List<UtenteVo> listUtentiVo = uDao.getUtentiCensiti();
					for(UtenteVo ud : listUtentiVo) {
						UtenteDto uDto= UtenteUtils.fromVoToDto(ud);
						listUtentiDto.add(uDto);
						}
					req.setAttribute("usersList",listUtentiDto);	
				} catch (DataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(path.equals("/gotoRegistrationStep1")) {
			outPath= "/WEB-INF/pages/registrationStep1.jsp";
		}
		getServletContext().getRequestDispatcher(outPath).forward(req,resp);

	}

	
}
