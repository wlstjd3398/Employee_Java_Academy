<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- }에 컴파일 오류는 이클립스오류라 생각하고 진짜 컴파일오류는 위 파일모양에 표시가 떠야함 -->
	<p>값 : ${"EL은 표현언어라고 부릅니다." } </p>

	<p>연산자 : ${10 > 5 }</p>
	<!-- EL은 존재하지 않는 변수를 출력하는 경우에는 아무것도 출력하지 않음 -->
	<!-- EL을 통해서 접근할 수 있는 변수는 JSTL의 core 라이브러리로 생성한 변수만 접근할 수 있음 -->
<!-- 	그냥 name을 붙여서는 출력 안됨 -->
	<p>변수명 : <% out.print(name); %></p>
<!-- 	스크립트릿으로 사용 -->

</body>
</html>