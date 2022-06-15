<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(1)</title>
</head>
<body>

	<h2> <spring:message code="term" /> </h2>
	<p>약관내용</p>
<!-- 	action에서 step2라고만 입력하면 현재 URL기준으로 마지막 부분만 적용하게됨 -> URL명확히 파악하기 위해 -->
	<form action="/spring_2022-05-23/register/step2" method="POST">
		<label>
			<input type="checkbox" name="agree" value="true"> <spring:message code="term.agree"/>
		</label>
		
		
		<input type="submit" value="<spring:message code="next.btn" />">
<!-- 		다음 단계를 누르면 agree라는 이름을 가지고 action으로 이동 -->
	</form>

</body>
</html>