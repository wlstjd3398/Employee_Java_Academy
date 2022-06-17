<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.info" /></title>
</head>
<body>
<!-- 스프링이 제공하는 form태그를 사용한 코드 에서는 RegistController-->
	<form:form action="/spring_2022-05-23/register/step3" modelAttribute="formData">
<%-- 		<form:hidden path="agree" /> --%>
<!-- 		위 코드는 Spring이 제공하는 form 태그를 사용해서 hidden 태그를 생성 -->
<!-- 		위 코드가 실제졸 어떻게 변환될지 아래에 작성해보세요 -->
<%-- 		<input type="hidden" id="agree" name="agree" value="${formData.agree }"> --%>
		
		
		<div>
			<label><spring:message code="email" /> :
				<form:input path="email" />
				<form:errors path="email"/>
<%-- 				<form:errors path="email" element="" /> --%>
			</label>
		</div>
		<div>
			<label><spring:message code="name" /> : 
				<form:input path="name" />
				<form:errors path="name" />
			</label>
		</div>
		<div>
			<label><spring:message code="password" /> : 
				<form:password path="password" />
				<form:errors path="password" />
			</label>
		</div>
		<div>
			<label><spring:message code="password.confirm" /> : 
				<form:password path="confirmPassword" />
				<form:errors path="confirmPassword" />
			</label>
		</div>
		
		<input type="submit" value="<spring:message code="register.btn" />" >
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