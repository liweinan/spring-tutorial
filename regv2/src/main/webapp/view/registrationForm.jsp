<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><fmt:message key="title.registrationForm" /></title>

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
		<form:form modelAttribute="registration">
			<table>
				<tr>
					<td>
						<form:hidden path="id" />
						<fmt:message key="username" />
						-
						<form:input path="username" />
						<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "username",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true, trim : true, promptMessage : "<fmt:message key="usernameCannotDuplicate" />"
						}}));
						</script>
						<br>
						<form:errors path="username" />
					</td>
				</tr>
				<tr>
					<td>
						<fmt:message key="clazzName" />
						-
						<form:select path="clazz" items="${clazzList}" itemValue="id"
							itemLabel="clazzName" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="proceed"
							onclick="Spring.remoting.submitForm('proceed', 'registration', return false;" />
						<script type="text/javascript">
							Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));
						</script>
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>
