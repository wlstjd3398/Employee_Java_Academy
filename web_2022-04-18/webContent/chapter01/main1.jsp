<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 선언문 태그 : 변수나 메서드를 선언할 수 있는 태그 --%>
<%-- 선언문 태그에는 선언문만 올 수 있음 --%>

<%!

	String user;
	int hour = 13;
	public int sum(int num1, int num2){
		return num1 + num2;
	}
	
	
// 	if(hour != 13){
// 		user = "Hello"
// 	}else{
// 		user = "안녕하세요";
// 	} 선언코드는 올수있지만 실행코드는 못옴

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp" %>

	<main>main1.jsp의 main 컨텐츠</main>

	<%@ include file="footer.jsp" %>
	
</body>
</html>