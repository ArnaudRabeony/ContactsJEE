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
<a href="index.jsp">Retour à l'accueil</a>
	<h1>Supprimer contact :</h1> <br>
	<form class="form-inline col-sm-3 col-md-3" method="post" action="Delete">
		<div class="form-group">
			<input class="form-control" type="number" name="value" id="value" value="${errorValue}">
			<select class="form-control" name="condition" id="condition">
				<option value="id" selected>Id</option>
				<option value="nom">Nom</option>
				<option value="prenom">Prénom</option>
				<option value="email">Mail</option>
			</select><br><br>
	</div>
		<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
		<button class="btn btn-primary" type="submit">Supprimer contact</button>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>