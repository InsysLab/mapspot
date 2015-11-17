<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MapSpot</title>
<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>
	<div id="page-container">
		<div id="header">
			<div style="float: left">
				<h2>MapSpot</h2>
			</div>

			<div class="login-box">
				<sec:authorize access="isAnonymous()">
					<td>
						<a href="<spring:url value='/login'/>"><spring:message code="header.signin"/></a> | <a
						href="<spring:url value='/signup'/>"><spring:message code="header.signup"/></a>
					</td>
				</sec:authorize>

			</div>
			<div style="clear: both"></div>
		</div>
		<div id="content-container">
			<h2 id="banner"><spring:message code="header.signin"/></h2>  
			<span style="color:red">${errorMessage}</span>
			<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
				<table>
					<tr>
						<td>Username:</td>
						<td><input type='text' name='username' /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password'/></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit"/></td>
					</tr>
				</table>
				
				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
				
			</form>
		</div>
	</div>
	<div id="footer">
		Language : <a href="?language=en">English</a>|<a href="?language=fil_PH">Tagalog</a>
		&copy; 2015. All rights reserved.
	</div>
</html>