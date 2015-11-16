<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<div style="float:left">
				<h2>MapSpot</h2>
			</div>
			
			<div class="logout-box">
				<a href="logout">Logout</a>
			</div>
			<div style="clear:both"></div>
		</div>
		Map Editor
		<div id="content-container">
			Click on a spot to make a label.
			<div id="map-image" style="position:relative;left:0;top:0;maxwidth:800;">
				<img id="mapImage" src="../map-image/${map.mapId}" style="position:relative;left:0;top:0"/>
			</div>
			
			<img id="spotIcon" src="/mapspot/resources/images/spot.png" style="position:absolute;display:none"/>
			
			<div id="spotList" style="width:100%;margin-top:15px;">
				
				<div id="spotTemplate" style="display:none">
					<label for="spot-number"></label>
					<input type="text" value="" style="width:200px"/>
				</div>
			</div> <br/>
			<button id="saveMap">Save</button>
		</div>	
	</div>
	<div id="footer">
		&copy; 2015.  All rights reserved.
	</div>
			
<script>
	$(document).ready(function() {
		var spot = 1;
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
		      
		    if(spotDescription != null || spotDescription != ""){
		    	$("#"+spotId).wrap("<a class=\"spot\" style=\"cursor:pointer\" title=\"" + spotDescription + "\"></a>");	
		    	
		    	$("#spotTemplate").clone()
		    					  .attr("id", spotId + "-detail")
		    					  .css("display", "block")
		    					  .appendTo("#spotList");
		    	
		    	$("#"+spotId + "-detail").find("label").html(spot);
		    	$("#"+spotId + "-detail").find("input").attr("value", spotDescription);
		    	
		    	spot++;
		    } else { $("#"+spotId).hide().destroy(); }
	    });
	    
	});
</script>
</body>
</html>