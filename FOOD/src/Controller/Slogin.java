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

import Dao.DbDao;

@WebServlet("/Slogin")
public class Slogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String uid= request.getParameter("uid");
		String pwd= request.getParameter("pwd");
		DbDao d= new DbDao();
		try {
			int x=d.logincheck(uid, pwd);
			if(x==1) {
			  HttpSession session=request.getSession();
			     session.setMaxInactiveInterval(30000);
			     session.setAttribute("loginadmin", uid);	
				 response.sendRedirect("adminhome.jsp");
			   	response.setHeader("Cache-Control", "no-cache");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Expires", "0");
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("adminhome.jsp");
				request.setAttribute("msg", "Login Fail Try Again");
				rd.forward(request, response);
			}	
		} catch (SQLException e) {e.printStackTrace();}
	}
}
