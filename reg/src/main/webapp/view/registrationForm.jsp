<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><fmt:message key="title.registrationForm" /></title>
</head>
<body>
<form:form modelAttribute="registration">
	<table>
	<tr><td>
		<form:hidden path="id" />
		<fmt:message key="username" />
		-
		<form:input path="username" />
		<br>
		<form:errors path="username" />
	</td></tr>
	<tr><td>
		<fmt:message key="clazzName" />
		-
		<form:select path="clazz" items="${clazzList}" itemValue="id"
			itemLabel="clazzName" />
	</td></tr>
	<tr><td>
		<input type="submit" />
	</td></tr>
	</table>
</form:form>
</body>
</html>