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
	<h1>Chercher contact :</h1> <br>
	<div class="row">
		<form class="form-inline col-sm-3 col-md-3" method="get" action="Search">
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
			<button class="btn btn-primary" type="submit">Chercher le contact</button>
		</form>
	</div>
	
	<div class="row col-md-8 col-sm-8">
		<table class="table table-hover col-md-4 col-sm-4" style="display:none">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Mail</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td id="resultId">${idResult}</td>
					<td id="resultNom">${nomResult}</td>
					<td>${prenomResult}</td>
					<td>${emailResult}</td>
					<td><a class="btn btn-sm btn-default" id="edit">Modifier</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>