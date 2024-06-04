<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search users, delete user and update user details</title>
</head>
<body>
 	<form action="getuser">
 		<input type="number" name="id" placeholder="Enter User ID">
 		<input type="submit" value="Search">
 	</form>
 	<h3>${userDto}</h3>
 	
 	
 	<%if (request.getAttribute("userDto") != null) { %>
 	<h1>Update</h1>
 	<form action="updateUser">
 		<input type="text" value="${userDto.getId()}" disabled="disabled">
 		<input type="hidden" name="id" value="${userDto.getId()}" placeholder="Enter User ID"><br><br>
		Name <input type="text" name="name" value="${userDto.getName()}"><br><br>
		Email <input type="email" name="email" value="${userDto.getEmail()}"><br><br>
		Password <input type="password" name="pass" value="${userDto.getPass()}"><br><br>
		<input type="submit" value="sign in">
	</form>
	<h1>Delete</h1>
	<form action="deleteUser">
 		<input type="text" value="${userDto.getId()}" disabled="disabled">
 		<input type="hidden" name="id" value="${userDto.getId()}" placeholder="Enter User ID"><br><br>
		<input type="submit" value="Delete">
	</form>
	
	<%} %>
 	
</body>
</html>