<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String failMessage = (String) request.getAttribute("fail");
// 	fail안에 null이 담기기에 

	boolean isLogin = false;

	try{
		isLogin = (boolean) session.getAttribute("isLogin");
	}catch(NullPointerException e){
		// 로그인을 하지 않은 사용자의 경우 예외가 발생함
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<%
		if(failMessage != null){
			
	%>
		<div>
			아이디 또는 비밀번호를 입력하세요
		</div>
	<%	} else{
		
			if(!isLogin){
	%>	
				<form action="/web_2022-04-18/chapter01/loginProc.jsp" method="POST">
				<label>ID : <input type="text" name="id" placeholder="아이디"> </label>
				<br>
				
				<label>PW : <input type="password" name="pw" placeholder="비밀번호"> </label>
				<br>
				
				<input type="submit" value="로그인">
				</form>
		
	<%
			} else{
	%>
			<h1>로그인을 한 상태이군요!</h1>
			<a href="#">로그아웃</a>
	<%
			}
		}
	%>
		
		

	
		
	
	
</body>
</html>