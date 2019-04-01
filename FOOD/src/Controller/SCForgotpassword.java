package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import Dao.Customerdao;

@WebServlet("/SCForgotpassword")
public class SCForgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}
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
	       // Create a default MimeMessage object.
	       Message message = new MimeMessage(session);

	       // Set From: header field of the header.
	       message.setFrom(new InternetAddress(from));

	       // Set To: header field of the header.
	       message.setRecipients(Message.RecipientType.TO,
	       InternetAddress.parse(to));

	       // Set Subject: header field   
	       message.setSubject(sub);

	       // Now set the actual message   
	       message.setText(msg);

	       // Send message
	       
	       Transport.send(message);
	       } catch (MessagingException e) { e.printStackTrace();}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email= request.getParameter("email");
		String fpassword="null";
		Customerdao cdo= new Customerdao();
		
			 fpassword=cdo.Forgotpassword(email);
			 String msg="you password is" + fpassword;
				sendMail(email, fpassword,msg);
				RequestDispatcher rd= request.getRequestDispatcher("Start.jsp");
				request.setAttribute("fpm","Password Send Successfully to mail..");
				rd.forward(request, response);	
	}	
	}

