<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/URLConfig.jsp" %>

<!-- 로그인을 하지 않아서 세션에 userLevel 없을 경우 userLevel 변수에는 아무것도 저장되지 않는다 -->
<!-- 정확하게는 userLevel에는 빈 문자열("") 이 저장됨 -->
<c:set var="userLevel" value="${sessionScope['userLevel'] }" />
<c:if test="${userLevel ne 'admin' }" >
	<c:redirect url="/main" />
</c:if>


<!-- 권한이 있는 사용자만 이 페이지를 이용할수 있게 해야함 -->
<%
// try {
// 	String userLevel = (String) session.getAttribute("userLevel");
	
// 	// 로그인하지않은 사용자가 Null로 공지사항쓰기로 접근 -> Null -> 예외처리
// 	if(userLevel.equals("admin")) {
// 		// 권한이 있는 사용자가 접근했을 때 공지사항 쓰기 페이지가 보이도록 하려면 가만히 있으면됨
// // 		RequestDispatcher rd = request.getRequestDispatcher("/notice/form.html");
// // 		rd.forward(request, response);
// 	}else {
// 		// 권한이 없는 사용자가 접근했을때는 메인 페이지가 보이도록
// 		response.sendRedirect("/web_31/main");
// 	}
// }catch(NullPointerException e) {
// 	// 로그인을 하지 않은 사용자가 접근했을 때 메인 페이지가 보이도록
// 	response.sendRedirect("/web_31/main");
// }
%>
<!-- 스크립트릿을 사용한 자바코드를 jstl 코드로 바꿔야함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Project</title>
<link rel="stylesheet" href="/web_31/css/header.css">
<link rel="stylesheet" href="/web_31/css/footer.css">
<link rel="stylesheet" href="/web_31/css/notice_form.css">
</head>
<body>
	
	<%@ include file="../includes/header.jsp" %>
	
	<div id="wrapper">
        <h2>공지사항</h2>

		<form action="${SERVLET_NOTICE_WRITE }" method="POST">
			<div id="title_wrapper">
				<label>제목&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="title"></label>
			</div>
			
			<div id="contents_wrapper">
				<label>내용<br><textarea name="contents" cols="100" rows="10"></textarea> </label>
			</div>
			
			<div>
				<label>첨부파일 : <input type="file" name="file"></label>
			</div>

	        <div id="btn_wrapper">
	            <button type="submit">공지사항 작성</button>
	        </div>
        </form>
	</div>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
</body>
</html>