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
					<li role="presentation"><a href="home.html">Home</a></li>
					<li role="presentation" class="active"><a
						href="newApplicationOne.html">New Application</a></li>
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

				<form:form class="form-horizontal" modelAttribute="application"
					enctype="multipart/form-data">

					<panel class="panel-class"> <legend><spring:message code="application.header.departmental"/></legend> <c:forEach items="${application.appDeptReqValues}"
						var="appReq" begin="0" varStatus="i">

						<form:hidden path="appDeptReqValues[${i.index}].intId" />
						
						<form:hidden path="appDeptReqValues[${i.index}].deptReq.intId"/>
						<form:hidden path="appDeptReqValues[${i.index}].deptReq.dataType.strDataType"/>

						<c:choose>
							<c:when
								test="${appReqValues[i.index].deptReq.dataType.strDataType == 'File'}">
								<div class="form-group">
									<label class="control-label col-sm-4">${appReqValues[i.index].deptReq.strField}</label>
									<div class="col-sm-4">
										<input class="form-control" type="file" name="file"
											id="appDeptReqValues[${i.index}]" />
									</div>
									<div class="input-group">
										<a
											href="download.html?Id=${appReqValues[i.index].fileUpload[fn:length(appReqValues[i.index].fileUpload)-1].intId}">
											${appReqValues[i.index].fileUpload[fn:length(appReqValues[i.index].fileUpload)-1].strName}
										</a>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<label class="control-label col-sm-4">${appReqValues[i.index].deptReq.strField}</label>
									<div class="col-sm-4">
										<form:input path="appDeptReqValues[${i.index}].strValue"
											class="form-control" />
										<form:errors path="appDeptReqValues[${i.index}].strValue"
											cssClass="alert alert-warning" />
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<div class="form-group" style="margin-top:50px;">
					
					<div class="col-md-3">
							<a href="newApplicationTwo.html?appId=${application.intId}"
								class="btn">Back</a>
						</div>
						
						<div class="col-md-3">
							<input type="submit" name="action" value="Save"
								class="btn btn-primary" />
						</div>
						
						<div class="col-md-1">
							<input type="reset" value="<spring:message code="button.clear"/>"
								class="btn" name="clear" />
						</div>
						
						<div class="col-md-5">
							<input type="submit" name="action"
								value="<spring:message code="button.submit"/>"
								class="btn btn-success right" />
						</div>
					</div>
					</panel>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>