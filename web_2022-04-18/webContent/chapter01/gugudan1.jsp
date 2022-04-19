<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스크립트릿 태그로 구구단3단 출력</h1>
<!-- 	이처럼 나눌수도 있음 -->
	<%
		for(int back=1; back<=9; back++){
			int result = 2 * back;
	%>	

		<div>2 * <%=back %> = <%=result %></div>

	<%
		}
	%>
</body>
</html>