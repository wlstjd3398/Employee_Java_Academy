<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력 내장객체</title>
</head>
<body>

	<%-- 7을 출력 --%>
	7
	<%= 7 %>
	<% out.print(7); %>
	
	<div> div 출력</div>
	
	<%= "<div> 표현식을 사용한 div 출력</div>" %>
	<%
		out.print("<div> out 내장 객체를 사용한 div 출력 </div>");
	%>
	
</body>
</html>