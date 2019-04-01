package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Foodbean;
import Dao.DbDao;

@WebServlet("/Supdate")
public class Supdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int y=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid= Integer.parseInt(request.getParameter("pid"));
		DbDao d= new DbDao();
		Foodbean fbe= new DbDao().viewProductbyId(pid);
		  RequestDispatcher rd=request.getRequestDispatcher("Updateproduct.jsp");
		  request.setAttribute("PRO",fbe);
		  rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid= request.getParameter("pid");
		String pname=request.getParameter("pname");
		String category=request.getParameter("category");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		Foodbean fb= new Foodbean();
		fb.setPid(Integer.parseInt(pid));
		fb.setPname(pname);
		fb.setCategory(category);
		fb.setPrice(price);
		fb.setDescription(description);
   
		DbDao d2=new DbDao();
		y=d2.updateproduct(fb);
		 RequestDispatcher rd=request.getRequestDispatcher("Updateproduct.jsp");
		 Foodbean fb2=d2.viewProductbyId(Integer.parseInt(pid));
		  request.setAttribute("PRO",fb2);
		  rd.forward(request, response);
	
		if(y!=0) 
			  request.setAttribute("updatemsg","Data Updated Successfully..");
			 else
			    request.setAttribute("updatemsg","Data Not Updated ");
			  
}}



	


