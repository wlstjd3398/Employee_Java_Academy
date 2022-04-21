<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 배열 -->
<%-- 	<c:set var="index" value="0" /> --%>
<%-- 	<c:forEach items="${arr }" var="item" > --%>
<%-- 		<p>arr[${index}] => ${item }</p> --%>
<%-- 		<c:set var="index" value="${index + 1 }" /> --%>
<%-- 	</c:forEach> --%>
	
<!-- 	<!-- 	인덱스변수를 생성안해도 varStatus생성해서 인덱스번호를 만들어줄수있음 -->
<%-- 	<c:forEach items="${arr }" var="item" varStatus="status"> --%>
<%-- 		<p>arr[${status.index}] => ${item }</p> --%>
<%-- 	</c:forEach> --%>




<!-- 컬렉션프레임워크 리스트 -->
	<c:forEach items="${bookList }" var="book" varStatus="status">
		<h1>${status.count }번째 도서 정보</h1>
		<p>제목 => ${book.title }</p>
		<p>저자 => ${book.author }</p>
		<p>출판사 => ${book.publisher }</p>
	</c:forEach>

</body>
</html>