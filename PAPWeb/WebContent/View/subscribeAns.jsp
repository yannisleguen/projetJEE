<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	Exception erreurDeCreationCompte = (Exception) request.getAttribute("erreur");	
	String nomClient = request.getParameter("name");
	String emailClient = request.getParameter("email");
	String passClient = request.getParameter("pass");
	String villeClient = request.getParameter("city");
%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> R�sultat de demande de cr�ation de compte </h1>
	<h2>
		<% if (erreurDeCreationCompte == null) { %>
			<span style="color: red;"> Compte cr�� pour <%= nomClient %> </span> !
		<%}	else { %>
			Le compte <span style="color: red;">  n'a pas �t� cr�� !!! </span>
		<%} %>
	</h2>
</body>
</html>