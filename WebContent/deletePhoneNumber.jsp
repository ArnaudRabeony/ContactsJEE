<%@page import="java.util.ArrayList"%>
<%@page import="ServiceEntities.TelephoneService"%>
<%@page import="Models.Telephone"%>
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
	<h3>Supprimer un numéro de téléphone :</h3> <br>
	
	<% 
		TelephoneService ts = new TelephoneService();
		ArrayList<Telephone> telephones = ts.getTelephones();
	%>	
	<form id="deleteForm" class="form-inline col-sm-4 col-md-4" method="post" action="DeletePhone">
			<div class="form-group form-group-sm">
			<label for="selectedId" >Selectionnez le numéro</label><br>
			<select class="form-control col-md-3 col-md-3" name="selectedId" id="selectedId">
				<option value="-1">Selectionnez un numéro...</option>
			<%
				for(Telephone t : telephones)
					out.write("<option value='"+t.getId()+"'>"+t.getPhoneKind()+" : "+t.getNumber()+"</option>");
			%>
			</select><br>
			</div><br>
			<button class="btn btn-primary" type="submit">Supprimer</button>
	</form>
<jsp:include page="footer.jsp"/>

</html>