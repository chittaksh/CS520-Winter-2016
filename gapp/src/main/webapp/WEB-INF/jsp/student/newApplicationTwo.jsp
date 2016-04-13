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

					<panel class="panel-class"> <c:forEach
						items="${application.eduBackground}" var="background" begin="0"
						varStatus="i">

						<div style="margin-top:${i.index!=0 ? 50:0}px;">
							<legend>
								<spring:message code="application.header.education" />
								${i.index!=0 ? i.index:''}
							</legend>
							<form:hidden path="eduBackground[${i.index}].intId" />

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.university" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<form:input path="eduBackground[${i.index}].strUniversity"
										class="form-control" required="required" />
									<form:errors path="eduBackground[${i.index}].strUniversity"
										cssClass="alert alert-warning" />
								</div>
								<c:if test="${application.eduBackground[i.index].intId != 0}" >
								<div class="right">
									<a href="deleteDetails.html?from=education&id=${application.eduBackground[i.index].intId}&appId=${application.intId}" class="btn btn-danger">Delete</a>
								</div>
								</c:if>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.college" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<form:input path="eduBackground[${i.index}].strCollege"
										id="eduBackground[${i.index}]" class="form-control"
										required="required" />
									<form:errors path="eduBackground[${i.index}].strCollege"
										id="strCollege" cssClass="alert alert-warning" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.degree" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<form:input path="eduBackground[${i.index}].strDegree"
										class="form-control" required="required" />
									<form:errors path="eduBackground[${i.index}].strDegree"
										cssClass="alert alert-warning" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.startdate" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<fmt:formatDate value="${background.startedOn}" var="dateStart"
										pattern="MM/dd/yyyy" />
									<form:input path="eduBackground[${i.index}].startedOn"
										value="${dateStart}" class="form-control" required="required" />
									<form:errors path="eduBackground[${i.index}].startedOn"
										cssClass="alert alert-warning" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.enddate" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<fmt:formatDate value="${background.endDate}" var="dateEnd"
										pattern="MM/dd/yyyy" />
									<form:input path="eduBackground[${i.index}].endDate"
										value="${dateEnd}" class="form-control" required="required" />
									<form:errors path="eduBackground[${i.index}].endDate"
										cssClass="alert alert-warning" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.gpa" /><span style="color:red;" >*</span></label>
								<div class="col-sm-4">
									<form:input path="eduBackground[${i.index}].dbGpa"
										class="form-control" required="required" />
									<form:errors path="eduBackground[${i.index}].dbGpa"
										cssClass="alert alert-warning" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4"><spring:message
										code="application.transcript" /></label>
								<div class="col-sm-4">
									<div class="input-group">
										<input class="form-control" type="file" name="file"
											id="eduBackground[${i.index}]" />
									</div>
								</div>
								<c:if test="${background.fileTranscript != null}">
									<div class="col-sm-4">
										<div class="input-group">
											<a
												href="download.html?Id=${background.fileTranscript[fn:length(background.fileTranscript)-1].intId}">
												${background.fileTranscript[fn:length(background.fileTranscript)-1].strName}
											</a>
										</div>
									</div>
								</c:if>
							</div>
					</c:forEach> </panel>

					<div class="form-group" style="margin-top: 50px;">

						<div class="col-sm-3">
							<a href="newApplicationOne.html?appId=${application.intId}"
								class="btn">Back : Basic Details</a>
						</div>

						<div class="col-sm-3">
							<input type="submit" name="action" value="<spring:message code="button.addnew"/>"
								class="btn btn-primary" name="submit" />
						</div>

						<div class=" col-sm-2">
							<input type="reset" value="<spring:message code="button.clear"/>"
								class="btn" name="clear" />
						</div>

						<div class="col-sm-4">
							<input type="submit" name="action"
								value="<spring:message code="button.application.two"/>"
								class="btn btn-success right" name="submit" />
						</div>

					</div>
			</div>
			</form:form>
		</div>
	</div>
	</div>
	<%-- End : Page Code --%>

</body>
</html>