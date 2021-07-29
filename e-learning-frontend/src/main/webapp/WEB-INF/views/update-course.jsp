<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course Form</title>
</head>
<body>
	<h2>Update Course</h2>
	<hr>
	<c:url var="updateUrl" value="/update-course"></c:url>
	<form:form action="${updateUrl }" method="post" modelAttribute="course">
		<pre>
        Course Id    : <form:input path="courseId" /><br>
        Course Name  : <form:input path="courseName"/><br>
        Description  : <form:input path="courseDescription"/><br>
        Fees  		 : <form:input path="courseFees"/><br>
        Resource     : <form:input path="courseResource"/><br>
			<br>
                    <input type="submit" value="Update Course" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>