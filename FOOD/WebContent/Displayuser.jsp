<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@page import="java.util.ArrayList,Beans.Signupbean" %>
  <%@include file="Adminheader.jsp" %>
  <br></br>
 <body style="background-color:#f98ea2;">
</head>
<body>
	<div class="container" style="margin-top:72px">            
  <table class="table table-hover">
    <thead>
      <tr><th><strong>FirstName</strong></th><th><strong>LastName</strong></th><th><strong>Email-ID</strong></th><th><strong>Phone<strong></th><th><strong>User Password<strong></th><th><strong>Contact address</strong></th></tr>
    </thead>
  <%
ArrayList<Signupbean> list=( ArrayList<Signupbean>)request.getAttribute("LIST");
for(Signupbean e:list)
{
	%>
	<tr>
  <td> <%=e.getFname() %> </td>
  <td> <%=e.getLname() %></td>
  <td> <%=e.getEmail()%></td>
   <td> <%=e.getPhone()%></td>
    <td> <%=e.getUpwd()%></td>
    <td> <%=e.getCaddress()%></td>

   </tr>
    
<%
}	
%> 	        
</table>
</body>
</html>


