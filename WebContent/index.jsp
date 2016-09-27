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
  <link rel="stylesheet" href="css/main.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<body>
<div class="row">
	<span id="welcomeSession"><h4><small>Bonjour, ${sessionScope.nom}</small></h4><button id="logout" class="btn btn-sm btn-default">Deconnexion</button></span>
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

<div class="row">
	<div class="col-md-4 col-sm-4">
		<h3><small>Liste des groupes </small></h3><br>
		<input class="form-control" type="text" style="width:45%" id="searchContact"><br>
<!-- 	foreach group g => g.getName() + getNbContactByGroup()	 -->
		 <div class="groupPanel panel-group">
		    <div class="panel panel-default">
		      <div data-toggle="collapse" data-target="#collapse1" class="panel-heading">
		        <h4 class="panel-title">
		          Tous les contacts
		          <span style="float:right"><%= contacts.size() %></span>
		        </h4>
		      </div>
		      <div id="collapse1" class="panel-collapse collapse">
		        <ul class="list-group">
		          <%
						String line = "";
						for(Contact c : contacts)
							line+="<li class='list-group-item contactItem' id='contact"+c.getId()+"'>"+c.getNom()+" "+c.getPrenom()+"<span><img id='displayContact' src='images/Contacts-icon.png' width='30' height='35'></span></li>";
						out.write(line);
					%>
		        </ul>
		      </div>
		    </div>
		  </div>
<!-- 	 -->  
	</div>
	
	<div id="cardContainer" class="col-md-4 col-sm-4" >
		<div class="card">
		  <img src="images/img_avatar.png" alt="Avatar" style="width:100%">
		  <div class="container">
		    <h4><b id="cardContactName"></b></h4> 
		    <p style="font-size:.8em;">contact.getTelephone()<br>contact.getMail()</p> 
		  </div>
		</div>
	</div>
	
</div>
	</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</html>