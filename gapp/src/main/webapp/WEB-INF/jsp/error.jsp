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
			<spring:message code="page.error" />
		</h2>
	</div>
	<%-- End : Page Name --%>

	<%-- Start : Page Code --%>
	<div class="col-md-12 center" style="margin: 20px;">
		<div class="row">
			<label class="forl-label"><spring:message
					code="page.error.instruction" /></label>
		</div>
		<div class="row">
			<label class="form-label" style="margin-top: 20px;">For
				Developer</label>
		</div>
		<div class="row">
			<label>${exception}</label>
		</div>
		<div class="row">
			<label>${exception.message}</label>
		</div>
	</div>
	<%-- End : Page Code --%>
</body>
</html>