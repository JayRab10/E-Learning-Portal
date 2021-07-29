<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Form</title>
</head>
<body>
	<h2>Update User</h2>
	<hr>
	<c:url var="updateUrl" value="/update-user"></c:url>
	<form:form action="${updateUrl }" method="post" modelAttribute="user">
		<pre>
        Id        : <form:input path="id" />
			<br>
        Username  : <form:input path="username" />
			<br>
        Password  : <form:password path="password" />
			<br>
        Email     : <form:input path="email" />
			<br>
        Address   : <form:input path="address" />
			<br>
                    <input type="submit" value="Update User" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>