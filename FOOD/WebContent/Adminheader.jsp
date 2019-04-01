<html>
<head>  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style type="text/css">
 .navbar {
  min-height: 150px;
}
.navbar-inverse {
  background-color:#000000;
  border-color: #f9f1ef;
}
  
  </style>
</head>
<body>
 <nav class="navbar navbar-inverse"> <div class="container-fluid">  <div class="navbar-header">
<%-- <nav class="navbar navbar-inverse navbar-fixed-top"> <div class="container-fluid">  <div class="navbar-header">--%>
   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
    <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
    <!--  <a class="navbar-brand" href="#" style="font-size:48px;color:white">ZappyFood</a> --> 
      <a class="navbar-brand" href="#"><img src="image/logotrans.png" width="370" height="140"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">  <ul class="nav navbar-nav"> 
    <li><a href="Admin_clone_ index_after_login.jsp"><i class="glyphicon glyphicon-home" style="font-size:26px;color:white;margin-top:35px"></i> Home</a></li>
    <li><a href="Addproduct.jsp"><i class="glyphicon glyphicon-plus" style="font-size:26px;color:white;margin-top:35px"></i>Product</a></li>
 <li><a href="Sdisplay"><i class="glyphicon glyphicon-eye-open" style="font-size:26px;color:white;margin-top:35px"></i>All Product</a></li>
 <li><a href="Spendingorder"><i class="glyphicon glyphicon-list-alt" style="font-size:26px;color:white;margin-top:35px"></i>Pending Order</a></li>
 <li><a href="Sorderhistory"><i class="glyphicon glyphicon-stats" style="font-size:26px;color:white;margin-top:35px"></i>Order History</a></li>
 <li><a href="Sreguserdisplay"><i class="glyphicon glyphicon-registration-mark" style="font-size:26px;color:white;margin-top:35px"></i>Registerd Users</a></li>
<li><a href="#" style="font-size:25px;color:white;margin-top:35px">Welcome,
      <%
      String user=(String)session.getAttribute("loginadmin");
     response.setHeader("pragma", "no-cache");
     response.setHeader("cache-control", "no-store");
     response.setHeader("expire", "0");
      if(user==null){
    	  response.sendRedirect("index.jsp");
      }
      out.println(user);
      %>
      </a></li>
      </ul><ul class="nav navbar-nav navbar-right"> 
        <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out" style="font-size:25px;color:white;margin-top:35px"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<!--<div class="container" >
  <h3>Collapsible Navbar</h3>
  <p>In this example, the navigation bar is hidden on small screens and replaced by a button in the top right corner (try to re-size this window).
  <p>Only when the button is clicked, the navigation bar will be displayed.</p>
</div>

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
   -->
</body>
</html>
