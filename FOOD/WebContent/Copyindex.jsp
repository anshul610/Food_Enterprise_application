<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<%@include file="Viewheader.jsp" %><br>
<%--<%@include file="View_Header_after_login.jsp" %><br>--%>
 <body background="image/EF.jpg">
 <%
		String m = (String) request.getAttribute("addcartmsg");
		if (m != null) {
	%>
	<div class="alert alert-success" style="margin-top:30px">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=m%></strong>
	</div>
	<%
		}
	%>
<!--  <div class="container">-->
<div class="container" style="margin-top:70px">
<h3>       </h3>
  <div class="row">
<%@page import="java.sql.*" %>
<%
try {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappydb","root","");
	  PreparedStatement ps=con.prepareStatement("select  * from product");
	  ResultSet rs=ps.executeQuery();
	  while(rs.next())
	  {
		  %>
      <div class="col-md-3">
        <div class="card mb-3 box-shadow" >
          <a href="details/{{i
          .id}}"><img class="card-img-top" height="150" src="imgupload/<%=rs.getString("image")%>" alt="Card image cap"></a>
          <div class="card-body">
            <p class="card-text"><%=rs.getString("pname")%></p>
            <div class="d-flex justify-content-between align-items-center">
             <form action="Saddcart" method="post">
                <h5 class="text-muted"><i class="fa fa-rupee">150 RS.</i></h5>    
            Quantity<input type="number" name="quantity" value="1" min="1" size="3" maxlength="3">
            <div class="btn-group">
                <button type="submit" class="btn btn btn-outline-secondary btn-sm">Add to Cart</button>&nbsp&nbsp
               </div>  
            <input type="hidden" name="pid" value="<%=rs.getInt("pid")%>" /><br>
            
           </form>
            </div>
          </div>
        </div>
     </div>
    <%}
	  con.close();
}catch(Exception e){ System.out.println(e);}
%> 
  </div>
  </div>



</body>
</html> 