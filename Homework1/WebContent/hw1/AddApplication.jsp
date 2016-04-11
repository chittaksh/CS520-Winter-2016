<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='../MyStyle.css' />
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css' />
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<title>Home-Work 1</title>
</head>
<body class="container">

	<h1>CS Graduate Admission</h1>

	<%--  Start : Error on Form --%>
	<c:if test="${errorMessage != null}">
		<div class="alert alert-danger" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span>
			<c:out value="${errorMessage}" />
		</div>
	</c:if>
	<%-- End : Error on Form --%>

	<div style="text-align: left;">
		<a href="Main"><b>CS Grad Admission</b></a> > <b>Add Application</b>
	</div>

	<h4>Add Form</h4>
	<form method="post" action="AddApplication" class="form-horizontal"
		role="form" name="editForm">

		<div class="form-group">
			<label for="name" class="control-label col-sm-5">Name : </label>
			<div class="col-sm-4">
				<input type="text" name="name" class="form-control" required />
			</div>
		</div>

		<div class="form-group">
			<label for="date" class="control-label col-sm-5">Application
				Received On (M/d/yyyy): </label>
			<div class="col-sm-4">
				<input type="text" name="date" class="form-control" required />
			</div>
		</div>

		<div class="form-group">
			<label for="gpa" class="control-label col-sm-5">GPA : </label>
			<div class="col-sm-4">
				<input type="text" name="gpa" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="status" class="control-label col-sm-5">Status : </label>
			<div class="col-sm-4">
				<select name="status" class="form-control">
					<c:forEach items="${applicationScope.status}" var="stat">
						<option value="${stat.value}">
							<c:out value="${stat.displayName}" />
						</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-2">
				<input type="submit" value="Save" class="btn btn-primary"
					name="submit" />
			</div>
			<div class="col-sm-1">
				<button value="Clear" type="reset" class="btn">Clear</button>
			</div>
		</div>

	</form>
</body>
</html>