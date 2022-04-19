<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 페이지</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
// 		System.out.println("id = [" + id + "]");
// 		System.out.println("id =>" + id.length());
		
// 		System.out.println("pw = [" + pw + "]");
		
	%>
	<%
		if(id.length() == 0 || pw.length() == 0){
	%>
			<div>
				아이디 또는 비밀번호를 확인하세요
			</div>
	<%
		}else{
			// 로그인 처리를 위한 DB 조회 및 기타 코드는 생략
			// request.getAttribute 쓸필요없음 
			
			session.setAttribute("isLogin", true);
			session.setMaxInactiveInterval(60);
	%>
	<div>
		사용자가 입력한 아이디 : <%= id %> <br>
		사용자가 입력한 비밀번호 : <%= pw %>
	</div>
	<%
		}
	%>

</body>
</html>