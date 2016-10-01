<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
<jsp:include page="header.jsp" />

	<h3>Création<br><br> <small>Veuillez cliquer sur le lien correspondant à l'action que vous voulez effectuer</small></h3>
	<div id="createList" class="row">
		<div class="list-group col-sm-6 col-md-6">
		  <a href="createContact.jsp" class="list-group-item">
		    <h4 class="list-group-item-heading">Contact</h4>
		    <p class="list-group-item-text">Nouveau contact auquel vous pourrez joindre une adresse ainsi qu'un numéro de téléphone</p>
		  </a>
		  <a href="createAddress.jsp" class="list-group-item">
		    <h4 class="list-group-item-heading">Adresse</h4>
		    <p class="list-group-item-text">Nouvelle adresse que vous pourrez joindre à un contact existant</p>
		  </a>
		  <a href="createPhoneNumber.jsp" class="list-group-item">
		    <h4 class="list-group-item-heading">Numéro de téléphone</h4>
		    <p class="list-group-item-text">Nouveau numéro que vous vous pourrez joindre à un contact existant</p>
		  </a>
		  <a href="createGroup.jsp" class="list-group-item">
		    <h4 class="list-group-item-heading">Groupe</h4>
		    <p class="list-group-item-text">Nouveau groupe qui pourra contenir une liste de contacts</p>
		  </a>
		</div>
	</div>
<jsp:include page="footer.jsp" />
<script>
$(function()
{
	$('.list-group-item').mouseover(function()
	{
		$(this).parent().find(".active").removeClass("active");
		$(this).addClass("active");
	});
	
});
</script>
</html>