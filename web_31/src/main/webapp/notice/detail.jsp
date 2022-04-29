<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/URLConfig.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Project</title>
<link rel="stylesheet" href="/web_31/css/header.css">
<link rel="stylesheet" href="/web_31/css/footer.css">
<link rel="stylesheet" href="/web_31/css/notice_detail.css">

<script src="/web_31/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	
	<%@ include file="../includes/header.jsp" %>
	
    <div id="wrapper">
        <h2>공지사항</h2>
		
		<hr>
		
		<div id="title_wrapper">
			<span>제목</span>
		</div>
		
		<hr>
		
		<div id="contents_wrapper">
			<p>내용</p>
		</div>
		
		<hr>
		
		<div id="file_wrapper">
			<img src="/web_31/images/img.png" alt=""><a href="#">첨부파일</a>
		</div>

        <div id="btn_wrapper">
            <button type="button" id="goList">목록으로</button>
            
            <c:if test="${(sessionScope.isLogin eq true) and (sessionScope.userLevel eq 'admin')}">
            
            </c:if>
            <button type="button" id="goUpdate">공지사항 수정</button>
            <button type="button" id="goDelete">공지사항 삭제</button>
        </div>
	</div>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	<script>
		// 자바스크립트를 사용해서 GET 파라미터에 들어있는 id값을 꺼내서 ajax의 data에 사용하도록 하세요
		let parameters = location.search;
		parameters = parameters.substr(1, parameters.length);
		parameters = parameters.split("&");
		
		let idParameters = parameters[0];
		let pageNumberParameters = parameters[1];
		
		idParameters = idParameters.split("=");
		pageNumberParameters = pageNumberParameters.split("=");
		
		let id = idParameters[1];
		let pageNumber = pageNumberParameters[1];
		
		
		$("#goList").on("click", function() {
			location.href = "${PAGE_NOTICE_LIST}?pageNumber="+pageNumber;
		});
		
		$("#goUpdate").on("click", function() {
			location.href = "공지사항 수정 페이지로 이동";
		});
		$("#goDelete").on("click", function() {
			$.ajax({
				url: "${SERVLET_NOTICE_DELETE}?id="+id,
				type: "DELETE",
// 				data: "id="+id, 이방법이 안되어서 url에 ?을 달아주어서 변경함
				success: function(){
					alert("공지사항을 삭제했습니다.");
					
					location.href= "${PAGE_NOTICE_LIST}";
				},
				error: function(){
					
				}
			})
			location.href = "${SERVLET_NOTICE_WRITE}";
		});
		
		$.ajax({
			url: "${SERVLET_NOTICE_INFO}",
			type: "GET",
			data: "id=" + id,
			dataType: "JSON",
			success: function(noticeInfo){
				$("#title_wrapper span").text(noticeInfo.title);
				$("#contents_wrapper p").text(noticeInfo.contents);
			},
			error: function() {
				
			}
		});
	</script>
</body>
</html>