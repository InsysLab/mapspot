<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Index page</title>
<style type="text/css">
@import url(../resources/css/main.css);
</style>
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
								<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
			</div>
			<div style="clear: both"></div>
		</div>	
		<div id="home-container">
			<h2>Admin default page</h2>
			<ul>
				<spring:url value="/admin/" var="users"></spring:url>
				<spring:url value="/admin/maps" var="maps"></spring:url>
				<li><a href="${users }users">View  Users</a></li>
				<li><a href="${users }adminusers">View Admin Users</a></li>
				<li><a href="${maps }">View Maps</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">&copy; 2015. All rights reserved.</div>
</body>
</html>