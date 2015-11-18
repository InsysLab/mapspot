<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<style type="text/css">
@import url(resources/css/main.css);
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
					Hi <sec:authentication property="principal.username" />! | 
					<a href="map-list">Maps</a> | 
					<a href="create-map">Create</a> | 
					<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<td>
						<a href="<spring:url value='/login'/>"><spring:message code="header.signin"/></a> | <a
						href="<spring:url value='/signup'/>"><spring:message code="header.signup"/></a>
					</td>
				</sec:authorize>

			</div>
			<div style="clear: both"></div>
		</div>
		<h3>${success}</h3>
		<div id="home-container">
			<div style="float: left">
				<img src="<spring:url value="/resources/images/samplemap/sample1.png"/>" />
				<p><spring:message code="home.message1"/></p>
			</div>
			<div style="float: right">
				<img src="<spring:url value="/resources/images/samplemap/sample2.png"/>" />
				<p><spring:message code="home.message2"/></p>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="footer">
		Language : <a href="?language=en">English</a>|<a href="?language=fil_PH">Tagalog</a> | 
		<a href="?language=nep_NP">Nepali</a>
		&copy; 2015. All rights reserved.
	</div>
</body>
</html>