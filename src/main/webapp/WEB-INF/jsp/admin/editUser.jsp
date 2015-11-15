<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	Edit user page
	<form action="../../createUser" method="post">
		<input type="hidden" value="${user.personId}" name="personId" />
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${user.name}" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" value="${user.password}" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
</body>
</html>