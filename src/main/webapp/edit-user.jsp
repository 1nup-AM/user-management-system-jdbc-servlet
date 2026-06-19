<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.servletproject.model.UserModel" %>
<% UserModel user = (UserModel)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
	<h2>Edit User</h2>
<%
String error = (String) request.getAttribute("error");
if(error != null){
%>
<p style="color:red;"><%= error %></p>
<%}%>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%= user.getId() %>"/>
		Name:<input type="text" name="name" value="<%= user.getName() %>" /><br>
		Email:<input type="text" name="email" value="<%= user.getEmail() %>" /><br>
		Age:<input type="number" name="age" value="<%= user.getAge() %>" /><br>
		<button type="submit">Update User</button>
	</form>
</body>
</html>