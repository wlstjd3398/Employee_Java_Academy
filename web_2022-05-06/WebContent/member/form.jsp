<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>두두몰</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="../css/join.css" />
    <link rel="stylesheet" href="../css/logo.css" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form>
      <h1 class="h3 mb-3 fw-normal">
    	<i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" placeholder="아이디" disabled>
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingOldPassword" placeholder="Password">
        <label for="floatingOldPassword">현재 비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingNewPassword" placeholder="Password">
        <label for="floatingNewPassword">새 비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingNewPasswordCheck" placeholder="Password">
        <label for="floatingNewPasswordCheck">새 비밀번호 확인</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingName" placeholder="Name">
        <label for="floatingName">이름</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingTel" placeholder="Tel">
        <label for="floatingTel">연락처</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingAddr" placeholder="Address">
        <label for="floatingAddr">주소</label>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingEmail" placeholder="Email" name="email">
        <label for="floatingEmail">이메일</label>
      </div>
      
      <button class="w-100 btn btn-lg btn-primary" type="button" id="update_btn">정보수정</button>
      <button class="w-100 btn btn-lg btn-secondary" type="button" id="delete_btn">회원 탈퇴</button>
    </form>
  </main>
  
  <script src="../js/jquery-3.6.0.min.js"></script>
  
  <script>
  // 탈퇴
  $("#delete_btn").on("click", function(){
	 $.ajax({
		 url: "/shoppingmall/member/delete",
	 	 type: "POST",
	 	 success: function(){
			// 회원 탈퇴 성공 시 ~~로 이동
	 		 location.href = "/shoppingmall/index.jsp";
	 	 },
	 	 error: function(){
	 		// 회원 탈퇴 실패 시
	 		alert("회원 탈퇴 실패");
	 		 
	 	 }
	 }); 
  });
  
  
  // 정보수정 버튼 실행시 (비밀번호 제외)
	  $("#update_btn").on("click", function(){
	  		 let $name = $("#floatingName");
			 let $tel = $("#floatingTel");
			 let $addr = $("#floatingAddr");
			 let $email = $("#floatingEmail");
			 
			 let name = $name.val();
			 let tel = $tel.val();
			 let addr = $addr.val();
			 let email = $email.val();
			 
		 $.ajax({
			url: "/shoppingmall/member/update",
			type: "POST",
			data: "name="+name+"&tel="+tel+"&addr="+addr+"&email="+email,
			success: function(){
				// 회원정보 수정이 됐다면 페이지 새로고침
				location.reload();
			},
			error: function(){
				// 회원 정보를 수정하지 못했다면
				alert("회원 정보 수정 실패");
			}
		 });
	  

  	
  	// 비밀번호 수정
  	let $oldPw = $("#floatingOldPassword");
  	let $newPw = $("#floatingNewPassword");
  	let $newPwChk = $("#floatingNewPasswordCheck");
  	
  	let oldPw = $oldPw.val();
  	let newPw = $newPw.val();
  	let newPwChk = $newPwChk.val();
  	
  	
  	if(oldPw.length != 0 && newPw.length != 0 && newPwChk.length != 0){
  		$.ajax({
  	  		url: "/shoppingmall/member/password/update",
  	  		type: "POST",
  	  		data: "oldPassword=현재밀번호&newPassword=새로운비밀번호&newPasswordChk=새로운비밀번호확인",
  	  		success: function(){
  	  			location.reload();
  	  			
  	  		},
  	  		error: function(){
  	  			alert("비밀번호 수정 실패");
  	  			
  	  		}
  	  	});
  	}
 });
  
  
  // 로그인한 사용자의 정보를 불러와 보여주는 ajax
  // 	사용자의 정보를 불러와 전달해주는 서블릿(어떤 사용자의 정보를 불러올지)
  //		-> 정보를 조회할 사용자의 idx가 필요
  // 	로그인한 사용자의 정보를 불러와 전달해주는 서블릿(로그인) 둘 중 선택해야함
  //		-> 로그인 상태 정보가 세션이나 쿠키에 저장되어있어야함
	  $.ajax({
		 url: "/shoppingmall/member/search",
		 type: "GET",
// 		 data: "JSON", 안써도 적용해줌
		 success: function(loginUserInfo){
			 let $id = $("#floatingInput");
			 let $name = $("#floatingName");
			 let $tel = $("#floatingTel");
			 let $addr = $("#floatingAddr");
			 let $email = $("#floatingEmail");
			 
			 $id.val(loginUserInfo.id);
			 $name.val(loginUserInfo.name);
			 $tel.val(loginUserInfo.tel);
			 $addr.val(loginUserInfo.addr);
			 $email.val(loginUserInfo.email);
			 
		 },
		 error: function(response){
			 
			 console.log(response);
			 
		 }
		 
	  });
  </script>
  
  </body>
</html>


