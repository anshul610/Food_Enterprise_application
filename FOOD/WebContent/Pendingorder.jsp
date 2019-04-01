<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@page import="java.util.ArrayList,Beans.Orderbean" %>
  <%@include file="Adminheader.jsp" %>
  <br></br>
</head>
 <body style="background-color:#f98ea2;">
 
 <%String dm = (String) request.getAttribute("dispmsg");
		if (dm != null) {%>
	<div class="alert alert-success" style="margin-top:25px"  >
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=dm%></strong>
	</div>
	<%}%> 
	<div class="container" style="margin-top:72px">            
  <table class="table table-hover">
    <thead>
      <tr><th><strong>Order ID</strong></th><th><strong>Product ID</strong></th><th><strong>Quantity</strong></th><th><strong>Price</strong></th><th><strong>Email<strong></th></tr>
    </thead>
  <%
ArrayList<Orderbean> list=( ArrayList<Orderbean>)request.getAttribute("LIST");
for(Orderbean e:list)
{
	%>
	<tr>
	<td><%=e.getOrderid() %></td>
  <td> <%=e.getPid() %> </td>
  <td> <%=e.getQuantity() %></td>
  <td> <%=e.getPrice()%></td>
   <td> <%=e.getEmail()%></td> 
   <td> <a href="SDispatched?orderid=<%=e.getOrderid() %>" 
   data-toggle="tooltip" data-placement="top" title="Dispatched Order"class="glyphicon glyphicon-send" style="color:blue;font-size: 40px;"></a>
     </td>
   </tr>
    
<%
}	
%> 	        
</table>
</body>
</html>


