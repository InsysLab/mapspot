<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">@import url(resources/css/main.css);</style>
</head>
<body>
	<div id="page-container">
		<div id="header">
			<div style="float:left">
				<h2>MapSpot</h2>
			</div>
			
			<div class="login-box">
				<a href="signin">Sign-In</a> | 
				<a href="signup">Sign-Up</a>
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="home-container">
			<div style="float:left">
				<img src="<spring:url value="/resources/images/samplemap/sample1.png"/>" />
				<p>
					Upload image, add spot information, publish!
				</p>
			</div>
			<div style="float:right">
				<img src="<spring:url value="/resources/images/samplemap/sample2.png"/>" />
				<p>
					Share or embed your maps!
				</p>				
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="footer">
			&copy; 2015.  All rights reserved.
		</div>
	</div>
</body>
</html>