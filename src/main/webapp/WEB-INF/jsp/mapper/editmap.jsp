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
<title>Edit Map</title>
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
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<a href="../map-list">Maps</a> | 
					<a href="../create-map">Create</a> | 
					<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<td>
						<a href="<spring:url value='/login'/>">Sign-In</a> | <a
						href="<spring:url value='/signup'/>">Sign-Up</a>
					</td>
				</sec:authorize>

			</div>
			<div style="clear: both"></div>
		</div><br/>
		Map Editor
		<div id="content-container">
			<label for="description">Description</label>
			<input type="text" name="description" id="description" value="${map.description}"/> 
			<br/><br/>
			
			<i>Click on a spot to make a label.</i>
			<div id="map-image" style="position:relative;left:0;top:0;">
				<img id="mapImage" src="../map-image/${map.mapId}" style="position:relative;left:0;top:0;width:700px;"/>
			</div>
			
			<img id="spotIcon" src="/mapspot/resources/images/spot.png" style="position:absolute;display:none"/>
			
			<i>Spots:</i>
			<div id="spotList">
				
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
		
		spot++;
		var iconWidth = 0;
		var iconHeight = 0;
		
		$("#spotIcon").on('load', function(){
			iconWidth = $(this).width();
			iconHeight = $(this).height();
		});		
		
		var offset = $("#mapImage").offset();
		var offsetLeft = offset.left;
		var offsetTop = offset.top;
		
	    $('#mapImage').click(function(e) {
		    var spotLeft = (e.pageX - offsetLeft) - (iconWidth/2);
		    var spotTop = (e.pageY - offsetTop) - iconHeight;
		    var spotId = "spot" + spot;
		    
		    $("#spotIcon").clone()
		    			  .attr("id", spotId)
		    			  .css("left", spotLeft)
		    			  .css("top", spotTop)
		    			  .css("display", "block")
		    			  .appendTo("#map-image"); 
		    
		    var spotDescription = prompt("Enter spot description", "");
		      
		    if(spotDescription){
		    	$("#"+spotId).wrap("<a class=\"spot\" style=\"cursor:pointer\" title=\"" + spotDescription + "\"></a>");	
		    	
		    	$("#spotTemplate").clone()
		    					  .attr("id", spotId + "-detail")
		    					  .css("display", "block")
		    					  .appendTo("#spotList");
		    	
		    	$("#"+spotId + "-detail").find("label").html(spot);
		    	$("#"+spotId + "-detail").find("input").attr("value", spotDescription);
		    	
		    	var newSpot = {};
		    	newSpot["description"] = spotDescription;
		    	newSpot["location"] = parseInt(spotLeft) + "," + parseInt(spotTop);
		    	var mapId = $("#mapId").val();
		    	
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "../create-spot/"+mapId,
					data : JSON.stringify(newSpot),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("Map spot created: ", data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
						enableSearchButton(true);
					}
				});
		    	
		    	spot++;
		    } else { $("#"+spotId).hide().destroy(); }
	    });
	    
	    $("#description").on("blur", function(){
	    	var map = {};
	    	map["description"] = $(this).val();
	    	var mapId = $("#mapId").val();
	    	
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "../update-map/"+mapId,
				data : JSON.stringify(map),
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("Map updated: ");
				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				},
				done : function(e) {
					console.log("DONE");
					enableSearchButton(true);
				}
			});
	    })
	});
</script>
</body>
</html>