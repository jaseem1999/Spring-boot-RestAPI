<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login</h2>

<form action="userLogin">
	Email : <input type="email" name="email"><br><br>
	Password : <input type="password" name="pass"><br><br>
	<input type="submit" value="Login">
</form>
<a href="signup.jsp">Sign up</a>
<h2>${loginFialed}</h2>
</body>
</html>