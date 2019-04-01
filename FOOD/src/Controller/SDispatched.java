package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Foodbean;
import Beans.Orderbean;
import Dao.DbDao;

@WebServlet("/SDispatched")
public class SDispatched extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void sendMail(String to,String sub,String msg)
	{	String from = "anshulagrawal989@gmail.com";
	    final String username =  "anshulagrawal989@gmail.com";//change accordingly
	    final String password = "Agrawal@89896";//change accordingly

	    // Assuming you are sending email through relay.jangosmtp.net
	    String host = "smtp.gmail.com";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "587");

	    // Get the Session object.
	    Session session = Session.getInstance(props,
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(username, password);
	       }
	    });

	    try {
	    	 Message message = new MimeMessage(session); // Create a default MimeMessage object.
	     
	    	 message.setFrom(new InternetAddress(from)); // Set From: header field of the header.
	      
	    	 message.setRecipients(Message.RecipientType.TO,
	    		       InternetAddress.parse(to));  // Set To: header field of the header.
	      
	    	 message.setSubject(sub); // Set Subject: header field   
	     
	    	 message.setText(msg);  // Now set the actual message   
	       
	    	 Transport.send(message);   // Send message
	       } catch (MessagingException e) { e.printStackTrace();}		
	}  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String email = (String) session.getAttribute("userloginbyemail");
		int orderid = Integer.parseInt(request.getParameter("orderid"));System.out.println(orderid);
		DbDao d=new DbDao();
		
		int y;
		try {
			y = d.dispatch_user_order(orderid);
			String sendemail=d.email_dispatch_user_order(orderid);
			String sub="your order is dispatched";
			String msg="your order is dispatched and delivered soon.";
			sendMail(sendemail, sub, msg);
		    ArrayList<Orderbean> list = d.viewAllPendingOrder();
			request.setAttribute("LIST",list);
			 if(y!=0)
					  request.setAttribute("dispmsg"," Order dispatched successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Pendingorder.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {e.printStackTrace();}
	}
}
