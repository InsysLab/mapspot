<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<section>
		<div>
			<div >
				
			</div>
		</div>
	</section>
<div>
    <div>
		<div>
    		<div >
			  	<div >
			    	<h3 >Please sign in</h3>
			 	</div>
			  	<div >
			  	<c:if test="${not empty error}">
				</c:if>
			    	<form action="<spring:url value="/postLogin"></spring:url>" method="post">
                    <fieldset>
                    
			    	  	<div >
			    		    <input placeholder="User Name" name='username' type="text">
			    		</div>
			    		<div >
			    			<input placeholder="Password" name='password'  type="password" value="">
			    		</div>
			    		<input  type="submit" value="Login">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
