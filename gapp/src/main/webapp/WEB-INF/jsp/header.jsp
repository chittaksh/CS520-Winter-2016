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
<link rel='stylesheet' type='text/css' href='../MyStyle.css' />
<link rel='stylesheet' type='text/css' href='MyStyle.css' />
<link rel='stylesheet'
	href='https://bootswatch.com/superhero/bootstrap.min.css' />
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" /> -->
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
</head>
<body class="container">

	<%-- Start : Application Header --%>
	<div class="col-md-12 header">
		<div class="left">
			<h1>
				<spring:message code="application.name" />
			</h1>
		</div>
		<c:if test="${user.strEmail != null}">
			<div class="right"
				style="position: absolute; bottom: 10px; right: 10px;">
				<h4>
					${user.strEmail} <a href="../logout.html">Logout</a>
				</h4>
			</div>
		</c:if>
	</div>
	<%-- End : Application Header --%>

</body>
</html>