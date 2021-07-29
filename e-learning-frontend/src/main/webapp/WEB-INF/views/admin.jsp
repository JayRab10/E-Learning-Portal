<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin List</title>
</head>
<body>
	<table border="1" style="padding:5px;">
		<tr">
			<th style="padding:10px;">ID</th>
			<th>Admin Name</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="admin" items="${list}">	
			<tr">
				<td style="padding:10px;">${admin.adminID }</td>
				<td>${admin.adminName }</td>
				<td>${admin.email }</td>
				<td><a href="<c:url value='/delete-admin/${admin.adminID }'/>">Delete</a>
					| <a href="<c:url value='/update-admin/${admin.adminID }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="">Home</a> &nbsp;&nbsp;&nbsp;
	<a href="addAdmin">Add New Admin</a> &nbsp;&nbsp;&nbsp;
	
</body>
</html>