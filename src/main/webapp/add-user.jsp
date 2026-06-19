<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
</head>
<body>
<h2>Add User</h2>
<% 
String error = (String)request.getAttribute("error");
if(error != null){
%>
<p style="color:red;"><%= error %></p>
<%} %>
<form action="insert" method="post">
Enter Username: <input type="text" name="name" /><br>
Enter Email: <input type="email" name="email" /><br>
Enter Age: <input type="number" name="age" /><br>
<button type="submit">Save User</button>
</form>
</body>
</html>