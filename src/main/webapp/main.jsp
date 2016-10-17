<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="ISO-8859-1">
<!-- <script src="javascript/jquery-3.1.1.js" type="text/javascript"></script> -->


<!--<link rel="stylesheet" href="assets/bootstrap.css">-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
<link rel="stylesheet" href="assets/mainstyle.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
<script src=assets/location.js type=></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location App</title>
</head>
<body>


	<nav>
	<div class="nav-wrapper ">
		<a href="#" class="brand-logo center">Functionalities....!</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">

			<li><a href="http://www.google.com"
				class="waves-effect waves-light btn">Google it.!</a></li>
			<li><a href="http://www.google.com">About Me</a></li>
			<li><a href="http://www.google.com">Really?</a></li>
		</ul>
	</div>
	</nav>
	<div class="divider" style="height: 10px; margin: 10px;"></div>

	<div class="container">

		<!-- CSS HEADER CAN BE USED ALSO -->
		<!-- <div class="header">
		<h1>Location App</h1>
		<p id="tagline">Maps meets Spring</p>
	</div> -->
		<div class="row">
			<div class="col s5" id="map"></div>
			<div class="col s1" id="showblog">
				<input type="button" id="btnblog" value="Show Blog" class="">
			</div>
			<div class="col s6" id="blog">
				<div class="col s12" id="list"
					style="height: 250px; overflow-y: scroll">
					<ul id="msgs">
						<li>Hello....</li>
						<li>How are you?</li>
						<li>What can I do for you?</li>
						<li>Nobody is replying...</li>
						<li>I can see you there.... :D</li>
						<li>Hi....</li>
						<li>Hello....</li>

					</ul>
				</div>

				<div class="row">
					<div class="col s12 card-panel">
						<div class="row">
							<input class="col s8" type="text" placeholder="Type Here" id="chat">
							<div class="col s4">
								<input class="waves-effect waves-light btn" type="button"
									value="Send" id="send" style="padding: 10px;margin-top:10px;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s6" id="locationview"></div>
			<div class="col s6" id="friendlist"></div>
		</div>


	</div>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDxKGbflLL1e-nFsbvFbbOOGtDkZ26L9Cc&callback=initMap">
		$('#map').slideUp(1000).slideDown(1000);
	</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							/* 			$("div").css("border", "1px solid red"); */
							$("#blog").hide();
							$("#btnblog").click(function() {
								console.log("hello");
								$("#btnblog").hide();
								$("#showblog").hide();
								$("#blog").slideDown(1000);
							});

							//$("#blog").slideDown(1000);

							// click event of the send button
							$("#send")
									.click(
											function() {
												var chat = $("#chat").val();
												if (chat != "") {
													$("#chat").val("");
													console.log(chat);
													$("#list ul")
															.append(
																	'<li style="background-color:white;margin-top:5px; height:40px;text-align:left;border-radius:15px;padding:7px;padding-left:12px;"><a href="/user/messages"><span class="tab">'
																			+ chat
																			+ '</span></a></li>');

													//Code to make bottom appear always..
													var ll = $("#list");
													var height = ll[0].scrollHeight;
													ll.scrollTop(height);
												} else {
													Materialize
															.toast(
																	"It's empty dudee.. :/?",
																	2000);
												}
												//				 $("#msgs").append($("<li>").text());

											});
						});
	</script>
</body>
</html>