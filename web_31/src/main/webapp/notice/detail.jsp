<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



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
            <button type="button">목록으로</button>
        </div>
	</div>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	<script>
		let parameters = location.search;
		parameters = parameters.substr(1, parameters.length);
		parameters = parameters.split("=");
		let id = parameters[1];
	
	
		// 자바스크립트를 사용해서 GET 파라미터에 들어있는 id값을 꺼내서 ajax의 data에 사용하도록 하세요
		$.ajax({
			url: "${SERVLET_NOTICE_INFO}",
			type: "GET",
			data: "id=" + id,
			dataType: "JSON",
			success: function(noticeInfo){
				${"#title_wrapper span"}.text(noticeInfo.title);
				${"#contents_wrapper p"}.text(noticeInfo.contents);
			},
			error: function() {
				
			}
		});
	</script>
</body>
</html>