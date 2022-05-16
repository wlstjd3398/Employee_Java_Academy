<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/login.css">
    <link href="css/logo.css" rel="stylesheet" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form action="http://localhost:8080/shoppingmall/member/login" method="POST">
      <h1 class="h3 mb-3 fw-normal">
        <i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" placeholder="아이디" name="id">
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pw">
        <label for="floatingPassword">비밀번호</label>
      </div>
  
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> 아이디 기억하기
        </label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" id="login_btn" type="submit">로그인</button>
      <button class="w-100 btn btn-lg btn-secondary" id="join_btn" type="button">회원가입</button>
    </form>
  </main>
  
  <script src="../js/jquery-3.6.0.min.js"></script>
  <script src="../js/URLs.js"></script>
  
  <script>
  
  $("#login_btn").on("click", function(event){
	  // 클릭 했을때 submit 버튼의 기본 동작을 무시하고
	  // 내가 지정한 동작하게 함
	  event.preventDefault();
	  
	  let $id = $("#floatingInput");
	  let $pw = $("#floatingPassword");
	  
	  let id = $id.val();
	  let pw = $pw.val();
	  
	  $.ajax({
		 url: "http://localhost:8080/shoppingmall/member/login",
		 type: "POST",
		 data: "id="+id+"&pw="+pw,
		 success: function(){
			 // 로그인에 성공했을때
			 location.href="http://localhost:8080/shoppingmall/index.jsp";
		 },
		 error: function(response){
			 // 로그인에 실패했을때
			 if(response.status == 400){
				 alert("아이디와 비밀번호를 정확히 입력하세요.");
			 }else if(response.status == 401){
				 alert("아이디와 비밀번호를 확인하세요.");
			 }
		 }
	  });
	  
  });
  </script>
  
  </body>
</html>
