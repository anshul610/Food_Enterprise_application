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
import Beans.Signupbean;
import Dao.Customerdao;


@WebServlet("/SCsignup")
public class SCsignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String upwd=request.getParameter("upwd");
		String caddress=request.getParameter("caddress");
		Signupbean bean = new Signupbean();
		bean.setFname(fname);   bean.setLname(lname);
	    bean.setEmail(email);    bean.setPhone(phone);    bean.setUpwd(upwd);  bean.setCaddress(caddress);
		Customerdao cdo=new Customerdao();
		try {
			int x = cdo.signupdetails(bean);
			if (x!=0) {
				RequestDispatcher rd = request.getRequestDispatcher("Start.jsp");
				request.setAttribute("msg", "Registerd Successfully");
				rd.forward(request, response);}
		} catch (SQLException exx) {exx.printStackTrace();}
	}// Dopost end
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String duplicaymsg = null ;
		String email=request.getParameter("email");
		Customerdao cdo=new Customerdao();
		try {  
			Thread.sleep(1500);
			int x=cdo.Duplicateemailcheck(email);
			if(x!=0){			
			 out.println("<font color=red>Already Exist</font>");
			}else
			out.println("<font color=green>Avaliable</font>");
		} catch (Exception e) {e.printStackTrace();}
}// Doget end
}

