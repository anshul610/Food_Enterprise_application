<html>
<head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 62%;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
</style>
</head>
<%@include file="Viewheader.jsp"%><br>
<body style="background-color:powderblue;">
	<%
		String m = (String) request.getAttribute("addcartmsg");
		if (m != null) {
	%>
	<div class="alert alert-success" style="margin-top: 30px">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=m%></strong>
	</div>
	<%
		}
	%>

	<%
		String mq = (String) request.getAttribute("msg");
		if (mq != null) {
	%>
	<div class="alert alert-success alert-dismissible"
		style="margin-top: 30px">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=mq%></strong>
	</div>
	<%
		}
	%>
	
	<%
		String forgotmsg = (String) request.getAttribute("fpm");
		if (forgotmsg != null) {
	%>
	<div class="alert alert-success alert-dismissible"
		style="margin-top: 30px">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong><%=forgotmsg%></strong>
	</div>
	<%
		}
	%>

	<div class="container"
		style="margin-top: 70px; font-size: 20px; color: white; text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;">
		<marquee direction="left" scroll amount="100" loop="5"
			behavior="slide">
			<h2>Who is Zappy?</h2>
		</marquee>
		<p>Zappy is your kitchen convenience partner.Zappy is an endeavor
			to bring you the convenience of preparing healthy food that tastes as
			good as home made. It also the reason why you feel happy whenever you
			open a Zappy pack!</p>
	</div>
	<div class="row">
	<div class="container" style="margin-top: 70px">
		<%@page import="java.util.ArrayList,Beans.Foodbean"%>
		<%
			ArrayList<Foodbean> list = (ArrayList<Foodbean>) request.getAttribute("LIST");
			for (Foodbean e : list) {
		%>

			<div class="col-md-3">
				<div class="card mb-3 box-shadow">
					<a href="details/{{i
          .id}}"><img
						class="card-img-top" height="150" ;width= "150"; src="imgupload/<%=e.getFile()%>"
						alt="Card image cap"></a>
					<div class="card-body">
						<p class="card-text"><%=e.getPname()%></p>
						<div class="d-flex justify-content-between align-items-center">

							<form action="SCaddcart" method="post">
								<h5 class="text-muted" style="color: black">
									<i class="fa fa-rupee"><%=e.getPrice()%></i> RS.
								</h5>
								<div class="form-group">
									<label>Quantity</label> <input type="number" name="quantity"
										value="1" min="1" size="3" maxlength="3" class="form-control">
								</div>
								<div class="btn-group">
									<input type="submit"
										class="btn btn btn-outline-secondary btn-sm" value="Add to
									Cart" />
									<%--  onClick="return confirm('Please Login to add cart -----> Tap Cancel')"--%>
								</div>
								<input type="hidden" name="pid" value="<%=e.getPid()%>" /><br>
								<input type="hidden" name="price" value="<%=e.getPrice()%>" /><br>
								<input type="hidden" name="pname" value="<%=e.getPname()%>" /><br>
								<input type="hidden" name="file" value="<%=e.getFile()%>" /><br>
							</form>
						</div>
					</div>
				</div></div>
		<%
			}
		%>
	
			
		</div>
	</div>
</body>
</html>
