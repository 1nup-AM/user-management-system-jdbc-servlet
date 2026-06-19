<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List"  %>
 <%@ page import="com.servletproject.model.UserModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
<a href="add-user.jsp">Add User</a><br><br>
<a href="logout">Logout</a>
<h2>All Users</h2>
	<%List<UserModel> users = (List<UserModel>)request.getAttribute("users"); %>
	<form action="search" method="get">
		<div style="display: flex;">
		<input type="text" name="searchString" placeholder="Search email or name"/><br>
		<button type="submit">Search</button>
		</div>
	</form>
	<a href="users">Show all users</a>
<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Age</th>
    <th>Action</th>
</tr>
<%for(UserModel user : users){ %>
<tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td><%= user.getAge() %></td>
    <td>
    	<a href="delete?id=<%= user.getId() %>">Delete</a>
    	|
    	<a href="edit?id=<%= user.getId() %>">Edit</a>
    </td>
</tr>

<%} %>
</table>
</body>
</html>