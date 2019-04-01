<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<%@include file="Adminheader.jsp"%>
<br></br>
<body style="background-color:#f98ea2;">
	<%String um = (String) request.getAttribute("updatemsg");
		if (um != null) {%>
	<div class="alert alert-success" style="margin-top:25px"  >
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=um%></strong>
	</div>
	<%}%>
	
	<%String umi = (String) request.getAttribute("updatemsgimage");
		if (umi != null) {%>
	<div class="alert alert-success" style="margin-top:25px"  >
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=umi%></strong>
	</div>
	<%}%>
  <div class="container">
	<div class="row">
	 <h3>UPDATE PRODUCTS LIST</h3>
	  <%@page import="Beans.Foodbean"%>
		<%
		  Foodbean e = (Foodbean) request.getAttribute("PRO");
		%> 
<!----------------------------------------------- 1st card view --------------------------------------------------------->
  <aside class="col-sm-4">
	<div class="card">
	 <article class="card-body">
	  <h4 class="card-title mb-4 mt-1">Update Products</h4>
		<form action="Supdate" method="post">
		
		 <div class="form-group">
	      <label>PRODUCT ID</label> <input type="number" class="form-control" name="pid" value="<%=e.getPid()%>" readonly></div>
			
		 <div class="form-group">
	      <label>PRODUCT NAME</label> <input type="text" class="form-control" name="pname" value="<%=e.getPname()%>" required /></div>
				
		 <div class="form-group">
		  <label>Category</label> <input type="text" class="form-control" name="category" value="<%=e.getCategory()%>"  required /></div>
		
		 <div class="form-group">
		  <label>PRICE</label> <input type="number" class="form-control" name="price" value="<%=e.getPrice()%>" required></div>

		 <div class="form-group">
		  <label>DESCRIPTION</label> <input type="text" class="form-control" value="<%=e.getDescription()%>" name="description"> </div>
         
         <div class="form-group"> 
         <label>PRODUCT CURRENT SET IMAGE</label><br>
          <img src="imgupload/<%=e.getFile()%>" height="120" width="120" readonly/><br>
          <br></br>
			<button type="submit" class="btn btn-primary btn-md" onClick="return confirm('Do you realy want to Update?')">Update</button>
		</form>
	 </article>
	 <!-------------------------------------------- End of 1st card view ---------------------------------------------------------------------------------------->
	</div>
 </aside>
 <!--------------------------------------------------------2nd card view ----------------------------------------------------------------------------->
 <aside class="col-sm-4">
    <div class="card">
	 <article class="card-body">
		<h4 class="card-title mb-4 mt-1"></h4>	
	</article>
	</div>
  </aside> 
  <!-------------------------------------------- End of 2nd card view ---------------------------------------------------------------------------------------->
<!-------------------------------------------- 3rd card view ------------------------------------------------------------------------------------------>
  <aside class="col-sm-4">
  
 <div class="card">

	  <article class="card-body">
		<h4 class="card-title mb-4 mt-1">Update Products by Image</h4>
		 <form action="Supdatebyimage" method="post" enctype="multipart/form-data">
           <div class="form-group">
			<label>PRODUCT ID</label> <input type="text" class="form-control" name="pid" value="<%=e.getPid()%>" readonly /></div>
				
				<label>PRODUCT CURRENT SET IMAGE</label><br>
          <img src="imgupload/<%=e.getFile()%>" height="120" width="120"/><br>
          <br></br>			
			 <div class="input-group">
			   <div class="input-group-prepend">
				 <span class="input-group-text" id="inputGroupFileAddon01"></span>
			  </div>
			  <div class="custom-file">
			  <label><h4>Upload File</h4> <input type="file" class="form-control" name="file" required>
			</div>
			</div>	
			 <button type="submit" class="btn btn-primary btn-md" onClick="return confirm('Do you realy want to Update?')">Update</button> </form>
		</article>
	</div>
	</div>
</aside>
<!-------------------------------------------- End of 3rd card view ---------------------------------------------------------------------------------------->
</div>
</div>
<body>
</html>



