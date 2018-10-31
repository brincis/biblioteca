package it.cb.biblioteca.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayHello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String username=req.getAttribute("username").toString();
		String password=req.getAttribute("password").toString();

		PrintWriter out = resp.getWriter();
		String output = "<html><body>Hallo "+ username +" </body></html>";
		out.write(output);
	}

}
