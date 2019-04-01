<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%@page import="java.util.ArrayList,Beans.Foodbean" %>
  <%@include file="Adminheader.jsp" %>
  <br></br>
  <body style="background-color:#f98ea2;">
</head>
<body>
<% String dm = (String) request.getAttribute("deletemsg");
		if (dm != null) {
	%>
	<div class="alert alert-success" style="margin-top:22px">
	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
     <strong><%=dm%></strong>
</div>
	<%
		}
	%>
	<div class="container" style="margin-top:72px">            
  <table class="table table-hover">
    <thead>
      <tr><th><strong>Product ID</strong></th><th><strong>CATEGORY</strong></th><th><strong>PNAME</strong></th><th><strong>PRICE</strong></th><th><strong>DESCRIPTION</strong></th><th><strong>IMAGE<strong></th></tr>
    </thead>
  <%
ArrayList<Foodbean> list=( ArrayList<Foodbean>)request.getAttribute("LIST");
for(Foodbean e:list)
{
	%>
	<tr>
	<td><%= e.getPid()%></td>
   <td><%= e.getCategory()%></td>
  <td> <%=e.getPname() %> </td>
  <td> <%=e.getPrice() %></td>
  <td> <%=e.getDescription()%></td>
  <td><img src="imgupload/<%=e.getFile()%>" height="100" width="100"/></td>
   <td> <a href="Sdelete?pname=<%=e.getPname() %>" data-toggle="tooltip" data-placement="top" title="Delete"class="glyphicon glyphicon-remove-circle"  style="color:red"
     onClick="return confirm('Do you really want ot delete?')"></a>
  <%--<a href="Supdate?pname=<%=e.getPname() %>" data-toggle="tooltip" data-placement="top" title="Update"class=" glyphicon glyphicon-edit" ></a> --%> 
      <a href="Supdate?pid=<%=e.getPid() %>" data-toggle="tooltip" data-placement="top" title="Update"class=" glyphicon glyphicon-edit" style="color:blue"></a>
     </td>
   </tr>
    
<%
}	
%> 	        
</table></div>
</body>
</html>


