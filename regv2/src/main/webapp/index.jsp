<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		<ul>
			<li>
				<a href="<c:url value="/web/addclazz" />" />添加待报名课程</a>
			</li>
			<li>
				<a href="<c:url value="/web/addregistration" />" />进入报名页面</a>
			</li>
			<li>
				<a href="<c:url value="/web/viewregistrations" />" />查看报名情况</a>
			</li>
		</ul>
		<ul>
			<li>
				<a href="<c:url value="services/" />" />查看WebService</a>
			</li>
			<li>
				<a href="<c:url value="/web/search" />" />通过报名者姓名搜索报名信息</a>
			</li>
		</ul>
	</body>
</html>
