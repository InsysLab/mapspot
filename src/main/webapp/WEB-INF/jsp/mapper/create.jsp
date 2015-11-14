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
			<div style="float:left">
				<h2>MapSpot</h2>
			</div>
			
			<div class="logout-box">
				<a href="logout">Logout</a>
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="home-container">
			<p>
				<form:form method="POST" commandName="upload"	enctype="multipart/form-data">
					Upload image file: 
					<input type="file" name="file" />
					<input type="submit" value="upload" />
					<form:errors path="file" cssStyle="color: #ff0000;" />
				</form:form>
			</p>
		</div>
	</div>
	<div id="footer">
		&copy; 2015.  All rights reserved.
	</div>	
</body>
</html>