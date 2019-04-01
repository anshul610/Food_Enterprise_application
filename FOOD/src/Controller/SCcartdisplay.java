package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Cartdisplay;
import Beans.Foodbean;
import Dao.Customerdao;

@WebServlet("/SCcartdisplay")
public class SCcartdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("userloginbyemail");
		Customerdao cd=new Customerdao();
		 
		 ArrayList<Cartdisplay> list=cd.viewCartItems(email);
		 RequestDispatcher rd=request.getRequestDispatcher("Displayusercart.jsp");
		  request.setAttribute("LIST",list);	
			  rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}}
