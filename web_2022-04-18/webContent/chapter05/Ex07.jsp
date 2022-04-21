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

<!-- 	전달받은 수만큼 별을 출력하는 페이지 -->
<!-- 출력예시) -->

<!-- 전달받은 수가 3이라면  -->
<!-- ★ -->
<!-- ★★ -->
<!-- ★★★ -->

<!-- 전달받은 수가 5라면 -->
<!-- ★ -->
<!-- ★★ -->
<!-- ★★★ -->
<!-- ★★★★ -->
<!-- ★★★★★ -->

	
		<c:forEach var="counta" begin="1" end="${param.age }">
			<div>
				<c:forEach var="countb" begin="1" end="${counta }">★</c:forEach>
			</div>
		</c:forEach>
		
		<c:forEach var="counta" begin="1" end="${param.age }">
			<c:forEach var="countb" begin="1" end="${counta }">★</c:forEach>
			<br>
		</c:forEach>

</body>
</html>