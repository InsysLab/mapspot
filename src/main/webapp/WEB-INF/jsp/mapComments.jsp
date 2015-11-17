<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maps</title>
<style type="text/css">@import url(../resources/css/main.css);</style>
<style type="text/css">@import url(../resources/css/table.css);</style>
</head>
<body>
<div id="page-container">
	<div id="header">
		<div style="float: left">
			<h2>MapSpot</h2>
		</div>

		<div class="login-box">
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
				<a href="map-list">Maps</a> | 
				<a href="create-map">Create</a> | 
				<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<td>
					<a href="<spring:url value='/login'/>">Sign-In</a> | 
					<a href="<spring:url value='/signup'/>">Sign-Up</a>
				</td>
			</sec:authorize>
		</div>
		<div style="clear: both"></div>
	</div><br/>
	Map Comments <br/>
	${map.description}
	<div id="content-container">
		Add Comment
		<form action="" method="POST">
			<textarea name="comment" rows="5" cols="50"></textarea>
			<br/>
			<input type="submit" value="Submit" />
		</form>
		<table style="min-width:500px;margin-top:25px;">
			<thead>
				<tr><th>Comment</th><th>User</th><th>Date</th></tr>
			</thead>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.commentText}</td>
					<td>${comment.user.name}</td>
					<td><fmt:formatDate type="both" value="${comment.dateCreated}" /></td>
				</tr>
			</c:forEach>		
		</table>
	</div>
</div>
<div id="footer">&copy; 2015. All rights reserved.</div>		
</body>
</html>