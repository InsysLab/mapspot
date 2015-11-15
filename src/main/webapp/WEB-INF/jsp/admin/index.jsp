<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Index page</title>
</head>
<body>
	<h1>Admin default page</h1>
	<ul>
		<spring:url value="/admin/users" var="users"></spring:url>
		<spring:url value="/admin/maps" var="maps"></spring:url>
		<li><a href="${users }">View Users</a></li>
		<li><a href="${maps }">View Maps</a></li>
	</ul>
</body>
</html>