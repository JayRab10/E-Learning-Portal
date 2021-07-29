<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Course Registration</h2>
	<hr>
	<form:form action="registerCourse" method="POST" modelAttribute="course">
		<pre>
        Course Id    : <form:input path="courseId" /><br>
        Course Name  : <form:input path="courseName"/><br>
        Description  : <form:input path="courseDescription"/><br>
        Fees         : <form:input path="courseFees"/><br>
        Resource     : <form:input path="courseResource"/><br>
                    <input type="submit" value="RegisterCourse" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>