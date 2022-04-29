<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/URLConfig.jsp" %>

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
            </div>
        </div>
	</div>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	<script>
		// 공지사항 목록의 페이지네이션을 구성할 ajax
		// ajax가 공지사항의 전체 개수를 받아와서
		// 전체 개수를 사용해서 적절히 페이지네이션을 출력
		$.ajax({
			url: "${SERVLET_NOTICE_AMOUNT}",
			type: "GET",
			success: function(amount){
				
				let roofCount = Math.ceil(amount / 5);
				
				for(let i=1; i<=roofCount; i++){
					// 페이지네이션 출력
					$(".pagination").append("<a href=\"${PAGE_NOTICE_LIST}?pageNumber=" + i + "\"> <span>" + i + "</span> </a>");
					
					
				}
			},
			error: function(){
				
				
			}
		});
		
		let getParameters = location.search.substr(1, location.search.length);
		let pageNumber = 1;
		if(getParameters != ''){
			getParameters = getParameters.split("=");
			
			pageNumber = getParameters[1];
			
		}
		
		
		
		
		// 공지사항 목록을 불러와 보여줄 ajax
		$.ajax({
			url: "${SERVLET_NOTICE_LIST}",
			type: "GET",
			data: "pageNumber=" + pageNumber,
			dataType: "json",
			success: function(result) {
				// 서버가 전달해준 공지사항 목록의 제목과 내용들을 console.log를 사용해 모두 출력하세요.
				
// 				console.log(result); // 그대로 가져오는지 확인하기
				
				let noticeOrder = result.amount - ( (pageNumber-1) * 5 );
				
				let noticeList = result.noticeList;
				
				for(let i=0; i<noticeList.length; i++) {
					let notice = noticeList[i];
					
					let noticeTag = "<div class=\"contents\">" +
                    					"<span class=\"order\">" + noticeOrder + "</span>" +
                    						"<a href=\"${PAGE_NOTICE_DETAIL}?id=" + notice["id"] + "&pageNumber=" + pageNumber + "\">" +
                        						"<span class=\"title\"> " + notice["title"] + " </span>"
                    						"</a>" +
                					"</div>";
                					
                	$("#list").append(noticeTag);
                	
                	noticeOrder--;
				}
				
			},
			error: function(response) {
				
				console.log("에러 동작!");
				
				console.log(response);
				
			}
		});
		// 공지사항 작성 버튼에서 사용할 ajax
	</script>
</body>
</html>