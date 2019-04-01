package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Foodbean;
import Dao.DbDao;
@WebServlet("/Sdisplay")
public class Sdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbDao d=new DbDao();
		 ArrayList<Foodbean> list = d.viewAllProduct();
		 RequestDispatcher rd=request.getRequestDispatcher("Displayproduct.jsp");
		  request.setAttribute("LIST",list);
		rd.forward(request, response);		  
	}
	}


