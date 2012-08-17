<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><fmt:message key="title.clazzForm" /></title>
	</head>
	<body>
		<form:form modelAttribute="clazz">
			<table>
				<form:hidden path="id" />
				<fmt:message key="clazzName" />
				-
				<form:input path="clazzName" />
				<br>
				<input type="submit" name="_eventId_proceed" />
				<form:errors path="clazzName" />
				<input type="submit" name="_eventId_cancel" value="cancel" />
			</table>
		</form:form>
	</body>
</html>
