package Controller;

import java.io.IOException;
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

import Beans.Cartdisplay;
import Beans.Orderbean;
import Dao.Customerdao;

@WebServlet("/SCorderplace")
public class SCorderplace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void sendMail(String to,String sub,String msg)
	{
	
		String from = "anshulagrawal989@gmail.com";
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customerdao ordercd= new Customerdao();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("userloginbyemail");		
  		int x=ordercd.orderplace(email);
  		String sub="Your Orders is Placed ";
  		String msg="order is delivered in working days between 1 to 5 days";
  		  		if (x!=0) {
  		  	
  		  		sendMail(email,sub,msg);
  		  		ordercd.empty_cart_after_orderplaced(email);
  		  		ArrayList<Cartdisplay> list=ordercd.viewCartItems(email);		
			RequestDispatcher rd = request.getRequestDispatcher("Displayusercart.jsp");
			request.setAttribute("LIST",list);
			request.setAttribute("ordmsg", "Order placed successfully Successfully");
			rd.forward(request, response);
			}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
