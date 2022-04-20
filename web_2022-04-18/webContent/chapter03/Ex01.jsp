<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String url = request.getParameter("url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Ex01.jsp 페이지입니다.</h1>
	
<!-- 	RequestDispatcher와 동일한 동작 -->
<!-- 절대경로 : "/chapter03/Ex02.jsp", 상대경로 : "Ex02.jsp" -->
	<jsp:forward page="<%= url %>"/>

</body>
</html>