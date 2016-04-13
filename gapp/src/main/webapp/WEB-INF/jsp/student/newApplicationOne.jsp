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
<script>
	$(document).ready(function() {
		
		$('#citizenship').change(function(event){
			var cit = $('select#citizenship').val();
			if(cit==0 || cit==1){
				$('#txtToefl').removeAttr('required');
			}else{
				$('#txtToefl').Attr('required');
			}
		});
		
		$('#department').change(function(event) {
			var dept = $("select#department").val();
			$.get('/gapp/student/getPrograms.html', {
				department : dept
			}, function(jsonResponse) {
				var select = $('#programs');
				select.find('option').remove();
				$('<option>').val('0').text('Select').appendTo(select);
				$.each(jsonResponse, function(index, value) {
					$('<option>').val(value).text(value).appendTo(select);
				});
			});
		});
	});
</script>
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

				<form:form class="form-horizontal" modelAttribute="application">

					<form:hidden path="intId" />

					<panel class="panel-class">
					<legend>
						<spring:message code="application.header.student" />
					</legend>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="user.firstname" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:input path="strStudentFname" class="form-control"
								required="required" />
							<form:errors path="strStudentFname"
								cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="user.lastname" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:input path="strStudentLname" class="form-control"
								required="required" />
							<form:errors path="strStudentLname"
								cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="user.username" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:input path="strEmail" class="form-control"
								required="required" />
							<form:errors path="strEmail" cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.gender" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:select path="gender.intId" cssClass="form-control">
								<form:option value="0" label="Select" />
								<form:options items="${genders}" itemLabel="strGender"
									itemValue="intId" />
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.birthdate" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<fmt:formatDate value="${application.dateDOB}" var="dateString"
								pattern="MM/dd/yyyy" />
							<form:input path="dateDOB" class="form-control"
								value="${dateString}" required="required" />
							<form:errors path="dateDOB" cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.cin" /></label>
						<div class="col-sm-4">
							<form:input path="strCIN" class="form-control" />
							<form:errors path="strCIN" cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.phone" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:input path="strPhone" class="form-control"
								required="required" />
							<form:errors path="strPhone" cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.citizenship" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:select path="citizenship.intId" id="citizenship"
								cssClass="form-control">
								<form:option value="0" label="Select" />
								<form:options items="${countries}" itemLabel="strCountryName"
									itemValue="intId" />
							</form:select>
							<form:errors path="citizenship" cssClass="alert alert-warning" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" id="lblToefl"><spring:message
								code="application.toefl" />
								<span style="color:red;" id="toeflReq"></span>
								</label>
						<div class="col-sm-4">
							<form:input path="strToefl" class="form-control" id="txtToefl"
								required="required" />
							<form:errors path="strToefl" cssClass="alert alert-warning" />
						</div>
					</div>

					</panel>

					<panel class="panel-class"> <legend>
						<spring:message code="application.header.department" />
					</legend>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.department" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<c:choose>
								<c:when test="${application.intId == 0}">
									<form:select path="department.intId" id="department"
										cssClass="form-control" required="required">
										<form:option value="0" label="Select" />
										<form:options items="${departments}" itemLabel="strDepartment"
											itemValue="intId"  />
									</form:select>
								</c:when>
								<c:when test="${application.intId != 0}">
									<form:hidden path="department.intId" />
									<form:input path="department.strDepartment" readonly="true"
										cssClass="form-control" />
								</c:when>
							</c:choose>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.program" /></label>
						<div class="col-sm-4">
							<form:select path="programs.strProgramName" id="programs"
								cssClass="form-control" required="required">
								<c:choose>
									<c:when test="${application.intId == 0}">
										<form:option value="0" label="Select Department First" />
									</c:when>
									<c:when test="${application.intId != 0}">
										<form:options items="${programss}" itemValue="strProgramName"
											itemLabel="strProgramName" />
									</c:when>
								</c:choose>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4"><spring:message
								code="application.term" /><span style="color:red;" >*</span></label>
						<div class="col-sm-4">
							<form:select path="term.intId" id="terms" cssClass="form-control" required="required">
								<form:option value="0" label="Select" />
								<form:options items="${terms}" itemLabel="strTerm"
									itemValue="intId" />
							</form:select>
						</div>
					</div>
					</panel>

					<div class="form-group" style="margin-top:50px;">
					
						
						<div class="col-sm-offset-6 col-sm-1">
							<input type="reset" value="<spring:message code="button.clear"/>"
								class="btn" name="clear" />
						</div>
						
						<div class="col-md-5">
							<input type="submit"
								value="<spring:message code="button.application.one"/>"
								class="btn btn-success right" name="submit" />
						</div>
					</div>
					</panel>
				
				</form:form>

			</div>
		</div>
	</div>
	<%-- End : Page Code --%>

</body>
</html>