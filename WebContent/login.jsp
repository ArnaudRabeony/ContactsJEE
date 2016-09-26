<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<body style="padding: 50px 30px 50px 80px;">

	<h1>Application de gestion de contacts</h1>
	
	<h3>Connexion : </h3><br>
	
	<form class="form-group col-sm-4 col-md-4 col-md-offset-4" method="get" action="Login">
		<label for="name">Nom : </label><input class="form-control" type="text" name="nom" id="nom" value="${errorNom}"><br>
		<label for="password">Password : </label><input class="form-control" type="password" name="password" id="password"><br>
  		<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
  		<button type="submit" class="btn btn-primary">Se connecter</button>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>