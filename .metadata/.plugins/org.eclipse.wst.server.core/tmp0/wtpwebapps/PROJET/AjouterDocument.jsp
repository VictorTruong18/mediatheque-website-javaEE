<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajouter un document</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="Styles/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="Styles/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="Styles/css/util.css">
<link rel="stylesheet" type="text/css" href="Styles/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form class="login100-form validate-form flex-sb flex-w"
					method="post" action="NouveauDocument">
					<span class="login100-form-title p-b-51"> Bienvenue  <%=session.getAttribute("username")  %> </span>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Titre du document non-renseigné">
						<input class="input100" type="text" name="titre" id="titre"
							placeholder="Titre"> <span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Nom de l'auteur non-renseigné">
						<input class="input100" type="text" name="auteur" id="auteur"
							placeholder="Auteur"> <span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Couverture non-renseignée">
						<input class="input100" type="text" name="couverture" id="couverture"
							placeholder="Couverture"> <span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Type non-renseigné">
						<select name="statut">
							<option value="1">DVD</option>
							<option value="2">Livre</option>
						</select>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							Ajouter un document
						</button>
					</div>

				</form>
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