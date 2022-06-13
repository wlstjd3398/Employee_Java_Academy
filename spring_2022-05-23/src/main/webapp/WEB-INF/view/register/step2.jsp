<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(2)</title>
</head>
<body>
<!-- 스프링이 제공하는 form태그를 사용한 코드 에서는 RegistController-->
	<form:form action="/spring_2022-05-23/register/step3" modelAttribute="formData">
		<div>
			<label>이메일 : <form:input path="email" /></label>
		</div>
		<div>
			<label>이름 : <form:input path="name" /></label>
		</div>
		<div>
			<label>비밀번호 : <form:password path="password" /></label>
		</div>
		<div>
			<label>비밀번호 확인 : <form:password path="confirmPassword" /></label>
		</div>
		
		<input type="submit" value="가입 완료" >
	</form:form>


<%-- 	<form action="/spring_2022-05-23/register/step3" method="POST"> --%>
<!-- 		<div> -->
<%-- 			<label>이메일 : <input type="text" name="email" id="email" value="${formData.email }"> </label> --%>
<!-- 		</div> -->
		
<!-- 		<div> -->
<%-- 			<label>이름 : <input type="text" name="name" id="name" value="${formData.name }"> </label> --%>
<!-- 		</div> -->
		
<!-- 		<div> -->
<!-- 			<label>비밀번호 : <input type="password" name="password" id="password"> </label> -->
<!-- 		</div> -->
		
<!-- 		<div> -->
<!-- 			<label>비밀번호 확인 : <input type="password" name="confirmPassword" id="confirmPassword"> </label> -->
<!-- 		</div> -->
		
<!-- 		<input type="submit" value="가입 완료"> -->
<%-- 	</form> --%>

</body>
</html>