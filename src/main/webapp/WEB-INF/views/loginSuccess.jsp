<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="resources/jquery-1.11.3.min.js"></script>
<link href="resources/ol.css"rel="stylesheet">
<script src="resources/ol.js"></script>
<script src="resources/proj4.js"></script>

</head>
<body>

<div>이름 : ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal}</div>
<div>권한 : ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.authorities}</div>

<div id="map"></div>

<div id="info"></div>


<div>로그인 성공</div>

	<form action="/logout" method="POST">
		<input type="submit" value="로그아웃" />
	</form>

</body>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">

	var wmsSource = new ol.source.TileWMS({
	    url: 'http://127.0.0.1:8080/geoserver/cmw/wms',
	    params: { 'LAYERS': 'cmw:cmw_intern' },
	    serverType: 'geoserver',
	    CrossOrigin: 'anonymous'
	});
	 
	var defaultLayer = new ol.layer.Tile({
	    source: new ol.source.OSM()
	});
	
	var wmsLayer = new ol.layer.Tile({
	    source: wmsSource,
	    maxFeatures : 200
	});
	
	/* var projection = new ol.proj.Projection({
		extent : [126.961318969727, 37.4006729125977, 127.047470092773, 37.4673690795898]
	}) */
	
	var view = new ol.View({
	    center: [0, 0],
	    zoom: 3,
	    /* projection : projection */
	});

	var map = new ol.Map({
	    layers: [wmsLayer],
	    target: 'map',
	    view: view
	});

	</script>
</html>