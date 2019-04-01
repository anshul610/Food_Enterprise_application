package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import Dao.DbDao;

@WebServlet("/SCproductremove")
public class SCproductremove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("userloginbyemail");
		
		int  pid=Integer.parseInt(request.getParameter("pid"));
		Customerdao d=new Customerdao();
		int y=d.productremovecart(pid);
		 ArrayList<Cartdisplay> list = d.viewCartItems(email);
		 request.setAttribute("LIST",list);
		 RequestDispatcher rd=request.getRequestDispatcher("Displayusercart.jsp");
		 rd.forward(request, response);
	}}