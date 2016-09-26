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
<%@ page errorPage="error.jsp" %>
<a href="index.jsp">Retour à l'accueil</a>
	<h1>Modifier contact :</h1> <br>
	
	<% String id = request.getParameter("id"); %>
	<div class="row">
	<form class="form-group col-sm-3 col-md-3" method="post" action="Update">
	<%
		if(id == null)
		{
			%>	
			<label for="id">ID :</label><input class="form-control" type="number" name="id" id="id" value="errorId"><br>
			<%
		}
		else
		{
			%>	
			<label for="idDisabled">ID :</label><input class="form-control" type="number" name="idDisabled" id="idDisabled" value="<%= id %>" disabled><br>
			<input type="hidden" name="id" id="id" value="<%= id %>"><br>
			<%
		}
	%>	
		<label for="nom">Nouveau nom :</label><input class="form-control" type="text" name="nom" id="nom" value="${errorNom}"><br>
		<label for="prenom">Nouveau prenom :</label><input class="form-control" type="text" name="prenom" id="prenom" value="${errorPrenom}"><br>
		<label for="email">Nouvel email :</label><input class="form-control" type="text" name="email" id="email" value="${errorEmail}"><br>
		<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
		<button class="btn btn-primary" type="submit">Modifier le contact</button>
	</form>
	</div>
	
	<div class="row">
		<a id="deleteButton" class="btn btn-sm btn-danger" style="margin-left:10px;">Supprimer</a>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>