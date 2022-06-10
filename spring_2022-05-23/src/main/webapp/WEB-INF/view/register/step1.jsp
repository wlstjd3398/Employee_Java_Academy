<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입(1)</title>
</head>
<body>

	<h2>약관</h2>
	<p>약관 내용</p>
<!-- 	action에서 step2라고만 입력하면 현재 URL기준으로 마지막 부분만 적용하게됨 -> URL명확히 파악하기 위해 -->
	<form action="/spring_2022-05-23/register/step2" method="POST">
		<label>
			<input type="checkbox" name="agree" value="true"> 약관 동의
		</label>
		
		
		<input type="submit" value="다음 단계">
<!-- 		다음 단계를 누르면 agree라는 이름을 가지고 action으로 이동 -->
	</form>

</body>
</html>