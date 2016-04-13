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

				<panel class="panel-class"> <legend>
					<spring:message code="application.header.student" />
				</legend>

				<div class="col-ms-offest-3">
					<div class="form-group col-md-12">
						<label class="control-label col-sm-4">Application ID</label> <label
							class="control-label col-sm-4">${application.intId}</label>
					</div>


					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="user.firstname" /></label> <label class="control-label col-sm-4">${application.strStudentFname}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="user.lastname" /></label> <label class="control-label col-sm-4">${application.strStudentLname}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="user.username" /></label> <label class="control-label col-sm-4">${application.strEmail}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.gender" /></label> <label
							class="control-label col-sm-4">${application.gender.strGender}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.birthdate" /></label> <label
							class="control-label col-sm-4"> <fmt:formatDate
								value="${application.dateDOB}" pattern="MM/dd/yyyy" /></label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.cin" /></label> <label class="control-label col-sm-4">${application.strCIN}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.phone" /></label> <label
							class="control-label col-sm-4">${application.strPhone}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.citizenship" /></label> <label
							class="control-label col-sm-4">${application.citizenship.strCountryName}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4" id="lblToefl"><spring:message
								code="application.toefl" /> </label> <label
							class="control-label col-sm-4">${application.strToefl}</label>
					</div>
				</div>
				</panel>

				<panel class="panel-class"> <legend>
					<spring:message code="application.header.department" />
				</legend>

				<div class="col-ms-offest-3">
					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.department" /></label> <label
							class="control-label col-sm-4">${application.department.strDepartment}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.program" /></label> <label
							class="control-label col-sm-4">${application.programs.strProgramName}</label>
					</div>

					<div class="form-group col-md-12">
						<label class="control-label col-sm-4"><spring:message
								code="application.term" /></label> <label
							class="control-label col-sm-4">${application.term.strTerm}</label>
					</div>
				</div>
				</panel>

				<c:forEach items="${application.getEduBackground()}"
					var="eduBackground" varStatus="i">

					<panel class="panel-class"> <legend>
						<spring:message code="application.header.education" />
						${i.index!=0 ? i.index:''}
					</legend>
					<div class="col-ms-offest-3">
						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.university" /></label> <label
								class="control-label col-sm-4">${eduBackground.strUniversity}</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.college" /></label> <label
								class="control-label col-sm-4">${eduBackground.strCollege}</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.degree" /></label> <label
								class="control-label col-sm-4">${eduBackground.strDegree}</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.startdate" /></label> <label
								class="control-label col-sm-4"> <fmt:formatDate
									value="${eduBackground.startedOn}" pattern="MM/dd/yyyy" />
							</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.enddate" /></label> <label
								class="control-label col-sm-4"> <fmt:formatDate
									value="${eduBackground.endDate}" pattern="MM/dd/yyyy" />
							</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.gpa" /></label> <label
								class="control-label col-sm-4">${eduBackground.dbGpa}</label>
						</div>

						<div class="form-group col-md-12">
							<label class="control-label col-sm-4"><spring:message
									code="application.transcript" /></label>
							<c:if test="${eduBackground.getFileTranscript() != null}">
								<div class="col-sm-4">
									<a
										href="download.html?Id=${eduBackground.getFileTranscript()[fn:length(eduBackground.getFileTranscript())-1].intId}">
										${eduBackground.getFileTranscript()[fn:length(eduBackground.getFileTranscript())-1].strName}
									</a>
								</div>
							</c:if>
						</div>
					</div>
					</panel>
				</c:forEach>

				<panel class="panel-class"> <legend>
					<spring:message code="application.header.departmental" />
					${i.index!=0 ? i.index:''}
				</legend> <c:forEach items="${application.getAppDeptReqValues()}"
					var="appRequest" varStatus="i">

					<c:choose>
						<c:when
							test="${appRequest.deptReq.dataType.strDataType == 'File'}">
							<div class="form-group col-md-12">
								<label class="control-label col-sm-4">${appRequest.deptReq.strField}</label>
								<div class="input-group">
									<a
										href="download.html?Id=${appRequest.fileUpload[fn:length(appRequest.fileUpload)-1].intId}">
										${appRequest.fileUpload[fn:length(appRequest.fileUpload)-1].strName}
									</a>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group col-md-12">
								<label class="control-label col-sm-4">${appRequest.deptReq.strField}</label>
								<label class="control-label col-sm-4">${appRequest.strValue}</label>
							</div>
						</c:otherwise>
					</c:choose>

				</c:forEach> </panel>
			</div>
		</div>
	</div>
	<%-- End : Page Code --%>


</body>
</html>