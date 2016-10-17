<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" href="assets/bootstrap.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
<link rel="stylesheet" href="assets/styles.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
<title></t>Login Page</title>
</head>
<body>
	<nav>
		<div class="nav-wrapper container">
			<a href="#" class="brand-logo center">Cool Application..duh.!</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">

				<li><a href="http://www.google.com"
					class="waves-effect waves-light btn">Google it.!</a></li>
				<li><a href="http://www.google.com">About Me</a></li>
				<li><a href="http://www.google.com">Really?</a></li>
			</ul>
		</div>
	</nav>
	<div class="body_container container">
		<div class="header_div">
			<!-- <h3 class = "headline">This is to be a login page.</h3> -->

			<h6>
				Current time in server is :
				<%=new java.util.Date()%></h6>
		</div>
	</div>
	<div class="container">
		<div class="row">

			<div class="col s6">
				<div class="row">
					<div class="col s10 center-align card-panel">
						<div class="input-field col s6">
							<form action="/Webapp/login" method="POST">
								<input placeholder="Username" id="user" name="user" type="text"
									class="validate"> <input type="password" name="pass"
									placeholder="Password" id="pass"></br> <input
									class="btn waves-effect waves-light" type="submit"
									name="submit" value="Press here to login">
							</form>
						</div>
					</div>

				</div>
			</div>
			<div class="col s6">
				<div class="row">
					<div class="col s10 center-align card-panel rheight">
						<div class="card-content">
							<span class="card-title center-align">REGISTER...ASAP</span>
							<div class="input-field col s8 mtop">
								<form action="/Webapp/register" method="POST" name="rForm">
									<input placeholder="Username" id="ruser" name="user"
										type="text" class="validate"> <input type="password"
										name="pass" placeholder="Password" id="rpass"> <input
										type="password" name="conpass" placeholder="Confirm password"
										id="conpass"></br> </br> </br> <input name="male" type="radio"
										id="male" /> <label for="male">Male</label> <input
										name="female" type="radio" id="female" /> <label for="female">Female</label>
									<input type="date" class="datepicker" placeholder="Select Date"></br>
									</br> <input class="btn waves-effect waves-light" type="button"
										name="register" id="register"
										value="REGISTER ME ASAP (AFTER VALIDATION USING AJAX)..!!">

								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- <div class="login_container">

			<h3>Login Here</h3>
			<form action="/Webapp/login" method="POST">
				<input type="text" name="user" placeholder="username" id="user"></br>
				<input type="password" name="pass" placeholder="password" id="pass"></br>
				<input type="button" name="click" value="AJAX CALL" id="click">
				<input type="submit" name="submit" value="Press here to login">

			</form>

			<p id=demo></p>
		</div>
		<div class="register_container">
			<h6>Join Now..Registration closing soon..!</h6>
			<form>
				<input type="text" name="username" placeholder="Username"> <input
					type="password" name="pass" placeholder="Password"> <input
					type="password" name="confirmPass" placeholder="passAgain">
				<input class="with-gap" type="date" name="date" placeholder="DOB"><br>
				<input type="radio" name="gender" value="male" checked> Male<br>
				<input class="with-gap" type="radio" name="gender" value="female">
				Female<br>
			</form>
		</div>
		<form>
			<input class="with-gap" type="radio" name="ab" value="ab">
			Hello
		</form> -->
	</div>
	<script type="text/javascript">
		$('.datepicker').pickadate({
			selectMonths : true, // Creates a dropdown to control month
			selectYears : 15
		// Creates a dropdown of 15 years to control year
		});
		// code for validation of UI during register usign javascript
		function validateForm() {
			var flag = true;
			// var x = document.forms["myForm"]["fname"].value;
			//if (x == null || x == "") {
			//alert("Name must be filled out");
			var user = $('#ruser').val();
			var pass = $('#rpass').val();
			var conpass = $('#conpass').val();
			if (user == "" || user == null) {
				//alert("Username is empty");
				flag = false;
				Materialize.toast("Username is empty", 2000);
			}
			if (pass == "" || pass == null) {
				//alert("Username is empty");
				flag = false;
				Materialize.toast("Password is empty", 2000);
			}
			if (conpass == "" || conpass == null) {
				//alert("Username is empty");
				flag = false;
				Materialize.toast("Confim Password is empty", 2000);
			}

			if (pass != conpass)

			{
				//alert("Username is empty");
				flag = false;
				Materialize.toast("Password's dont match..!!", 2000);
			}
			return Boolean(flag);
			//}
		}

		// code for validation of UI during register usign javascript

		jQuery(document).ready(
				function($) {

					$("#register").click(function(event) {
								if (validateForm() == true) {

									var user = $('#ruser').val();
									var pass = $('#rpass').val();
									Materialize.toast(user + "  :  " + pass
											+ "   Registered", 2000);
									var regdata = {
										userName : user,
										password : pass
									}
									callmyajax(user,pass,regdata);
								}
								else{
									console.log("Whoops error");
								}
							});

				});
		
		function callmyajax(user,pass,regdata){
			$.ajax({
				url : "http://localhost:8080/Webapp/tester",
				type:"GET",
				dataType:"html",
				data : /* JSON.stringify(regdata) */regdata,
				success : function(result) {
					console.log(result);
					//$("div").html(result);
				}
			});
		}
		/* headers: { 
	      'Accept': 'application/json',
	      'Content-Type': 'application/json' 
	  }  */
	</script>
</body>
</html>