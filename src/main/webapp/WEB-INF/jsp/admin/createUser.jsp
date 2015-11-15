<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</head>
<body>
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
</body>
</html>