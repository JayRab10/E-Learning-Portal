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
	<h2>Contact Registration</h2>
	<hr>
	<form:form action="registerContact" method="POST" modelAttribute="contact">
		<pre>
        Contact Id    : <form:input path="contactID" /><br>
        User Id       : <form:input path="userID" /><br>
        User Name     : <form:input path="userName"/><br>
        Email         : <form:input path="email"/><br>
        Phone         : <form:input path="phone"/><br>
        Message       : <form:input path="message"/><br>
                    <input type="submit" value="RegisterContact" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>