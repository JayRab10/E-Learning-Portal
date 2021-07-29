<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Feedback Form</title>
</head>
<body>
	<h2>Update Feedback</h2>
	<hr>
	<c:url var="updateUrl" value="/update-feedback"></c:url>
	<form:form action="${updateUrl }" method="post" modelAttribute="feedback">
		<pre>
        Feedback Id    : <form:input path="feedbackID" /><br>
        User Id        : <form:input path="userID" /><br>
        User Name      : <form:input path="userName"/><br>
        Email          : <form:input path="email"/><br>
        Message        : <form:input path="feedbackMessage"/><br>
			<br>
                    <input type="submit" value="Update Feedback" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>