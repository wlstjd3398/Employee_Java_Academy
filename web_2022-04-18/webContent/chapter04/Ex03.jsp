<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>클라이언트가 전달한 ID => ${param.id }</p>
	<p>클라이언트가 전달한 PW => ${param.pw }</p>
	
	<p>클라이언트가 전달한 ID => ${param["id"] }</p>
	<p>클라이언트가 전달한 PW => ${param["pw"] }</p>
	
<!-- 	가져오는법 -->
<!-- 	출력하는법 단계적으로 생각해보기 -->
	<p>ID => <%= id %></p>
<!-- 	표현식 -->
	<p>PW => <% out.print(pw); %></p>
<!-- 	스크립트릿 -->
	
	
	
</body>
</html>