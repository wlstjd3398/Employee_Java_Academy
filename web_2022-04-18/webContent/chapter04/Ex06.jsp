<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 	EL을 통해서 변수에 접근하면 request, session, application 순서로 이름을 찾음 -->
	<p>로그인한 사용자의 ID => ${ sessionScope.id }</p>

</body>
</html>