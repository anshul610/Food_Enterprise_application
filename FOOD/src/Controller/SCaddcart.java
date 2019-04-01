package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Cartdisplay;
import Dao.Customerdao;

@WebServlet("/SCaddcart")
public class SCaddcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));System.out.println(pid);
		int quantity = Integer.parseInt(request.getParameter("quantity"));System.out.println(quantity);
		String pname=request.getParameter("pname");
		String price=request.getParameter("price");
		String file=request.getParameter("file");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("userloginbyemail");
		System.out.println(">>>>>>>>>>>>>>>"+email);
		
		Customerdao cdo = new Customerdao();
		int x=cdo.viewPid(pid, email);
         if(x==0)
         {
        	 RequestDispatcher rd = request.getRequestDispatcher("Sproductviewonindex");
				request.setAttribute("alreadyproduct", "Product Already Added..");
				rd.forward(request, response); 
				
				int z=cdo.updateproductQuantity(quantity,email,pid);
				if(z==0) {
					 RequestDispatcher rd1 = request.getRequestDispatcher("Sproductviewonindex");
						rd1.forward(request, response); 
				}
				
         }else {
        	 
         Cartdisplay cartbean= new Cartdisplay();
         cartbean.setPid(pid);
         cartbean.setQuantity(quantity);
         cartbean.setEmail(email);
         cartbean.setPname(pname);
         cartbean.setPrice(price);
         cartbean.setFile(file);
        
		int y  = cdo.Addcartdao(pid, quantity,pname,price, email,file);
		out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + y);
		if (y != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Sproductviewonindex");
			request.setAttribute("addcartmsg", "Product Add Successfully");
			rd.forward(request, response);
		}
         }
         }

}
