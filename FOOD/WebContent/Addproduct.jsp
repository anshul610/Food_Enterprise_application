<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="Adminheader.jsp" %>
<br></br>
<body style="background-color:#f24372;">
<body >
	<% String m = (String) request.getAttribute("msg");
		if (m != null) {
	%>
	<div class="alert alert-success" style="margin-top:15px">
	<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
     <strong><%=m%></strong>
</div>
	<%
		}
	%>

<div class="container" style="margin-top:65px">
<div class="col-sm-6">
<form action="Saddproduct" method="post" enctype="multipart/form-data">
<div class="form-group"><h4>Choose Product</h4></label>
     <select class="form-control" name="category">
         <option value="eat">Ready to Eat</option>
         <option value="cook">Ready to Cook</option>
         <option value=drink">Read to Drink</option> 
     </select> 
 </div>
<div class="form-group"><label><h4>Product Name</h4></label>
<input type="text" class="form-control" name="pname" required /></div>
				
<div class="form-group"><label><h4>Price</h4></label> 
<input type="number" class="form-control" name="price" required /></div>
				
<div class="form-group"><label><h4>Description</h4></label>
<textarea class="form-control" rows="5"  name="description"></textarea></div>

<div class="input-group">
<div class="input-group-prepend">
<span class="input-group-text" id="inputGroupFileAddon01"></span></div>
<div class="custom-file"><label><h4>Uploadfile</h4>
<input type="file" class="custom-file-input" name="file" aria-describedby="inputGroupFileAddon01"></div>
</div>
 
 <button type="submit" class="btn btn-primary btn-md">Add</button>		
 </form>
</div>
</body>
</html>