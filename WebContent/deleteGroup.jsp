<%@page import="java.util.ArrayList"%>
<%@page import="ServiceEntities.GroupeService"%>
<%@page import="Models.Groupe"%>
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
	<h3>Supprimer un groupe :</h3> <br>
	
	<% 
		GroupeService gs = new GroupeService();
		ArrayList<Groupe> groupes = gs.getGroups();
	%>	
	<form id="deleteForm" class="form-inline col-sm-4 col-md-4" method="post" action="DeleteGroup">
			<div class="form-group form-group-sm">
			<label for="selectedId" >Selectionnez le groupe</label><br>
			<select class="form-control col-md-3 col-md-3" name="selectedId" id="selectedId">
				<option value="-1">Selectionnez un groupe...</option>
			<%
				for(Groupe g : groupes)
					out.write("<option value='"+g.getId()+"'>"+g.getNom()+" - "+gs.getContacts(g.getId()).size()+" contact(s)</option>");
			%>
			</select><br>
			</div><br>
			<button id="deleteBtn" class="btn btn-primary" type="submit" disabled>Supprimer</button>
	</form>
<jsp:include page="footer.jsp"/>
<script>
$(function()
{
	$("#selectedId").change(function()
	{
		var value =$(this).val();
		if(value==-1)
			$("#deleteBtn").attr("disabled",true);
		else if(value!=-1)
			$("#deleteBtn").attr("disabled",false);
	});

});
</script>
</html>