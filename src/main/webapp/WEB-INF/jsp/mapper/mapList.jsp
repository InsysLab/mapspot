<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maps</title>
<style type="text/css">@import url(resources/css/main.css);</style>
<style type="text/css">@import url(resources/css/table.css);</style>
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
					<a href="<spring:url value='/login'/>">Sign-In</a> | <a
					href="<spring:url value='/signup'/>">Sign-Up</a>
				</td>
			</sec:authorize>

		</div>
		<div style="clear: both"></div>
	</div><br/>
	Map List
	<div id="content-container">
		<table style="min-width:500px;">
			<thead>
				<tr><th>Description</th><th>Published</th><th>Blocked</th><th>URL</th><th></th></tr>
			</thead>
			<c:forEach var="map" items="${maps}">
				<tr>
					<td><a href="map-edit/${map.mapId}">${map.description}</a></td>
					<td>
						<c:if test="${map.isPublished == false}">No &nbsp;&nbsp;
							<button onclick="window.location='publish-map/${map.mapId}'">Publish</button>
						</c:if>
						<c:if test="${map.isPublished == true}">Yes &nbsp;&nbsp;
							<button onclick="window.location='unpublish-map/${map.mapId}'">Un-publish</button>
						</c:if>
					</td>
					<td>
						<c:if test="${map.isBlocked == false}">No &nbsp;&nbsp;
							<button onclick="window.location='block-map/${map.mapId}'">Block</button>
						</c:if>
						<c:if test="${map.isBlocked == true}">Yes &nbsp;&nbsp;
							<button onclick="window.location='unblock-map/${map.mapId}'">Un-block</button>
						</c:if>
					</td>		
					<td>${baseUrl}/view-map/${map.mapId}</td>			
					<td><a href="delete-map/${map.mapId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<div id="footer">&copy; 2015. All rights reserved.</div>		
</body>
</html>