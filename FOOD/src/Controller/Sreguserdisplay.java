package Controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Signupbean;
import Dao.DbDao;

@WebServlet("/Sreguserdisplay")
public class Sreguserdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbDao cd=new DbDao();
		 ArrayList<Signupbean> list = cd.viewAllUsers();
		 RequestDispatcher rd=request.getRequestDispatcher("Displayuser.jsp");
		  request.setAttribute("LIST",list);
		rd.forward(request, response);		  
	}
	}