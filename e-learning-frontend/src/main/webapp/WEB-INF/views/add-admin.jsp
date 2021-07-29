<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
</head>
<body>
	<h2>Admin Registration</h2>
	<hr>
	<form:form action="admin-register" method="POST" modelAttribute="admin">
		<pre>
	Admin Id       : <form:input path="adminID"/><br>
        Admin Name     : <form:input path="adminName"/><br>
        Password       : <form:password path="password" /><br>
        Email          : <form:input path="email" /><br>
        
                    <input type="submit" value="Register" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>