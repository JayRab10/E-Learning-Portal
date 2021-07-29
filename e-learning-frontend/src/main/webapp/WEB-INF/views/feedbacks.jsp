<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Feedback ID</th>
			<th>User ID</th>
			<th>User Name</th>
			<th> Email</th>
			<th>Message </th>
		</tr>

		<c:forEach var="feedback" items="${list }">
			<tr>
				<td>${feedback.feedbackID }</td>
				<td>${feedback.userID}</td>
				<td>${feedback.userName }</td>
				<td>${feedback.email }</td>
				<td>${feedback.feedbackMessage }</td>
				<td><a href="<c:url value='/delete-feedback/${feedback.feedbackID }'/>">Delete</a>
					| <a href="<c:url value='/update-feedback/${feedback.feedbackID }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addFeedback">Add New Feedback</a>
</body>
</html>