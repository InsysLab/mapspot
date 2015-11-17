<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mapper</title>
<style type="text/css">@import url(resources/css/main.css);</style>
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
		New Map
		<div id="home-container">
			Please upload an image (only accepts PNG format) <br/><br/><br/>
			<form:form method="POST" commandName="upload"	enctype="multipart/form-data">
				Browse:
				<input type="file" name="file" />
				<input type="submit" value="upload" />
				<form:errors path="file" cssStyle="color: #ff0000;" />
			</form:form><br/>
			
			<button onclick="window.location='map-cancel'">Cancel</button>
		</div>
	</div>
	<div id="footer">
		&copy; 2015.  All rights reserved.
	</div>	
</body>
</html>