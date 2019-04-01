package Controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Foodbean;
import Dao.DbDao;
@WebServlet("/Sdelete")
public class Sdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pname=request.getParameter("pname");
		DbDao d=new DbDao();
		int y=d.deleteproduct(pname);
		 ArrayList<Foodbean> list = d.viewAllProduct();
		 request.setAttribute("LIST",list);
		 RequestDispatcher rd=request.getRequestDispatcher("Displayproduct.jsp");
		  if(y!=0) 	  
		  request.setAttribute("deletemsg","product name:"+ pname +" Deleted Successfully..");
		  else
		  request.setAttribute("deletemsg","Data Not Deleted ");
		  rd.forward(request, response);
	
	}
	}


