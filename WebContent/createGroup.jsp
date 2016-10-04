<%@page import="Models.Contact"%>
<%@page import="ServiceEntities.ContactService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
		<div class="col-md-4 col-sm-4">
			<h3>Créer un groupe :</h3> <br>
			
		<% 
			ContactService cs = new ContactService();
			ArrayList<Contact> contacts = cs.getContacts();
			Boolean empty = contacts.isEmpty();
		%>	
		<form class="form-group form-group-sm " method="post" action="CreateGroup">
			<div class="form-group form-group-sm">
					<input class="form-control inputPadding col-md-9 col-sm-9" type="text" value="${errorNomGroupe}" name="nomGroupe" id="nomGroupe" placeholder="Nom...">
					<h4><small>Voulez-vous ajouter des membres à votre groupe ?</small></h4>
					<label class="radio-inline"><input type="radio" name="addMembers" value="y">Oui</label>
					<label class="radio-inline"><input type="radio" name="addMembers" value="n" checked>Non</label><br><br>
					
					<div id="membersSelection">
						<h4><small>Veuillez selecitonner les membres à ajouter ?</small></h4>
						<hr>
						<%
							for(Contact c : contacts)
								out.write("<div class='checkbox'><input name='addToGroup' type='checkbox' value='"+c.getId()+"'>"+c.getPrenom()+" "+c.getNom()+"</label></div>");
						%>
					</div>
					<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
					<button class="btn btn-primary" type="submit">Créer le groupe</button>
				</div> 
			</div>
			
		</form>
<jsp:include page="footer.jsp"/>
<script>
$(function()
{
	$('input[name=addMembers]').change(function()
	{	
		var value=$('input[name=addMembers]:checked').val();
		value == "y" ? $("#membersSelection").show() : $("#membersSelection").hide();
	});
});
</script>
</html>