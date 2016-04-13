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

				<form:form class="form-horizontal" modelAttribute="deptReq">
					<form:hidden path="intId" />
					<div class="form-group">
						<label class="control-label col-sm-3"><spring:message
								code="requirement.name" /></label>
						<div class="col-sm-4">
							<form:input path="strField" class="form-control"
								required="required" />
							<form:errors path="strField" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3"><spring:message
								code="requirement.type" /></label>
						<div class="col-sm-4">
							<form:select path="dataType.intId" cssClass="form-control">
								<form:options items="${fileTypes}" itemLabel="strDataType"
									itemValue="intId" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3"><spring:message
								code="requirement.required" /></label>
						<div class="col-sm-4">
							<form:checkbox path="required" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-4 col-md-offset-4">
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
						Department Requirements
						<div class="right">${department.requirements.size()}</div>
					</caption>
					<tr>
						<th>Requirement</th>
						<th>Data Type</th>
						<th>Required</th>
						<th>Deleted</th>
						<th>Operation</th>
					</tr>
					<c:forEach items="${department.requirements}" var="requi">
						<tr>
							<td>${requi.strField}</td>
							<td>${requi.dataType.strDataType}</td>
							<td>${requi.required}</td>
							<td>${requi.deleted}</td>
							<td>
								<div style="margin: 5px;">
									<a class="glyphicon glyphicon-pencil"
										href="editRequirement.html?id=${department.intId}&typeId=${requi.intId}">Edit</a>
								</div> <a class="glyphicon glyphicon-trash"
								href="deleteDetails.html?from=requirements&id=${requi.intId}">Toggle
									Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
		<%-- End : Page Code --%>
</body>
</html>