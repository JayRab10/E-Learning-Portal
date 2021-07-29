<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Admin Form</title>
</head>
<body>
	<h2>Update Admin</h2>
	<hr>
	<c:url var="updateUrl" value="/update-admin"></c:url>
	<form:form action="${updateUrl}" method="post" modelAttribute="admin">
		<pre>
         Id        	: <form:input path="adminID" /><br>
        Admin Name 	: <form:input path="adminName"/><br>
        Password  	: <form:password path="password" /><br>
        Email     	: <form:input path="email" /><br>
                    <input type="submit" value="Update Admin" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>