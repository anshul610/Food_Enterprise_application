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

import Dao.Customerdao;

@WebServlet("/SCdelete")
public class SCdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
		String email= request.getParameter("email");
		String upwd= request.getParameter("upwd");
		Customerdao cdo= new Customerdao();
		int x=cdo.deletecustomer(email, upwd);
		if(x!=0) 
			response.sendRedirect("Start.jsp");
		 
		//	RequestDispatcher rd= request.getRequestDispatcher("Duallogin.jsp");
		//	request.setAttribute("msg", "Login Fail Try Again");
		//	rd.forward(request, response);
		
	}
}
