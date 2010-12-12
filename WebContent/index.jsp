<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cluster Management System</title>

		<style>
			html {
				overflow-y: scroll;
			}
			body {
			    margin: 0px;
			    padding: 0px;
			    font-family: "Arial", "Helvetica", "Verdana", "sans-serif";
				font-size: 10px;
			}
			
			body {
			    margin: 0px;
			    padding: 0px;
			}
			
			div#content {
			    position: absolute;
			    left: 50%;
			    width: 600px;
			    margin-top: 50px;
			    margin-left: -316px;
			    padding: 15px;
			}
			
			label, input { display:block; }
			input.text { margin-bottom:12px; width:95%; padding: .4em; }
			fieldset { padding:0; border:0; margin-top:25px; }
			h1 { font-size: 1.2em; margin: .6em 0; }
			div#users-contain { width: 350px; margin: 20px 0; }
			div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
			div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
			.ui-dialog .ui-state-error { padding: .3em; }
			.validateTips { border: 1px solid transparent; padding: 0.3em; }
			
		</style>
		
		<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.6.custom.css" rel="stylesheet" />	
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.6.custom.min.js"></script>
		<script type="text/javascript">
		
		$(function(){
			$( "#tabs" ).tabs();	
		})
		
		$(document).ready(function() {
			$.ajax({
				type: 		"get",
				url: 		"/CMS/AuthenticationController",
				success: function(data) {
				   $("#auth").html(data);
				}
			});
		})
		</script>
</head>
	
<body onload="" > 
<div id="content" align="center">
	<div id="auth"></div>
	
	<div id="tabs" >
		<img src="header2.png"/>
		<ul>
			<li><a href="#tabs-1">Home</a></li>
			<li><a href="#tabs-2">Booking</a></li>
			<li><a href="machineManagement.jsp">Machine Management</a></li>
		</ul>
		
		<div id="tabs-1">
			<p></p>
		</div>
		
		<div id="tabs-2">
			<p></p>
		</div>
		
		<div id="tabs-3">
			<p></p>
			<p></p>
		</div>
	</div>
</div>
</body>
</html>