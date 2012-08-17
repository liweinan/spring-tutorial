<%@ include file="/common/includes.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ page
			import="org.springframework.security.ui.AbstractProcessingFilter"%>
		<%@ page
			import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
		<%@ page import="org.springframework.security.AuthenticationException"%>

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
		<h1>
			<fmt:message key="title.login" />
		</h1>

		<c:if test="${not empty param.login_error}">
			<div class="errors">
				<fmt:message key="authFailed" />
				<br />
				<br />
				<fmt:message key="reason" />
				<%=((AuthenticationException) session
									.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
									.getMessage()%>
			</div>
		</c:if>

		<div class="section">
			<form name="f" action="<c:url value="/web/loginProcess" />"
				method="post">
				<fieldset>
					<div class="field">
						<div class="label">
							<label for="j_username">
								<fmt:message key="loginname" />
							</label>
						</div>
						<div class="output">
							<input type="text" name="j_username" id="j_username"
								<c:if test="${not empty param.login_error}">value="<%=session
									.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>"</c:if> />
							<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "j_username",
							widgetType : "dijit.form.ValidationTextBox",
							widgetAttrs : { promptMessage : "<fmt:message key="yourloginname" />", required : true }}));
					</script>
						</div>
					</div>
					<div class="field">
						<div class="label">
							<label for="j_password">
								<fmt:message key="password" />
							</label>
						</div>
						<div class="output">
							<input type="password" name="j_password" id="j_password" />
							<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "j_password",
							widgetType : "dijit.form.ValidationTextBox",
							widgetAttrs : { promptMessage : "<fmt:message key="yourpassword" />", required : true}}));
					</script>
						</div>
					</div>
					<div class="field">
						<div class="label">
							<label for="remember_me">
								<fmt:message key="remember_me" />
							</label>
						</div>
						<div class="output">
							<input type="checkbox" name="_spring_security_remember_me"
								id="remember_me" />
							<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "remember_me",
							widgetType : "dijit.form.CheckBox"}));
					</script>
						</div>
					</div>
				</fieldset>
				<div class="buttonGroup">
					<input name="submit" id="submit" type="submit" />
					<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
			</script>
				</div>
			</form>
	</body>
</html>
