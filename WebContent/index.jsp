<%@page import="Models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAOs.ContactDAO"%>
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
<div class="row">
	<span style="float:right"><h4><small>Bonjour, ${sessionScope.nom}</small></h4><button id="logout" class="btn btn-sm btn-default">Deconnexion</button></span>
		<h2>Gestion des contacts : </h2><br>
		<div class="list-group col-md-3 col-sm-6">
			<a class="list-group-item" href="createContact.jsp">Ajouter un contact</a>
			<a class="list-group-item" href="deleteContact.jsp">Supprimer un contact</a>
			<a class="list-group-item" href="searchContact.jsp">Rechercher un contact</a>
			<a class="list-group-item" href="updateContact.jsp">Modifier un contact</a>		
		</div>
</div>

<hr>

<%
	ContactDAO cd = new ContactDAO();
	ArrayList<Contact> contacts = cd.getContacts();
	Boolean empty = contacts.isEmpty();
%>

<div class="row col-md-4 col-sm-4">
	<h3><small>Liste des contacts </small></h3>
	<table id="contacts" class="table table-hover col-md-4 col-sm-4" style="display:<%= empty ? "none" : "block" %>">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th></th>
		</thead>
		<tbody>
			<%
				String line = "";
				for(Contact c : contacts)
					line+="<tr><td id='rowId'>"+c.getId()+"</td><td>"+c.getNom()+"</td><td>"+c.getPrenom()+"</td><td>"+c.getEmail()+"</td><td><a id='deleteRow' class='btn btn-sm btn-danger'>Supprimer</a></td></tr>";
				
				out.write(line);
			%>
		</tbody>
	</table>
	<h4 style="display:<%= empty ? "block" : "none" %>">Vous n'avez aucun contact</h4>	
</div>

	</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</html>