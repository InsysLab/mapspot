<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Maps</title>
</head>
<body>
	<h1>List of Maps</h1>
	<h1>Users List</h1>
	
	<table>
		<c:forEach var="map" items="${maps}">
			<tr>
				<td>${map.description }</td>
				<td><a href="user/edit/${map.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>