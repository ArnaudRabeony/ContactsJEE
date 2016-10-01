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
<jsp:include page="header.jsp"/>

		<div class="col-md-4 col-sm-4">
			<h3>Créer contact :</h3> <br>
			<form class="form-group form-group-sm col-sm-11 col-md-11" method="post" action="Create">
				<input class="form-control inputPadding" type="text" name="nom" id="nom" value="${errorNom}" placeholder="Nom..."><br>
				<input class="form-control inputPadding" type="text" name="prenom" id="prenom" value="${errorPrenom}" placeholder="Prénom..."><br>
				<input class="form-control inputPadding" type="text" name="email" id="email" value="${errorEmail}" placeholder="Adresse mail..."><br>
				<button id="newAddress" class="btn btn-info" type="button"><i class="material-icons">add</i>Adresse</button><br>
				<button id="newPhone" class="btn btn-info" type="button"><i class="material-icons">add</i>Téléphone</button><br>
				<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
				<button class="btn btn-primary" type="submit">Créer contact</button>
		</div>
		
		<div class="form-group form-group-sm col-md-4 col-sm-4">
			<div id="addressForm" class="col-md-10 col-sm-10">
				<input class="form-control form-control-sm inputPadding" type="text" name="numeroAdresse" id="numeroAdresse" placeholder="N°...">
				<input class="form-control inputPadding" type="text" name="rue" id="rue" placeholder="Rue...">
				<input class="form-control inputPadding" type="text" name="ville" id="ville" placeholder="Ville...">
				<input class="form-control inputPadding" type="text" name="codep" id="codep" placeholder="Code Postal...">
				<input class="form-control inputPadding" type="text" name="pays" id="pays" placeholder="Pays...">
			</div> 
		</div>
		
		<div class="form-group form-group-sm col-md-4 col-sm-4">
			<div id="phoneForm" class="col-md-10 col-sm-10">
				<input class="form-control inputPadding col-md-9 col-sm-9" type="text" name="numeroTel" id="numeroTel" placeholder="N° téléphone...">
					<select class="form-control col-md-3 col-md-3" name="type" id="type">
						<option value="pro" selected>Professionnel</option>
						<option value="perso">Personnel</option>
					</select><br>
			</div> 
		</div>
	</form>
<jsp:include page="footer.jsp"/>
<script>
	$(function()
	{
		$("#newAddress").click(function()
		{	
			$(this).attr("disabled",true);
			$("#addressForm").show();
		});
		
		$("#newPhone").click(function()
		{
			$(this).attr("disabled",true);
			$("#phoneForm").show();
		});
	});
</script>
</html>