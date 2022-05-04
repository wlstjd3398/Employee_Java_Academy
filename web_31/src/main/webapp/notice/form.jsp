<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/URLConfig.jsp" %>

<!-- 권한이 있는 사용자만 이 페이지를 이용할 수 있어야함 -->
<%-- 로그인을 하지 않아서 세션에 userLevel 없을 경우 userLevel 변수에는 아무것도 저장되지 않는다. --%>
<%-- 정확하게는 userLevel에는 빈 문자열 ( "" ) 이 저장됨 --%>
<c:set var="userLevel" value="${sessionScope['userLevel'] }" />
<c:if test="${userLevel ne 'admin' }">
	<c:redirect url="/main" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Project</title>
<link rel="stylesheet" href="/web_31/css/header.css">
<link rel="stylesheet" href="/web_31/css/footer.css">
<link rel="stylesheet" href="/web_31/css/notice_form.css">
<script src="/web_31/js/jquery-3.6.0.min.js"></script>

</head>
<body>
	<%@ include file="../includes/header.jsp" %>
	
	<div id="wrapper">
        <h2>공지사항</h2>

		<form action="${SERVLET_NOTICE_WRITE }" method="POST" enctype="multipart/form-data">
			<div id="title_wrapper">
				<label>제목&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="title"></label>
			</div>
			
			<div id="contents_wrapper">
				<label>내용<br><textarea name="contents" cols="100" rows="10"></textarea> </label>
			</div>
			
			<div id="file_wrapper">
				<label>첨부파일 : <input type="file" name="file"></label>
			</div>

	        <div id="btn_wrapper">
	            <button type="submit">공지사항 작성</button>
	        </div>
        </form>
	</div>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	<script>
		// javascript만으로는 힘들 + jquery
		// id 파라미터에 들어있는 값을 꺼낸다
		let parameters = location.search;
		parameters = parameters.substr(1, parameters.length);
		parameters = parameters.split("=");
		
		let id = parameters[1];
		
		// id 파라미터에 값이 들어있다면은
		if(id != undefined){
			$("#btn_wrapper button").text("공지사항 수정");
			
// 			$("form").attr("action", "${SERVLET_NOTICE_UPDATE}");
			// form 태그를 통해서 수정요청이 안들어가기에 위 코드 필요없음
			
			$("#btn_wrapper button").attr("type", "button");
			$("#btn_wrapper button").on("click", function(){
				
				let title = $("input[name=title]").val();
				let contents = $("textarea").val();
				
				// GET, POST, PUT ,DELETE Method
				// 위 4 호출방식을 이해하고 적절히 사용해서 프로그램을 구현하는 걸 
				// Restful API라고 함
				// 자바스크립트를 발전 시키는 단체에서 Restful API를 활용할 수 없게
				// 자바스크립트를 업데이트를 했음
				// 스프링을 사용하면 우회를 해서 Restful API를 활용할 수 있음
				// JSP, Servlet만 사용하면 Restful API를 활용할수 없음
				
				
				$.ajax({
					url: "${SERVLET_NOTICE_UPDATE}",
					type: "POST",
					data: "id="+id+"&title=" + title + "&contents=" + contents,
					success: function(){
						// 공지사항을 성공적으로 수정했다면
						alert("수정했습니다.");
						location.href = "${PAGE_NOTICE_DETAIL}?id="+id;
					},
					error: function(){
						// 공지사항을 수정하지 못했다면(일반적인 경우에는 수정하지 못하는 경우는 없으므로 코드 생략)						
					
					}
				});
			});
			
			// id에 맞는 공지사항 정보(제목, 내용, 첨부파일)을 가져온다
			$.ajax({
				url: "${SERVLET_NOTICE_INFO}",
				type: "GET", 
				// get으로 조회를 한다(post, put, delete 아님)
				data: "id=" +id,
				dataType: "text",
				success: function(noticeInfo) {
					
					noticeInfo = noticeInfo.replace(/\r/g, "\\r");
					noticeInfo = noticeInfo.replace(/\n/g, "\\n");
					
					noticeInfo = JSON.parse(noticeInfo);
					
					// 위에서 보면 title, contents의 name을 가진것을 불러옴
					let $title = $("input[name=title]");
					let $contents = $("textarea");
					
					$title.val(noticeInfo.title);
					$contents.val(noticeInfo.contents);
					
					// 첨부 파일이 있는 공지사항일 경우
					if(noticeInfo.filePath != 'null'){
						// type이 file인 input 태그를 삭제하고
						$("input[type=file]").remove();
						
						// 그 자리에 대신 첨부파일의 이름을 표시하는 span 태그를 넣고
						// filePath는 파일의 이름이 아닌 경로를 갖고있으므로 적절히 활용해서 이름이 출력되도록 해야함
						$("#file_wrapper label").append("<span>" + noticeInfo.filePath + "</span>");
						
						// [삭제] button 태그를 넣으세요
						$("#file_wrapper label").append("<button type=\"button\">삭제</button>");
						
						// 첨부파일이 있는 공지사항일 때 첨부파일 삭제 button 태그를 클릭하면 
						// 해당 공지사항의 첨부파일을 삭제 처리하는 서블릿을 호출
						$("#file_wrapper button").on("click", function(){
							$.ajax({
								url: "${SERVLET_NOTICE_FILE_DELETE}",
								type: "POST",
								data: "id=" + id,
								success: function(){
									// 해당 공지사항의 첨부파일을 성공적으로 삭제했을 경우
									
									$("#file_wrapper span").remove();
									$("#file_wrapper button").remove();
									$("#file_wrapper label").append("<input type=\"file\" name=\"file\">");
								},
								error: function(){
									// 해당 공지사항의 첨부파일을 삭제하지 못했을 경우
									
								}
							});
						});
					}
				},
				error: function(responseInfo){
					console.log(responseInfo);
					
				}
			});			
			// 가져온 공지사항의 정보를 화면에 출력한다
			
			
			
		}
		
		
		
		
		
	</script>
</body>
</html>