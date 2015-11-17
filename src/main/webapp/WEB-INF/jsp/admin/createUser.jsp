<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add user</title>
<style>
.errorblock {
	color: red;
}
</style>
<style type="text/css">@import url(../resources/css/main.css);</style>
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
					<a href="../">Home</a> |
					<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
			</div>
			<div style="clear: both"></div>
		</div>	
		<div id="home-container">
			<h2>Add a user</h2>
			<form:form commandName="User" action="../admin/createUser"
				method="post">
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<table>
					<tr>
						<td>Name</td>
						<td><form:input type="text" path="name" /></td>
						<td><form:errors path="name" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><form:input type="text" path="username" /></td>
						<td><form:errors path="username" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input type="password" path="password" /></td>
						<td><form:errors path="password" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input type="text" path="email" /></td>
						<td><form:errors path="email" cssClass="errorblock"></form:errors></td>
					</tr>			
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div id="footer">&copy; 2015. All rights reserved.</div>
</body>
</html>