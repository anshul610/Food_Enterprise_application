package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Customerdao;

@WebServlet("/SClogin")
public class SClogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email= request.getParameter("email");
		String upwd= request.getParameter("upwd");
		Customerdao cdo= new Customerdao();
		try {
			int x=cdo.Clogincheck(email, upwd);
			if(x!=0) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60000);
				session.setAttribute("userloginbyemail", email);
				response.sendRedirect("Start.jsp");
				response.setHeader("Cache-Control", "no-cache");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Expires", "0");
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("Start.jsp");
				request.setAttribute("msg", "Login Fail Try Again");
				rd.forward(request, response);
			}
		} catch (SQLException e) {e.printStackTrace();}
	}

	
}


