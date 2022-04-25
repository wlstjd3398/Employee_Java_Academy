<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<form action="/web_2022-04-25/member/login" method="POST">
		<div> <label> ID : </label> <input type="text" name="id" placeholder="아이디"> </div>
		<div> <label> PW : </label> <input type="password" name="pw" placeholder="비밀번호"> </div>
		
		<input type="submit" value="로그인">
	</form>

</body>
</html>