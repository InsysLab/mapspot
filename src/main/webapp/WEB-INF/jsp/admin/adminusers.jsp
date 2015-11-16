<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<spring:url value="/resources/css/admin.css" var="abc"></spring:url>
<link rel="stylesheet" type="text/css" href="${abc}"></link>
</head>
<body>
	<h1>Admin Users List</h1>
	<a href="createAdminUser">Create a User</a>
	<table>
	<tr class="header">
			<th>Name</th>
			<th>Username</th>
			<th>Email</th>
			<th>Enabled</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name }</td>
				<td>${user.username}</td>
				<td>${user.enabled}</td>
				<td>${user.email}</td>				
				<td><a href="adminuser/edit/${user.personId}">Edit</a></td>
				<td>
					<form action="adminuser/delete/${user.personId}" method="post">
						<input type="submit" onclick="confirm('Are you sure?')"
							value="delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>