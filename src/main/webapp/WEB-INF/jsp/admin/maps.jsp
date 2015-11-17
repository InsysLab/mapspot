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
	<a href="../">Admin Home</a>
	<spring:url value="/mapblock/" var="mapUrl"></spring:url>
	<table>
		<tr class="header">
			<th>Map Description</th>
			<th>Blocked</th>
			<th>Public</th>
			<th></th>
		</tr>
		<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

		<c:forEach var="map" items="${maps}">
			<tr>
				<td>${map.description}</td>
				<td>${map.isBlocked}</td>
				<td>${map.isPublished}</td>
				<td><form:form action="${mapUrl}${map.mapId}">
						<c:set var="val" value="${map.isBlocked}" />
						<c:choose>
							<c:when test="${val == 'true'}">
								<input type="submit" value="Unblock"
									onclick="confirm('Are you sure?')" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="Block"
									onclick="confirm('Are you sure?')" />
							</c:otherwise>
						</c:choose>


					</form:form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>