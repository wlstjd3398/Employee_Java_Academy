<%@page import="bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookBean book = (BookBean) request.getAttribute("book");

	System.out.println(book.getTitle() );
	System.out.println(book.getAuthor() );
	System.out.println(book.getPublisher() );
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 출력</title>
</head>
<body>
	
	
<%-- 	${requestScope["book"]["title"] } --%>
<!-- 	위 부분을 아래처럼 쉽게 나타내었음 -->
	
<!-- 	EL에서 변수 이름을 사용하면 먼저 request 안에서 book 이름을 찾음 -->
<!-- 	request 안에서 book 이름을 찾았으면 그 이름에 들어있는 값을 사용 -->
<!-- 	request 안에서 book 이름을 찾지 못했으면 session으로 넘어가서 book 이름을 찾음 -->
<!-- 	session 안에서 book 이름을 찾았으면 그 이름에 들어있는 값을 사용 -->
<!-- 	session 안에서 book 이름을 찾지 못했으면 application으로 넘어가서 위와 같이 동작 -->
<!-- 	request -> session -> application -->

	<p>책 제목 : ${book.title }</p>
	<p>책 저자 : ${book.author }</p>
	<p>출판사 : ${book.publisher }</p>
	
</body>
</html>