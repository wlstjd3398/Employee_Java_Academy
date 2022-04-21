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

<!-- 	전달 받은 나이를 사용해서 나이가 12세 이상이라면 "놀이기구 탑승 가능" 을 출력 -->
<!-- 	나이가 12세 미만이라면 "놀이기구 탑승 불가" 를 출력 -->

	<c:if test="${param.age < 12}">
		<p>놀이기구 탑승 불가</p>
	</c:if>
	
	<c:if test="${param.age >= 12}">
		<p>놀이기구 탑승 가능</p>
	</c:if>
	

</body>
</html>