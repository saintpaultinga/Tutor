<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casts</title>
</head>
<body>
	<h1>Cast Information</h1>
	<table>
	<c:forEach var="user" items="${user}">
	<tr>
		<td>${user.id}</td>
		<td>${user.email}</td>
		<td>${user.firstname}</td>
		<td>${user.lastname}</td>
	</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>