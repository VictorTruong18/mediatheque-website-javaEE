<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mediatek2020.Mediatheque" %>
<%@page import="mediatek2020.items.Document" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rendre un Document</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="Styles/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="Styles/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="Styles/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Styles/css/util.css">
	<link rel="stylesheet" type="text/css" href="Styles/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<h1>Voici la liste des Documents que vous pouvez rendre : <%= session.getAttribute("username") %></h1>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<% List<Document> docs = (List<Document>)request.getAttribute("docRendre"); %>
				<% for(Document doc : docs){ %>
					<% int iddoc = (int) doc.data()[0]; %>
					<% String titre = (String) doc.data()[1]; %>
					<% String auteur = (String) doc.data()[2]; %>
					<% String couverture = (String) doc.data()[4]; %>
					<% String statut = (String) doc.data()[5]; %>
		
			<form method="post" action="RendreDocument">
				<img src="<%= couverture %>" style="max-height:250px; max-width: 250px;"/>
				<h1>Titre : <%= titre %> par <%= auteur %></h1>
				<h3>TYPE : <%= statut %></h3>
				<div class="wrap-input100 validate-input m-b-16">
						<input class="input100" type="submit" name="rendreDoc" id="rendreDoc" value="Rendre">
						<input type="hidden" name="iddoc" value=<%=iddoc %>>
						<span class="focus-input100"></span>
					</div>
			</form>
			
		<% } %>
			</div>
		</div>
	</div>
		<!--===============================================================================================-->
	<script src="Styles/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="Styles/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="Styles/vendor/bootstrap/js/popper.js"></script>
	<script src="Styles/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="Styles/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="Styles/vendor/daterangepicker/moment.min.js"></script>
	<script src="Styles/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="Styles/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="Styles/js/main.js"></script>
</body>
</html>