<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>查看报名情况</title>
	</head>
	<body>
		<a href="${pageContext.request.contextPath}" />回首页</a>
		<hr>
		<c:forEach items="${clazzList}" var="clazz">
			<table border="1">
				<tr>
					<td colspan="2">
						${clazz.clazzName}
					</td>
				</tr>
				<tr>
					<td>
						<fmt:message key="username" />
					</td>
					<td>
						<fmt:message key="createdAt" />
					</td>
				</tr>
				<c:forEach items="${clazz.registrations}" var="registration">
					<tr>
						<td>
							${registration.username}
						</td>
						<td>
							${registration.createdAt}
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</c:forEach>
	</body>
</html>
