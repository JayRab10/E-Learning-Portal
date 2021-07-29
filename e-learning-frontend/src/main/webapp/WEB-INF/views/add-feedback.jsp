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
	<h2>Feedback Registration</h2>
	<hr>
	<form:form action="registerFeedback" method="POST" modelAttribute="feedback">
		<pre>
        Feedback Id    : <form:input path="feedbackID" /><br>
        User Id        : <form:input path="userID" /><br>
        User Name      : <form:input path="userName"/><br>
        Email          : <form:input path="email"/><br>
        Message        : <form:input path="feedbackMessage"/><br>

                    <input type="submit" value="RegisterFeedback" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>