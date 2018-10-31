package it.cb.biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.cb.biblioteca.dao.UtenteDao;
import it.cb.biblioteca.dto.UtenteDto;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.model.UtenteVo;
import it.cb.biblioteca.utils.UtenteUtils;

@WebServlet(urlPatterns= {"/usersList"})
public class ListUtentiServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String outPath = "/WEB-INF/pages/usersList.jsp";
		UtenteDao uDao = new UtenteDao();
		List<UtenteDto> listUdto=null;
		HttpSession session = req.getSession(false);
			try {
				List<UtenteVo> listUdao = uDao.getUtentiCensiti();
				for(UtenteVo ud : listUdao) {
					listUdto.add(UtenteUtils.fromVoToDto(ud));
					}
				req.setAttribute("usersList",listUdto);	
			} catch (DataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher(outPath).forward(req,resp);
		return outPath;
	}

	  
}
