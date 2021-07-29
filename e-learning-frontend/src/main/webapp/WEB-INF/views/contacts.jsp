<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Contact ID</th>
			<th>User ID</th>
			<th>User Name</th>
			<th> Email</th>
			<th>Phone </th>
			<th>Message</th>
		</tr>

		<c:forEach var="contact" items="${list }">
			<tr>
				<td>${contact.contactID }</td>
				<td>${contact.userID }</td>
				<td>${contact.userName}</td>
				<td>${contact.email }</td>
				<td>${contact.phone }</td>
				<td>${contact.message }</td>
				<td><a href="<c:url value='/delete-contact/${contact.contactID }'/>">Delete</a>
					| <a href="<c:url value='/update-contact/${contact.contactID }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addContact">Add New Contact</a>
</body>
</html>