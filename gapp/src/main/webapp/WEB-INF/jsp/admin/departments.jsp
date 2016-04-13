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
<jsp:include page="../header.jsp"></jsp:include>
<title><spring:message code="application.title" /> <spring:message
		code="page.admin" /></title>
</head>
<body class="container">


	<%--  Start : Error on Form --%>
	<c:if test="${errorMessage != null}">
		<div class="alert alert-danger" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span>
			<c:out value="${errorMessage}" />
		</div>
	</c:if>
	<%-- End : Error on Form --%>



	<%-- Start - Menu bar --%>
	<div class="col-md-3">
		<div class="panel panel-success" style="margin: 20px;">
			<div class="panel-heading">
				<spring:message code="application.menu" />
			</div>
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation"><a href="home.html">Home</a></li>
					<li role="presentation" class="active"><a
						href="departments.html">Departments</a></li>
					<li role="presentation"><a href="#">Users</a></li>
					<li role="presentation"><a href="#">Applications</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%-- End - Menu Bar --%>

	<%-- Start : Page Code --%>
	<div class="col-md-9">
		<div class="panel panel-warning" style="margin: 20px;">
			<div class="panel-heading">
				<spring:message code="panel.departments" />
			</div>
			<div class="panel-body" style="margin: auto;">
				<table class="table table-bordered">
					<caption class="bg-success myCaption">
						Departments
						<div class="right">${departments.size()}</div>
					</caption>
					<tr>
						<th>ID</th>
						<th>Department Name</th>
						<th># Program</th>
						<th>Edit</th>
					</tr>

					<c:forEach items="${departments}" var="dept">
						<tr>
							<td>${dept.intId}</td>
							<td>${dept.strDepartment}</td>
							<td>${dept.programs.size()}</td>
							<td><a href="editDepartment.html?id=${dept.intId}">Edit</a></td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="4"><a href="editDepartment.html"
							class="btn btn-primary">Add New Department</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%-- End : Page Code --%>
	
	</body>
</html>