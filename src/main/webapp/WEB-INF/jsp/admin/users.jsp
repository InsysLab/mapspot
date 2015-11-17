<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<spring:url value="/resources/css/admin.css" var="abc"></spring:url>
<link rel="stylesheet" type="text/css" href="${abc}"></link>
<style type="text/css">@import url(../resources/css/main.css);</style>
</head>
<body>
	<div id="page-container">
		<div id="header">
			<div style="float: left">
				<h2>MapSpot</h2>
			</div>

			<div class="login-box">
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<sec:authentication property="principal.username" /> | 
					<a href="../">Home</a> |
					<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
			</div>
			<div style="clear: both"></div>
		</div>	
		<div id="home-container">
			<h2>Users List</h2>
			<a href="createUser">Create a User</a>
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
						<td>${user.email}</td>
						<td>${user.enabled}</td>
						<td><a href="user/edit/${user.personId}">Edit</a></td>
						<td>
							<form action="user/delete/${user.personId}" method="post">
								<input type="submit" onclick="confirm('Are you sure?')"
									value="delete" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="footer">&copy; 2015. All rights reserved.</div>			
</body>
</html>