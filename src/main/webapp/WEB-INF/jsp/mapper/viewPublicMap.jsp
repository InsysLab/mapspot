<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MapSpot</title>
<style type="text/css">@import url(../resources/css/main.css);</style>
<style type="text/css">@import url(../resources/css/mapper.css);</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
						<a href="<spring:url value='/login'/>">Sign-In</a> | <a
						href="<spring:url value='/signup'/>">Sign-Up</a>
					</td>
				</sec:authorize>

			</div>
			<div style="clear: both"></div>
		</div>
		<div id="content-container">
			<p>${map.description}</p>
			<br/><br/>
			
			<div id="map-image" style="position:relative;left:0;top:0;">
				<img id="mapImage" src="../map-image/${map.mapId}" style="position:relative;left:0;top:0;width:700px;"/>
			</div>
			
			<img id="spotIcon" src="/mapspot/resources/images/spot.png" style="position:absolute;display:none"/>
			
			<div id="spotList" style="display:none">
				
				<div id="spotTemplate" style="display:none">
					<label for="spot-number"></label>
					<input type="text" value="" style="width:200px"/>
				</div>
				
				<c:set var="count" value="1" scope="page" />
				<c:forEach var="spot" items = "${spots}">
					<div>
						<label for="spot-number"><c:out value="${count}" /></label>
						<input type="text" value="${spot.description}" style="width:200px" data-location="${spot.location}"/>
					</div>
					<c:set var="count" value="${count + 1}" scope="page"/>
				</c:forEach>		
				
			</div> <br/>
		</div>	
	</div>
	<div id="footer">&copy; 2015. All rights reserved.</div>
	
	
	<input type="hidden" id="mapId" value="${map.mapId}" />
	<input type="hidden" id="spotCount" value="${fn:length(spots)}" />
	
<script>
	$(document).ready(function() {
		var spot = $("#spotCount").val();
		
		if( spot > 0 ){
			$("#spotList input").each(function(key){
				if( $(this).attr("data-location") ){
					spotLocation = $(this).attr("data-location").split(",");
					description = $(this).val();
					
					spotLeft = parseInt(spotLocation[0]);
					spotTop = parseInt(spotLocation[1]);
					spId = "spot" + (key + 1);
					console.log(spotLeft);
					console.log(spotTop);
					
					$("#spotIcon").clone()
		  			  .attr("id", spId)
		  			  .css("left", spotLeft)
		  			  .css("top", spotTop)
		  			  .css("display", "block")
		  			  .appendTo("#map-image");
					
					$("#" + spId).wrap("<a class=\"spot\" style=\"cursor:pointer\" title=\"" + description + "\"></a>");
				}
			});	
		}
	});
</script>
</body>
</html>