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

@WebServlet("/Sproductviewonindex")
public class Sproductviewonindex extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbDao cd=new DbDao();
		 ArrayList<Foodbean> list = cd.viewProductonindex();
		 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		  request.setAttribute("LIST",list);
		rd.forward(request, response);		  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
