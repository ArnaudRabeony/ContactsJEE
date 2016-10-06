<%@page import="Models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ServiceEntities.ContactService"%>
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
<% 
// if(request.getParameter("selectedId")!=null)
// 	idAddress = Integer.valueOf(request.getParameter("selectedId"));

// boolean create = idAddress==0;
// String actionName = create ? "Créer une " : "Modifier une ";
// String formAction = create ? "CreateAddress" : "UpdateAddress";
%>
		<div class="col-md-4 col-sm-4">
			<h3>Créer une adresse :</h3> <br>
			
		<% 
			ContactService cs = new ContactService();
			ArrayList<Contact> contacts = cs.getContacts();
			Boolean empty = contacts.isEmpty();
		%>	
		<form class="form-group form-group-sm col-sm-11 col-md-11" method="post" action="CreateAddress">
			<div class="form-group form-group-sm">
					<label for="contactId" >Selectionnez le contact associé</label>
					<select class="form-control col-md-3 col-md-3" name="contactId" id="contactId">
					<%
						boolean firstContact = true;
						for(Contact c : contacts)
						{
							if(firstContact)
							{
								out.write("<option value='"+c.getId()+"' selected>"+c.getPrenom()+" "+c.getNom()+"</option>");
								firstContact = false;
							}
							else
								out.write("<option value='"+c.getId()+"'>"+c.getPrenom()+" "+c.getNom()+"</option>");
						}
					%>
					</select><br>
					<input class="form-control form-control-sm inputPadding" type="text" name="numeroAdresse" id="numeroAdresse" value="${errorNumero}" placeholder="N°...">
					<input class="form-control inputPadding" type="text" name="rue" id="rue" value="${errorRue}" placeholder="Rue...">
					<input class="form-control inputPadding" type="text" name="ville" id="ville" value="${errorVille}" placeholder="Ville...">
					<input class="form-control inputPadding" type="text" name="codep" id="codep" value="${errorCodePostal}" placeholder="Code Postal...">
					<input class="form-control inputPadding" type="text" name="pays" id="pays" value="${errorPays}" placeholder="Pays...">
					<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
					<button class="btn btn-primary" type="submit">Créer l'adresse</button>
				</div> 
			</div>
			
		</form>
<jsp:include page="footer.jsp"/>
</html>