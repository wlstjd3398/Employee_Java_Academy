<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

	<form:form modelAttribute="login">
		
		<form:select path="loginTypes" items="${loginTypes }" />
		
		<form:select path="loginTypes">
			<option value="">----- 선택 -----</option>
			<form:options items="${loginTypes }" />
		</form:select>
		
		
		<form:select path="loginTypes">
			<form:options value="일반회원"/>
			<form:options value="기업회원">기업</form:options>
			<form:options value="헤드헌터회원" label="헤드헌터"></form:options>
		</form:select>
		<select id="loginTypes" name="loginTypes">
			<option value="일반회원">일반회원</option>
			<option value="기업회원">기업회원</option>
			<option value="헤드헌터회원">헤드헌터회원</option>
		</select>
		
		
		<select  id="loginTypes" name="loginTypes">
			<option value="일반회원">일반회원</option>
			<option value="기업회원">기업회원</option>
			<option value="헤드헌터회원">헤드헌터회원</option>
		</select>
		
	</form:form>

</body>
</html>