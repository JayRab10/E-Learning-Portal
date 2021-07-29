<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Users List</title>
</head>
<body>
<h2><button type="button" class="btn btn-success">Registered Users with E-Learning Portal   </button>  </h2>
	<table border="1"  class="table table-striped">
		<tr style="background:#90EE90">
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
				
				<td><a href="<c:url value='/delete-user/${user.userID }'/>" style="color:white" ><button type="button" class="btn btn-success">Delete</button></a>
					| <a href="<c:url value='/update-user/${user.userID }'/>" style="color:white" ><button type="button" class="btn btn-success">Update</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addUser" style="color:white"><button type="button" class="btn btn-success"> + Add New User</button></a>
</body>
</html>