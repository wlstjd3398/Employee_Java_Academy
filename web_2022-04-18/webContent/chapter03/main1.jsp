<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = request.getParameter("url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%@ include file="header.jsp" %> --%>
<!-- 	지시자태그에서 표준액션태그로 바꿈 -->

<%-- 	<jsp:include page="header.jsp"> --%>
	
	<jsp:include page="<%= url %>">
		<jsp:param value="user" name="user"/>
	</jsp:include>

	<main>main1.jsp의 main 컨텐츠</main>

	<jsp:include page="footer.jsp"/>
	
</body>
</html>