<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 70%;
}
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
</style>
</head>
<%@include file="Adminheader.jsp" %><br>
<%--<%@include file="View_Header_after_login.jsp" %><br>--%>
<body style="background-color:#f24372;">
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
<div class="container" style="margin-top:70px;font-size:20px;color:white;text-shadow: 1px 1px 2px black, 0 0 25px red, 0 0 5px darkred;" >
  <h2>What is Zappy?</h2>
  <p>
Zappy is your kitchen convenience partner.Zappy is an endeavor to bring you the 
convenience of preparing healthy food that tastes as good as home made. It also 
the reason why you feel happy whenever you open a Zappy pack!</p>
</div>
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
             <form action="SCaddcart" method="post">
      <h5 class="text-muted" style="color: black" ><i class="fa fa-rupee"><%=rs.getString("price")%></i> RS.</h5>  
            <div class="form-group">
    <label>Quantity</label> <input type="number" name="quantity" value="1" min="1" size="3" maxlength="3" class="form-control" >
          </div>
            <div class="btn-group">
                <button type="submit" class="btn btn btn-outline-secondary btn-sm" onClick="return confirm('Please Login to add cart')">Add to Cart</button>&nbsp&nbsp
             <%--   onclick="window.location.href='Duallogin.jsp'"--%>
               </div>  
            <input type="hidden" name="pid" value="<%=rs.getInt("pid")%>" /><br>
            <input type="hidden" name="price" value="<%=rs.getString("price")%>" /><br>
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