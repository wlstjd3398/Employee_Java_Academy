<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
    
<!-- 클라이언트가 전달한 파라미터에서 도서의 데이터들을 꺼내서 저장 -->

<!-- 도서들의 정보를 꺼내고 -->
<jsp:useBean id="book" class="bean.BookBean" />
<jsp:setProperty property="*" name="book" />
<!-- 도서들의 정보 저장 -->
<%
	request.setAttribute("book", book);
%>
<!-- 도서들의 정보 보여줄 곳으로 이동 -->
<jsp:forward page="bookPrint.jsp" />


<!-- jsp는 기능을 만들진 않고 구조를 만듬 servlet이 기능을 담당함 -->


