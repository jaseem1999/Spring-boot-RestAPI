<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%
String user = (String) session.getAttribute("user");
%>
</head>
<body>
<h1>Hello <%=user %></h1>
</body>
</html>