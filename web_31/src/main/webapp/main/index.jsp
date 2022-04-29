<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file="../includes/URLConfig.jsp" %>

<%-- LOGOUT_URL = ${LOGOUT_URL } --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Project</title>
<link rel="stylesheet" href="/web_31/css/header.css">
<link rel="stylesheet" href="/web_31/css/footer.css">
<link rel="stylesheet" href="/web_31/css/main_index.css">

<script src="/web_31/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="../includes/header.jsp" %>
	
	<main>
		<div id="notice_title">
			<h2>공지사항</h2>
			<a href="${PAGE_NOTICE_LIST}"> [ 더보기 ] </a>
		</div>
		
		<!-- <div id="notice_list">공지사항이 없습니다.</div>  -->
		
		<div id="notice_list">
		</div>
	</main>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	<script type="text/javascript">
		// 공지사항 목록을 불러와 보여줄 ajax
		$.ajax({
			url: "${SERVLET_NOTICE_LIST}",
			type: "GET",
			data: "pageNumber=1",
			dataType: "json",
			success: function(result) {
				// 서버가 전달해준 공지사항 목록의 제목과 내용들을 console.log를 사용해 모두 출력하세요.
				
				let noticeList = result.noticeList;
				
				for(let i=0; i<noticeList.length; i++) {
					let notice = noticeList[i];
					
					let noticeTag = "<div class=\"contents\">" +
                   						"<a href=\"${PAGE_NOTICE_DETAIL}?id="+ notice["id"] +"\">" +
                       						"<span class=\"title\"> " + notice["title"] + " </span>"
                   						"</a>" +
                					"</div>";
                					
                	$("#notice_list").append(noticeTag);
				}
				
			},
			error: function(response) {
				
				console.log("에러 동작!");
				
				console.log(response);
				
			}
		});
	</script>
</body>
</html>