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
			    	<h3 >Please sign up</h3>
			 	</div>
			  	<div >
			  	<c:if test="${not empty error}">
				</c:if>
			    	<form action="<spring:url value="/signup"></spring:url>" method="post">
                    <fieldset>
			    	  	<div >
			    		    <input placeholder="User Name" name='username' type="text">
			    		</div>
			    		<div >
			    			<input placeholder="Password" name='password'  type="password" value="">
			    		</div>
			    			<div >
			    		    <input placeholder="Full Name" name='name' type="text">
			    		</div>
			    			
			    			<div >
			    		    <input placeholder="Age" name='age' type="text">
			    		</div>	
			    		<div >
			    		    <input placeholder="Email" name='email' type="text">
			    		</div>	
			    			    		
			    		<input  type="submit" value="Signup">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
