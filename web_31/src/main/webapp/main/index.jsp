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
<%-- 	${sessionScope } --%>
	
	<%@ include file="../includes/header.jsp" %>
	
	
	<main>
		<div id="notice_title">
			<h2>공지사항</h2>
			<a href="/project2/notice/list.html"> [ 더보기 ] </a>
		</div>
		
		<!-- <div id="notice_list">공지사항이 없습니다.</div> html주석 -->
		<div id="notice_list">
			
		</div>
	</main>
	
	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>
	
	
	<script type="text/javascript">
	$("#join_area > button").on("click", function(){
		location.href ="${JOIN_URL }";
	});
	
	//jquery를 ajax 사용하여 호출하게함, id,pw태그를 불러와야함
	$("#login_area > form > button").on("click", function(e){
		e.preventDefault();
		
		
		let $id = $("input[name=id]");
		let $pw = $("input[name=pw]");
		
		let id = $id.val();
		let pw = $pw.val();
		
		
		$.ajax({
			url: "${LOGIN_URL }",
			type: "POST",
			data: "id=" + id + "&pw=" + pw,
// 			dataType: "text" 일반적이라 생략가능
			dataType: "json",
			success: function(result){
				// 로그인 성공했을 때
				
				// 로그인 한 사용자의 이름 출력
// 				alert("로그인 성공! 사용자의 이름을 출력할 차례");
				$("#login_area").text(result.loginUserName + "님 환영합니다!");
				//닉넴만 노출시키게 하는게 아니라 회원가입버튼을 로그아웃버튼으로 바꿔줘야함
				
				
				$("#join_area button").text("로그아웃");
				//로그아웃기능을 아직 구현안됨 기존버튼off하고 logout눌렀을때 페이지이동구현
				$("#join_area > button").off("click");
				$("#join_area > button").on("click", function() {
					location.href ="${LOGOUT_URL}";
				});
				
				if(result.userLevel == "admin"){
					$("#join_area").prepend("<button type=\"button\" id=\"admin_notice_write\">공지사항 쓰기</button>");
					$("#admin_notice_write").on("click", function() {
						location.href = "${PAGE_NOTICE_FORM_URL}";
					});
				}
				
			},
			error: function(){
				// 로그인 실패했을 때
				
				// 서버에 문제가 생겼을때
				
				// 아무것도 하지 않음
				alert("아이디나 비밀번호를 확인해주세요!");
			}
		});
		
		
	});
	// submit버튼으로 form action 사용하지말고(기본동작을 없애주고) ajax를 사용하게 해야함
	// e.preventDefault(); 사용하면 위사항 적용됨
	
	
	// 공지사항 목록을 불러와 보여줄 ajax
		$.ajax({
			url: "${GET_NOTICE_LIST_URL }",
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
					                  	 " <a href=\"\">"+
					                    	    "<span class=\"title\">" + notice["title"] + "</span>" +
				                  	 		" </a>"+
				              		  "</div>";
				              		  
                //list.html에서 index.html가져올때 공지사항부분id가 다르기에 수정하면 그대로 보여짐
                //let noticeTag안에 번호를 없애기 위해 번호에 해당하는 span을 삭제
                $("#notice_list").append(noticeTag);
				}
				
			},
			error: function(response){
				
				console.log("에러 동작!");
				
				console.log(response);
				
			}
		});
	
	
	</script>
</body>
</html>