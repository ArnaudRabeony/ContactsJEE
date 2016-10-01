<%@page import="Models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ServiceEntities.ContactService"%>
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
	<% 
		ContactService cs = new ContactService();
		ArrayList<Contact> contacts = cs.getContacts();
		Boolean empty = contacts.isEmpty();
	%>	
	<h3>Chercher un contact :</h3> <br>
	<form id="searchForm" class="form-inline col-sm-4 col-md-4" method="get" action="Search">
			<div class="form-group form-group-sm">
			<label for="selectedId" >Selectionnez le contact</label><br>
			<select class="form-control col-md-3 col-md-3" name="selectedId" id="selectedId">
				<option value="-1">Selectionnez un contact...</option>
			<%
				for(Contact c : contacts)
					out.write("<option value='"+c.getId()+"'>"+c.getPrenom()+" "+c.getNom()+"</option>");
			%>
			</select><br>
			</div><br>
<!-- 			<button class="btn btn-primary" type="submit">Chercher</button> -->
	</form>
	
	<div class="col-md-8 col-sm-8">
		<div id="cardResult" class="col-md-4 col-sm-4" style="display:none">
			<!--Card-->
			
		    <div class="card card-cascade narrower" data-contactid="${idResult}">
		
		        <!--Card image-->
		        <div class="view overlay hm-white-slight">
		            <img src="http://mdbootstrap.com/images/regular/city/img%20(11).jpg" class="img-fluid" alt="">
		            <a>
		                <div class="mask"></div>
		            </a>
		        </div>
		        <!--/.Card image-->
		
		        <!--Card content-->
		        <div class="card-block" style="padding:10px;">
		            <h5 class="red-text" id="groupeLabel"></h5>
		            <!--Title-->
		            <h4 class="card-title" id="cardContactName">${prenomResult} ${nomResult}</h4>
		            <!--Text-->
		            <p class="card-text">contact.getTelephone()<br>${emailResult}</p>
		            <a id="editButton" class="btn btn-primary">Éditer</a>
		        </div>
		        <!--/.Card content-->
		
		    </div>
    <!--/.Card-->
		</div>
	</div>
	
	<div id="editableFormCard" class="row">
	<form class="form-group form-group-sm col-sm-3 col-md-3" method="post" action="Update">
		<input class="inputPadding form-control" type="number" name="idContact" id="idContact" value="${idResult}" placeholder="ID..."><br>	
		<input class="inputPadding form-control" type="text" name="nom" id="nom" value="${nomResult}" placeholder="Nouveau nom..."><br>
		<input class="inputPadding form-control" type="text" name="prenom" id="prenom" value="${prenomResult}" placeholder="Nouveau prénom..."><br>
		<input class="inputPadding form-control" type="text" name="email" id="email" value="${emailResult}" placeholder="Nouvelle adresse mail..."><br>
		<span id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>		
		<button class="btn btn-primary" type="submit">Modifier le contact</button>
	</form>
	</div>
<jsp:include page="footer.jsp" />
<script>
$(function()
{
	$('#selectedId').change(function()
	{
		$("#searchForm").submit();
	});
	
	if($('#cardContactName').text().trim()!="" && $('#card').attr("data-contactid")!="")
	{
		$('#searchForm option:selected').attr("selected",false);
		$("#searchForm option").each(function()
		{
			console.log($(this).val());
			if($(this).val() == $('#card').attr("data-contactid"))
				$(this).attr("selected",true);
		});	
		
		$("#cardResult").show();
	}
	
	$("#editButton").click(function()
	{
		$("#cardResult").hide();
		$("#editableFormCard").show();
	});
	
	if($("#editableFormCard #errorMessage").text()!="")
	{
		$("#editableFormCard").show();
	}
});
</script>
</html>