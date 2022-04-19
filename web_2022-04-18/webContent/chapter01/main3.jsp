<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int number1 = 5;
	double number2 = 3.14;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>표현식 태그는 값을 출력하고 싶을 때 사용</h1>
	
<!-- 	표현식이 자바에서 sysout같은 느낌 -->
	<div> <%= number1 %> </div>
	<div> <%= number2 %> </div>
	<div> <%= 'a' %> </div>
	<div> <%= "Hello World" %> </div>

</body>
</html>