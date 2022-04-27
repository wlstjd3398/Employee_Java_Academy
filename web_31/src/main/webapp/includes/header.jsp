<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div id="login_area">
	<!-- 		로그인을 한 상태라면 (loginUserName)님 환영합니다!를 출력하고 -->
	<!-- JSTL의 core 라이브러리를 사용하면 해결할수있음 -->
		<c:if test="${sessionScope.isLogin eq true }">
			${sessionScope.loginUserName }님 환영합니다!
		</c:if>
	
	<!-- 			로그인을 하지 않은 상태라면 로그인 form을 보여주도록하세요 -->
		<c:if test="${sessionScope.isLogin ne true }">
			<form action="${LOGIN_URL }" method="POST">
				<input type="text" name="id" placeholder="아이디">
				<input type="password" name="pw" placeholder="비밀번호">
				<button type="button">로그인</button>
			</form>
			<script>
				
			</script>
		</c:if>
	</div> 
	
	<c:set var="buttonText" value="회원가입" />
	<c:if test="${sessionScope.isLogin eq true }">
		<c:set var="buttonText" value="로그아웃" />
	</c:if>
	
	<div id="join_area">
		<c:if test="${sessionScope.isLogin eq true }">
			<c:if test="${sessionScope.userLevel eq 'admin' }">
				<button type="button" id="admin_notice_write">공지사항 쓰기</button>
				
				<script>
					$("#admin_notice_write").on("click", function(){
						location.href="${PAGE_NOTICE_FORM_URL }";
					});
				</script>
			</c:if>
			
			<button type="button">로그아웃</button>
		<!-- 			로그아웃 버튼 누르면 실행되는것 -->
			<script>
				$("#join_area > button").on("click", function(){
					location.href ="${LOGOUT_URL}";
				});
			</script>
		</c:if>
		
		<c:if test="${sessionScope.isLogin ne true }">
			<button type="button">회원가입</button>
		<!-- 			회원가입버튼을 누르면 실행되는 것 -->
			<script>
				$("#join_area > button").on("click", function(){
					location.href ="${JOIN_URL }";
				});
			</script>
		</c:if>
	</div>
</header>