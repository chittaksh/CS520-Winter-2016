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
	<div class="col-md-12">
		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only">Error:</span>
				<c:out value="${errorMessage}" />
			</div>
		</c:if>
	</div>
	<%-- End : Error on Form --%>

	<%-- Start - Menu bar --%>
	<div class="col-md-3">
		<div class="panel panel-success" style="margin: 20px">
			<div class="panel-heading">
				<spring:message code="application.menu" />
			</div>
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="home.html">Home</a></li>
					<li role="presentation"><a href="newApplicationOne.html">New
							Application</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%-- End - Menu Bar --%>

	<%-- Start : Page Code --%>
	<div class="col-md-9">
		<div class="panel panel-warning" style="margin: 20px;">
			<div class="panel-heading">
				<spring:message code="panel.dashboard" />
			</div>
			<div class="panel-body" style="margin: auto;">

				<table class="table table-bordered">
					<caption class="bg-success myCaption">
						Applications
						<div class="right">${applicationList.size()}</div>
					</caption>
					<tr>
						<th>ID
						</td>
						<th>Department Name</th>
						<th>Program Name</th>
						<th>Session</th>
						<th>Submit Date</th>
						<th>Status</th>
						<th>Edit</th>
					</tr>

					<c:forEach items="${applicationList}" var="app">
						<tr>
							<td>${app.intId}</td>
							<td>${app.department.strDepartment}</td>
							<td>${app.programs.strProgramName}</td>
							<td>${app.term.strTerm}</td>
							<td><fmt:formatDate value="${app.submitDate}"
									pattern="MM/dd/yyyy" /></td>
							<td><c:choose>
									<c:when test="${app.submitDate!=null}">
									Submitted
								</c:when>
									<c:when test="${app.submitDate==null}">
									Not Submitted
								</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${app.submitDate!=null}">
										<a href="viewApplication.html?appId=${app.intId}">View</a>
									</c:when>
									<c:when test="${app.submitDate==null}">
										<a href="newApplicationOne.html?appId=${app.intId}">Edit</a>
									</c:when>
								</c:choose></td>
						</tr>
					</c:forEach>

				</table>

			</div>
		</div>
	</div>
	<%-- End : Page Code --%>

</body>
</html>