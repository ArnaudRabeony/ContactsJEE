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
			<h3>Créer un numéro de téléphone :</h3> <br>
			
		<% 
			ContactService cs = new ContactService();
			ArrayList<Contact> contacts = cs.getContacts();
			Boolean empty = contacts.isEmpty();
		%>	
		<form class="form-group form-group-sm col-sm-11 col-md-11" method="post" action="CreatePhone">
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
					<input class="form-control inputPadding col-md-9 col-sm-9" type="text" value="${errorPhoneType}" name="numeroTel" id="numeroTel" placeholder="N° téléphone...">
					<select class="form-control col-md-3 col-md-3" value="${errorPhone}" name="type" id="type">
						<option value="pro" selected>Professionnel</option>
						<option value="perso">Personnel</option>
					</select><br>
					<span style="color:red;" id="errorMessage" data-type="${errorType}"><i>${errorMessage}</i></span><br>
					<button class="btn btn-primary" type="submit">Créer le numéro</button>
				</div> 
			</div>
			
		</form>
<jsp:include page="footer.jsp"/>
</html>