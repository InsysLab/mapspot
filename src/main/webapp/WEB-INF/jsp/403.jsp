<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content text-align-center">
	<div class="margin-top-middle red font-size-huge">Access to the web page was denied!</div>

	<div class="margin-top-middle">
		Authorization failed!
	</div>

	<div class="margin-top-middle gray-text font-size-middle">
		<a href="<spring:url value="/login" />">&lt; Login</a>
	</div>

	<div class="margin-top-middle"></div>
</div>