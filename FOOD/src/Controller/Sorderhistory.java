package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Orderbean;
import Dao.DbDao;

@WebServlet("/Sorderhistory")
public class Sorderhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbDao cd=new DbDao();
		 ArrayList<Orderbean> list=cd.viewOrderHistroy();
		 RequestDispatcher rd=request.getRequestDispatcher("Orderhistroy.jsp");
		  request.setAttribute("LIST",list);	
			  rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
