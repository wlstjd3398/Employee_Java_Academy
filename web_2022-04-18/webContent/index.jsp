<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="error/500.jsp"
    isELIgnored="true"
    import="java.time.LocalDateTime"
%>

<%
	String name = request.getParameter("user");
	
// 	char ch = name.charAt(0);

// 자바8부터는 Date, Calendar 잘안쓰고 아래것 씀
	LocalDateTime now = LocalDateTime.now();
	
	Random rand = new Random();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석입니다. 웹페이지에 노출되는 주석 / 컴퓨터가 해석만 하지 않을 뿐 --> 
	<%-- JSP 주석입니다. 웹페이지에 노출되지 않는 주석 / 역시나 컴퓨터가 해석하지 않음 --%>
	
	<strong>Welcome~!<%= request.getParameter("user") %> 님</strong>
	<p> 현재시간 : <%= now %> </p>
	
</body>
</html>