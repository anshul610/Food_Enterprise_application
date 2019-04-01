<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@page import="java.util.ArrayList,Beans.Cartdisplay" %>
  <%@include file="Viewheader.jsp" %>
  <br></br>
</head>
<body>
	<% int sum=0; %>
	<% String om = (String) request.getAttribute("ordmsg");
		if (om != null) {%>
<div class="alert alert-success" style="margin-top:25px"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
     <strong><%=om%></strong></div><%}%>
	
	<div class="container" style="margin-top:72px">            
  <table class="table table-hover">
    <thead>
      <tr><th><strong>PID</strong></th><th><strong>Product Image</strong></th>
      <th><strong>Product Name</strong></th><th><strong>Price</strong></th>
      <th><strong>Quantity</strong></th> <th><strong>SubTotal</strong></th> </tr>
    </thead>
 <%
ArrayList<Cartdisplay> list=( ArrayList<Cartdisplay>)request.getAttribute("LIST");
for(Cartdisplay cd:list)
{%>
	<tr>
 <td><%=cd.getPid() %></td>
   <td><img src="imgupload/<%=cd.getFile()%>" height="100" width="100"/></td>
   <td><%= cd.getPname()%></td>
   <td><%=cd.getPrice() %></td>
	   <td><%=cd.getQuantity() %></td>
	   <%int total=0; 
	   int p=Integer.parseInt(cd.getPrice());
	   int q=cd.getQuantity();
	   total=total+(p*q);
	   sum=sum+total ;
	   %><td><%=total %></td>
 <td> <a href="SCproductremove?pid=<%=cd.getPid() %>" data-toggle="tooltip" data-placement="top" title="Remove"class="glyphicon glyphicon-remove-circle"  style="color:red"
     onClick="return confirm('Do you want to remove?')"></a>
     </td>
   </tr><%} %> 
   <tfoot>
						
						<tr>
							<td><a href="Sproductviewonindex" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>	<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total  <%=sum%></strong></td>
						<td><form action="SCorderplace"  method="post"> <h3  align="right">
 <input type="submit" class="btn btn-success" value="Placed order"></input></h3> </form> </td>
						
						</tr>
					</tfoot>   
<%--<%}%>--%> 	 
</table>
</div>
</body>
</html>


