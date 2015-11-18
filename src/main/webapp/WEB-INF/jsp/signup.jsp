<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div id="content-container" style="margin-left:100px;">
	    	<h2><spring:message code="user.signup"/></h2>
	    	<form:form modelAttribute="signup" action="${urlMap}" method="post">
	    		<table>
                	<tr>
                		<td><form:label path="username">User Name</form:label></td>
	    				<td><form:input path="username" name="username" type="text"/></td>
	    				<td><form:errors path="username" cssStyle="color : red;" /></td>
	    			</tr>
	    			<tr>
	    				<td><form:label path="password">Password</form:label></td>
	    				<td><form:input path="password" name='password'  type="password" value="" /></td>
	    				<td><form:errors path="password" cssStyle="color : red;" /></td>
	    			</tr>
	    			
					<tr>
						<td><form:label path="name">Full Name</form:label></td>
	    		    	<td><form:input path="name" name="name" type="text" /></td>
	    		    	<td><form:errors path="name" cssStyle="color : red;" /></td>
	    			</tr>
					<tr>
						<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
	    				<td><form:input path="dateOfBirth" name="dateOfBirth" type="text" /> (mm/dd/yyyy)</td>
	    				<td><form:errors path="dateOfBirth" cssStyle="color : red;" /></td>
	    			</tr> 
					<tr>
						<td><form:label path="email">Email</form:label></td>
	    				<td><form:input path="email" name="email" type="text" /></td>
	    				<td><form:errors path="email" cssStyle="color : red;" /></td>
	    			</tr>
	    		</table><br/>
	    		
	    		<input  type="submit" value="Signup" />
	      	</form:form>
		</div>
	</div>
	<div id="footer">
		Language : <a href="?language=en">English</a>|<a href="?language=fil_PH">Tagalog</a>
		&copy; 2015. All rights reserved.
	</div>
</body>
</html>