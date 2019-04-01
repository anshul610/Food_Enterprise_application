<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@page import="java.util.ArrayList,Beans.Orderbean" %>
  <%@include file="Viewheader.jsp" %>
  <br></br>

</head>
<body style="background-color:powderblue;">
	<div class="container" style="margin-top:72px">
	           
  <table class="table table-hover">
    <thead>
      <tr><th><strong>Order Id</strong></th><th><strong>Product Id</strong></th><th><strong>Quantity</strong></th><th><strong>Email-ID<strong></th><th><strong>Price<strong></th><th><strong>Order Status</strong></th></tr>
    </thead>
 <%
ArrayList<Orderbean> list=( ArrayList<Orderbean>)request.getAttribute("LIST");
for(Orderbean oe:list)
{
	%>  
	<tr>
  <td> <%=oe.getOrderid() %> </td>
   <td> <%=oe.getPid() %> </td>
      <td> <%=oe.getQuantity()%> </td>
         <td> <%=oe.getEmail() %> </td>
            <td> <%=oe.getPrice() %> </td>
               <td> <%int y=oe.getOrderstatus(); 
               if(y==1){
            	   out.println("Order Dispatched");
               }else{
            	   out.println("Order not Dispatched");
               }
               %> </td>
               <%
}	
%> 
   </tr>
</table> 
	
</div>        
</body>
</html>


