<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Maps</title>
<spring:url value="/resources/css/admin.css" var="abc"></spring:url>
<link rel="stylesheet" type="text/css" href="${abc}"></link>
</head>
<body>
	<h1>List of Maps</h1>
	<spring:url value="/mapblock/" var="mapUrl"></spring:url>
	<table>
		<tr class="header">
			<td>Map Description</td>
			<td>Blocked</td>
			<td>Public</td>
		</tr>
		<c:forEach var="map" items="${maps}">
			<tr>
				<td>${map.description}</td>
				<td>${map.isBlocked}</td>
				<td>${map.isPublic}</td>
				<td><form:form action="${mapUrl}${map.id}">
						<input type="submit" value="Block"
							onclick="confirm('Are you sure?')" />
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>