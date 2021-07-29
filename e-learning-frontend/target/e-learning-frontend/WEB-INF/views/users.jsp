<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="user" items="${list }">
			<tr>
				<td>${user.userID }</td>
				<td>${user.userName }</td>
				<td>${user.email }</td>
				<td>${user.address }</td>
				<td><a href="<c:url value='/delete-user/${user.userID }'/>">Delete</a>
					| <a href="<c:url value='/update-user/${user.userID }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addUser">Add New User</a>
</body>
</html>