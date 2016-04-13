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
					<li role="presentation"><a href="departments.html">Departments</a></li>
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

				<form:form class="form-horizontal" modelAttribute="prog">
				<form:hidden path="intId"/>
					<div class="form-group">
						<label class="control-label col-sm-3"><spring:message
								code="program.name" /></label>
						<div class="col-sm-4">
							<form:input path="strProgramName" class="form-control" required="required"/>
							<form:errors path="strProgramName" cssClass="alert alert-warning" />
						</div>
						<div class="col-sm-4">
							<input type="submit"
								value="<spring:message code="button.submit"/>"
								class="btn btn-primary" name="submit" /> <input type="reset"
								value="<spring:message code="button.clear"/>" class="btn"
								name="clear" />
						</div>
					</div>
				</form:form>

				<table class="table table-bordered">
					<caption class="bg-success myCaption">
						Programs
						<div class="right">${department.programs.size()}</div>
					</caption>
					<tr>
						<th>Program Name</th>
						<th>Deleted</th>
						<th>Operations</th>
					</tr>
					<c:forEach items="${department.programs}" var="prog">
						<tr>
							<td>${prog.strProgramName}</td>
							<td>${prog.deleted}</td>
							<td><a
								href="editProgram.html?id=${department.intId}&progId=${prog.intId}"><span class="glyphicon glyphicon-pencil"
								style="margin-right: 5px;" />Edit</a>
								<a href="deleteDetails.html?from=program&id=${prog.intId}"><span class="glyphicon glyphicon-trash"
								style="margin-right: 5px;" />Toggle Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
		<%-- End : Page Code --%>
</body>
</html>