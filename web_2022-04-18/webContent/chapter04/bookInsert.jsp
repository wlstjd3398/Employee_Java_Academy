<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 저장</title>
</head>
<body>

	<form action="/web_2022-04-18/chapter04/book_insert_process.jsp" method="POST">
		<p><label> 책제목 : <input type="text" name="title"></label></p>
		<p><label> 책 저자 : <input type="text" name="author"></label></p>
		<p><label> 출판사 : <input type="text" name="publisher"></label></p>
		
		<p><input type="submit" value="등록"></p>
	</form>

</body>
</html>