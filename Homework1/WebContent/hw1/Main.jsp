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
<link rel='stylesheet' type='text/css'
    href='../MyStyle.css'/>
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
		<b>CS Grad Admission</b>
	</div>
	
	<a href="AddApplication">Add New Application</a>
	
	<table style="width: 90%; margin: auto; margin-bottom: 50px;"
		class="table-bordered table">
		<caption class="bg-success MyCaption">Application list</caption>
		
		<tr>
			<th><a href="Main?SortBy=name">Applicant</a></th>
			<th><a href="Main?SortBy=date">Application Received On</a></th>
			<th><a href="Main?SortBy=gpa">GPA</a></th>
			<th><a href="Main?SortBy=status">Status</a></th>
			<th></th>
		</tr>
	
	
		<c:forEach items="${Applications}" var="appli">
		<tr>
			<td>${appli.name}</td>
			<td><fmt:formatDate pattern="MM/dd/yyyy" value="${appli.receivedOn}" /></td>
			<td>${appli.gpa == 0.0 ? "":appli.gpa}</td>
			<td>${appli.status.displayName}</td>
			<td><a href="EditApplication?id=${appli.id}" >Edit</a></td>
		</tr>
		</c:forEach>
		
	
	</table>
</body>
</html>