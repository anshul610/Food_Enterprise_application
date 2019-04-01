<html lang="en">

<%@include file="Adminheader.jsp" %><br>
<body style="background-color:#f98ea2;">
<body>
<div class="container-fluid" style="margin-top:265px" >
<% 
String u=(String)session.getAttribute("loginadmin");
response.setHeader("pragma", "no-cache");
response.setHeader("cache-control", "no-store");
response.setHeader("expire", "0");
%>
 <span align="center"><strong><h2 style="font-size:60px;color:white;text-shadow: 1px 1px 2px black, 0 0 25px red, 0 0 5px darkred;" ><b>Welcome Admin Home</b></h2></strong></span>
</div>
</body>
</html>


