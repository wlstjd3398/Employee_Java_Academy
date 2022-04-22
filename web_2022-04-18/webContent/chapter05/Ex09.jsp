<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>  << import 전 >>  </p>
	
	<c:url value="Ex06.jsp" var="importedURL" >
		<c:param name="age" value="10" />
	</c:url>
	${importedURL } <br>
	
<%-- 	<c:import url="Ex05.jsp" /> --%>
	<c:import url="${importedURL }" >
<%-- 		<c:param name="age" value="10" /> --%>
	</c:import>
	
	<br>
	
	
	<p>  << import 후 >>  </p>
	
	
</body>
</html>