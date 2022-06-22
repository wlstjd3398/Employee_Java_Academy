<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="memberList.title" /></title>
</head>
<body>

	<form:form modelAttribute="cmd">
		<label>from : <form:input path="from"/> </label>
		<form:errors path="from" />
		
		~
		
		<label>to : <form:input path="to"/> </label>
		<form:errors path="to" />
	</form:form>
	
</body>
</html>