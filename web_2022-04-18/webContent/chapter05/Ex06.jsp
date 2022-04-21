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

<!-- 	1부터 Ex02에서 전달 받은 수 사이의 정수 합계 -->
<!-- step이 1이면 생략해도 됨 -->
	<c:set var="total" value="0" />
	<c:forEach var="count" begin="1" end="${param.age }" >
		<c:set var="total" value="${total + count }" />
	</c:forEach>

	<p>1 ~ ${param.count }까지 합계는 ${total } 입니다.</p>
	
</body>
</html>