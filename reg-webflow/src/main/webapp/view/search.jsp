<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><fmt:message key="title.search" />
		</title>
	</head>
	<body>
		<form method="post">
			<table>
				<fmt:message key="keyword" />
				-
				<input id="keyword" name="keyword" type="text" />
				<input type="submit" />
			</table>
		</form>

		<c:if test="${! empty results}">
				匹配结果：<br>
			<table border="1">
				<tr>
					<td>
						<fmt:message key="username" />
					</td>
					<td>
						<fmt:message key="clazzName" />
					</td>
				</tr>
				<c:forEach items="${results}" var="result">
					<tr>
						<td>
							${result.username}
						</td>
						<td>
							${result.clazz.clazzName}
						</td>

					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>
