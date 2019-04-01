<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.navbar {
min-height: 150px;
}
.navbar-inverse {
background-color: #24478f;
border-color: #f9f1ef;
}
</style>
<script>
  $(document)
  .ready( function() {
	$("#jemail").blur(function() {
								var email = $("#jemail").val(); //alert(email);
								var mydata = "email=" + email;
								$("#duplicaymsg")
								.html("<img src='image/spin.gif' height='40' width='40' ><font color=gray> Checking availability...</font>");//alert(mydata);
								$.ajax({
										url : 'SCsignup',
										data : mydata,
									    type : 'get',
										success : function(response) { //alert(response);
								$("#duplicaymsg").html(response);
									if (response.includes("Already"))
									$("#jemail").val("");
								}
					    	});
			        	});
					});
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
	  <div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		   <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
			 <a class="navbar-brand" href="#"><img src="image/logotrans.png" width="380" height="130"></a>
			 </div>
		<div class="collapse navbar-collapse" id="myNavbar">
		   <ul class="nav navbar-nav">
			 <li><a href="Sproductviewonindex"><i class="glyphicon glyphicon-home" style="font-size: 32px; color: white; margin-top: 35px"></i> Home</a></li>
			   <li><a href="Sproductviewonindex"><i
							class="glyphicon glyphicon-question-sign"
							style="font-size: 32px; color: white; margin-top: 33px"></i style="color: white;">What's
							Zappy</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-asterisk"
							style="font-size: 32px; color: white; margin-top: 33px"></i>Spreading
							Zappiness</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-plus"
							style="font-size: 32px; color: white; margin-top: 33px"></i>Join
							us</a></li>


					<%
						String ulte = (String) session.getAttribute("userloginbyemail");
						if (ulte == null) {
					%>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/" data-toggle="modal" data-target="#myModal1"><span
								class="glyphicon glyphicon-log-in"
								style="font-size: 32px; color: white; margin-top: 33px"></span>
								LogIn</a></li>
						<!-- Modal -->
						<div class="modal fade bs-modal-sm" id="myModal1" tabindex="-1"
							role="dialog" aria-labelledby="mySmallModalLabel"
							aria-hidden="true" >
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">
									<br>
									<div class="bs-example bs-example-tabs">
										<ul id="myTab" class="nav nav-tabs">
											<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
											<li class=""><a href="#Alogin" data-toggle="tab">Authorized
													Login</a></li>
											<li class=""><a href="#UserDelete" data-toggle="tab">Delete
													Account?</a></li>
											<li class=""><a href="#Forgotpassword" data-toggle="tab" style="color: red">Forgot 
											Password?</i></a></li></ul></div>
									<div class="modal-body">
										<div id="myTabContent" class="tab-content">
											<div class="tab-pane fade active in" id="login">
												<form action="SClogin" method="post">
													<div class="form-group">
														<label>Email</label> <input type="text"
															class="form-control" value="" name="email" required /></div>

													<div class="form-group">
														<label>Password</label> <input type="password"
															class="form-control" name="upwd" value="" required />
													</div>
													<button type="submit" class="btn btn-success">Login</button>
													
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
                                                 </form>
											</div>
											<div class="tab-pane fade" id="Alogin">
												<form action="Slogin" method="post">

													<div class="form-group">
														<label>Admin</label> <input type="text"
															class="form-control" value="" name="uid" required />
													</div>

													<div class="form-group">
														<label>Password</label> <input type="password"
															class="form-control" name="pwd" value="" required />
													</div>
													<button type="submit" class="btn btn-success">AdminLogin</button>
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
												</form>
											</div>
											
											<div class="tab-pane fade" id="Forgotpassword">
												<form action="SCForgotpassword" method="post">

													<div class="form-group">
														<label>Email</label> <input type="text"
															class="form-control" value="" name="email" required />
													</div>
													<button type="submit" class="btn btn-info">Resend</button>
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
												</form>
											</div>
											
											<div class="tab-pane fade" id="UserDelete">
												<form action="SCdelete" method="post">

													<div class="form-group">
														<label>Email</label> <input type="text"
															class="form-control" value="" name="email" required />
													</div>

													<div class="form-group">
														<label>Password</label> <input type="password"
															class="form-control" name="upwd" value="" required />
													</div>
													<button type="submit" class="btn btn-danger"
														onClick="return confirm('Do you really want ot delete?')">Delete</button>
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
												</form>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="/" data-toggle="modal" data-target="#myModal"><span
								class="glyphicon glyphicon-edit"
								style="font-size: 32px; color: white; margin-top: 33px"></span>
								SignUp</a></li>

						<div class="modal fade" id="myModal">
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">
									<!-- Modal Header -->
									<div class="modal-header">
										<h4 class="modal-title" style="color: Blue" align="center">
											<strong>Signup From</strong>
										</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<div class="modal-body">
										<form action="SCsignup" method="post">

											<div class="form-group">
												<label>First Name</label> <input type="text" name="fname"
													class="form-control my-input" placeholder="First Name"
													required />
											</div>

											<div class="form-group">
												<label>Last Name</label> <input type="text" name="lname"
													class="form-control my-input" placeholder="Last Name"
													required />
											</div>

											<div class="form-group">
												<label>Email ID</label> <input type="email" name="email"
													id="jemail" class="form-control my-input"
													placeholder="Email" required />
												<div id="duplicaymsg"></div>
											</div>

											<div class="form-group">
												<label>Contact Number</label> <input type="tel" min="0"
													max="10" name="phone" class="form-control my-input"
													placeholder="Phone" pattern="^\d{4}\d{3}\d{3}$" required />
											</div>

											<div class="form-group">
												<label>Password</label> <input type="password" min="6"
													name="upwd" class="form-control my-input"
													placeholder="Password" required />
											</div>

											<div class="form-group">
												<label>Contact Address</label>
												<textarea class="form-control" rows="5" id="caddress"
													name="caddress" placeholder="Enter your Address to Deliver"
													required /></textarea>
											</div>

											<div class="text-center ">
												<button type="submit" style="color: black"
													class=" btn btn-block send-button tx-tfm">Create
													Your Account</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

					</ul>
					<%
						} else {
					%>
					<li><a href="#"
						style="font-size: 15px; color: white; margin-top: 35px">Welcome,<%=ulte%>

					</a></li>
					<li><a href="SCcartdisplay"><i
							class="glyphicon glyphicon-inbox"
							style="font-size: 32px; color: white; margin-top: 33px"></i>View
							Cart</a></li>
							<li><a href="SCorderstatus"><i
							class="glyphicon glyphicon-flag"
							style="font-size: 32px; color: white; margin-top: 33px"></i>OrderStatus</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="logout.jsp"><span
							class="glyphicon glyphicon-log-out"
							style="font-size: 32px; color: white; margin-top: 33px"></span>
							LogOut</a></li>
				</ul>
				<%}%>
			</div>
		</div>
	</nav>
</body>
</html>
