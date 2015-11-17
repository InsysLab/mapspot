<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MapSpot</title>
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
				<a href="../map-list">Maps</a> | 
				<a href="../create-map">Create</a> | 
				<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<td>
					<a href="<spring:url value='/login'/>">Sign-In</a> | <a
					href="<spring:url value='/signup'/>">Sign-Up</a>
				</td>
			</sec:authorize>

		</div>
		<div style="clear: both"></div>
	</div><br/>
	Share Map: ${map.description}
	<div id="content-container">
		<form action="" method="POST">
			<table style="min-width:500px;">
				<c:forEach var="user" items="${users}">
					<c:if test="${cUser.personId != user.personId}">
					<tr>
						<td>
							<input type="checkbox" name="users" value="${user.personId}" /> 
							${user.name}
						</td>
					</tr>
					</c:if>
				</c:forEach>
			</table><br/>
			<input type="submit" value="Submit" />
		</form>
	</div>
</div>
<div id="footer">&copy; 2015. All rights reserved.</div>		
</body>
</html>