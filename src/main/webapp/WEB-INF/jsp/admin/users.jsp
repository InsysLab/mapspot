<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
</head>
<body>
	<h1>Users List</h1>
	<a href="admin/createUser">Create a user</a>
	 <table>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>                   
                    <sec:authorize access="hasRole('ROLE_ADMIN')" >
                        <td><a href="admin/user/edit/${user.id}">edit</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
</body>
</html>