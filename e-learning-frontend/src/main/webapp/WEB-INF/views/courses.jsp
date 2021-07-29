<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th> Name</th>
			<th> Description</th>
			<th>Fees </th>
			<th>Resource</th>
		</tr>

		<c:forEach var="course" items="${list }">
			<tr>
				<td>${course.courseId }</td>
				<td>${course.courseName }</td>
				<td>${course.courseDescription }</td>
				<td>${course.courseResource }</td>
				<td><a href="<c:url value='/delete-course/${course.courseId }'/>">Delete</a>
					| <a href="<c:url value='/update-course/${course.courseId }'/>">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addCourse">Add New Course</a>
</body>
</html>