<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<a href="<spring:url value='/login'/>">Sign-In</a> | <a
						href="<spring:url value='/signup'/>">Sign-Up</a>
					</td>
				</sec:authorize>

			</div>
			<div style="clear: both"></div>
		</div>
		<div id="content-container" style="margin-left:100px;">
	    	<h2>Please sign up</h2>
	    	<form action="<spring:url value="/signup"></spring:url>" method="post">
	    		<table>
                	<tr>
                		<td><label for="username">User Name</label></td>
	    				<td><input name="username" type="text"/></td>
	    			</tr>
	    			<tr>
	    				<td><label for="password">Password</label></td>
	    				<td><input name='password'  type="password" value="" /></td>
	    			</tr>
					<tr>
						<td><label for="name">Full Name</label></td>
	    		    	<td><input name="name" type="text" /></td>
	    			</tr>
					<tr>
						<td><label for="dateOfBirth">Date of Birth </label></td>
	    				<td><input name="dateOfBirth" type="text" /> (yyyy-mm-dd)</td>
	    			</tr> 
					<tr>
						<td><label for="email">Email</label></td>
	    				<td><input name="email" type="text" /></td>
	    			</tr>
	    		</table><br/>
	    		
	    		<input  type="submit" value="Signup" />
	      	</form>
		</div>
	</div>
	<div id="footer">&copy; 2015. All rights reserved.</div>
</body>
</html>