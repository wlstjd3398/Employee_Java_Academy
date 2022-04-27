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
<link rel="stylesheet" href="/web_31/css/notice_list.css">
<script src="/web_31/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="../includes/header.jsp" %>
	
	<div id="wrapper">
        <h2>공지사항</h2>

        <div id="notice_wrapper">
            <div id="title_info_wrapper">
                <span class="order">번호</span>
                <span class="title">제목</span>
            </div>
            <div id="list">
                
            </div>
            <div class="pagination">
                <span>1</span>
                <span>2</span>
                <span>3</span>
                <span>4</span>
            </div>
        </div>

        <div id="btn_wrapper">
            <button type="button">공지사항 작성</button>
        </div>
	</div>
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
<!-- 	ajax두개 리스트에서 로그인부분, 공지사항작성부분 -->
	
<!-- 	script type을 사용해서 javascript 쓰는 이유는 javascript를 쓴다라는 것을 인지시켜줌 -->
<!-- 	그러나 요즘은 생략해도 되는 추세 -->
	<script>
	//페이지가 실행되면서 동작하는 ajax라고 생각해야함
	//(submit버튼을 button으로 고쳐주고 Header.servlet에서 "하나가 빠져있어서 parsererror떴음)
		
		// 공지사항 목록을 불러와 보여줄 ajax
		$.ajax({
			url: "${SERVLET_NOTICE_LIST}",
			type: "GET",
			dataType: "json",
			success: function(result){
				// 서버가 전달해준 공지사항 목록의 제목과 내용들을 모두 console.log를 사용해 출력하세요
				// 웹페이지에 출력해야하니 console.log말고 태그들을 파악해서 올려야함
				// html, append, prepend 중 하나를 사용해서 웹페이지 올려야함
				let noticeList = result.noticeList;
				
				for(let i=0; i<noticeList.length; i++){
					let notice = noticeList[i];
					
					let noticeTag = "<div class=\"contents\">"+
					                   " <span class=\"order\">" + (i+1) + "</span>" +
					                  	 " <a href=\"\">"+
					                    	    "<span class=\"title\">" + notice["title"] + "</span>" +
				                  	 		" </a>"+
				              		  "</div>";
                
                $("#list").append(noticeTag);
				}
				
			},
			error: function(response){
				
				console.log("에러 동작!");
				
				console.log(response);
				
			}
		});
		
		
		// 공지사항 작성 버튼에서 사용할 ajax
		
	</script>

</body>
</html>