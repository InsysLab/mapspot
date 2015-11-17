<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<style>
.errorblock {
	color: red;
}
</style>
<style type="text/css">@import url(/mapspot/resources/css/main.css);</style>
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
					<a href="/mapspot/admin/users">Home</a> |
					<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
			</div>
			<div style="clear: both"></div>
		</div>	
		<div id="home-container">
			<spring:url value="/admin/createUser" var="abc"></spring:url>
			<h2>Edit Admin user</h2>
			<form:form commandName="User" action="${abc }" method="post">
				<form:input type="hidden" path="personId" value="${user.personId }" />
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<table>
					<tr>
						<td>Name</td>
						<td><form:input type="text" path="name" value="${user.name}" /></td>
						<td><form:errors path="name" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><form:input type="text" path="username"
								value="${user.username}" /></td>
						<td><form:errors path="username" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input type="password" path="password"
								value="${user.password}" /></td>
						<td><form:errors path="password" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input type="text" path="email" value="${user.email}" /></td>
						<td><form:errors path="email" cssClass="errorblock"></form:errors></td>
					</tr>
					<tr>
						<td>Enabled</td>
						<td><form:checkbox path="enabled" value="${user.enabled}" /></td>
						<td><form:errors path="enabled" cssClass="errorblock"></form:errors></td>
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