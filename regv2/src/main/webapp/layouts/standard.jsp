<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css" media="screen">
			@import url("<c:url value="/resources/dijit/themes/tundra/tundra.css" />");
			@import url("<c:url value="/resources/styles/style.css" />");
			@import url("<c:url value="/resources/styles/cssverticalmenu.css" />");
		</style>

		<script type="text/javascript"
			src="<c:url value="/resources/dojo/dojo.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/spring/Spring.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/cssverticalmenu.js" />"></script>
	</head>
	<body class="tundra">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</body>
</html>
