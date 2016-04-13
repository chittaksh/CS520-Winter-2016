<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
<title><spring:message code="application.title" /> <spring:message
		code="page.login" /></title>
</head>
<body class="container">

	<%-- Start : Page Name --%>
	<div class="col-md-12 center" style="margin: 20px;">
		<h2>
			<spring:message code="page.login" />
		</h2>
	</div>
	<%-- End : Page Name --%>

	<%--  Start : Error on Form --%>
	<div class="col-md-12">
		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only"><spring:message
						code="application.error" /> : </span>
				<c:out value="${errorMessage}" />
			</div>
		</c:if>
	</div>
	<%-- End : Error on Form --%>

	<%-- Start : Page Code --%>
	<div class="col-md-12 center" style="margin: 20px;">
		<form:form method="post" class="form-horizontal col-sm-offset-4"
			modelAttribute="user">
			<div class="form-group">
				<label for="email" class="control-label col-sm-2"><spring:message
						code="user.username" /></label>
				<div class="col-sm-3">
					<form:input path="strEmail" cssClass="form-control" />
				</div>
				<div class="col-sm-4">
					<form:errors path="strEmail" cssClass="alert alert-warning" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-sm-2"><spring:message
						code="user.password" /></label>
				<div class="col-sm-3">
					<form:password path="strPassword" cssClass="form-control" />
				</div>
				<div class="col-sm-4">
					<form:errors path="strPassword" cssClass="alert alert-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-2">
					<input type="submit" value="<spring:message code="button.submit"/>"
						class="btn btn-primary" name="submit" />
				</div>
				<div class="col-sm-1">
					<input type="reset" value="<spring:message code="button.clear"/>"
						class="btn" name="clear" />
				</div>
			</div>
		</form:form>

		<a href="register.html"><spring:message code="link.toregister" /></a>
	</div>
	<%-- End : Page Code --%>
	</body>
</html>