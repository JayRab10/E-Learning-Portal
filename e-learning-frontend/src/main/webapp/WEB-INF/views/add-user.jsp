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
	<h2>User Registration</h2>
	<hr>
	<form:form action="register" method="POST" modelAttribute="user">
		<pre>
       
        Username  		: <form:input path="userName"/><br>
        Password		: <form:password path="password" /><br>
        Date Register		: <form:input path="dateRegister" /><br>
        Phone  			: <form:input path="phoneNumber" /><br>
        Email     		: <form:input path="email" /><br>
        Profile photo		: <form:input path="userPhoto" /><br>
        Address   		: <form:input path="address" /><br>
                    		<input type="submit" value="Register" /> <input
				type="reset" value="Reset" />
        </pre>
	</form:form>
</body>
</html>