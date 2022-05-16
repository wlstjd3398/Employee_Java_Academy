<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/URLs.jsp" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/join.css">
    <link href="../css/logo.css" rel="stylesheet" />
</head>
<body class="text-center">
    
  <main class="form-signin">
    <form action="${JOIN_SERVLET}" method="POST">
      <h1 class="h3 mb-3 fw-normal">
    	<i class="bi bi-hand-index-thumb" id="rightHandLogo"></i>
        <i class="bi bi-hand-index-thumb" id="leftHandLogo"></i>
        두두몰
      </h1>
  
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" placeholder="Id" name="id">
        <label for="floatingInput">아이디(이메일)</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pw">
        <label for="floatingPassword">비밀번호</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPasswordCheck" placeholder="Password" name="pwChk">
        <label for="floatingPassword">비밀번호 확인</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingName" placeholder="Name" name="name">
        <label for="floatingName">이름</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingTel" placeholder="Tel" name="tel">
        <label for="floatingName">연락처</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingAddr" placeholder="Addr" name="addr">
        <label for="floatingName">주소</label>
      </div>
      <div class="form-floating">
        <input type="email" class="form-control" id="floatingEmail" placeholder="Email" name="email">
        <label for="floatingName">이메일</label>
      </div>
      
      <script src="../js/jquery-3.6.0.min.js"></script>
      <script>
      
      </script>
      
      <div class="form-floating">
        <ul class="list-group">
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term1">
              <label class="form-check-label" for="term1">
                모든 약관 동의
              </label>
            </div>
          </li>
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term2">
              <label class="form-check-label" for="term2">
                이용 약관 동의
              </label>
            </div>
            <div class="terms">
              천하를 주는 반짝이는 착목한는 보이는 얼마나 설레는 때까지 품고 피다. 살 얼음에 공자는 무한한 있으며, 찾아 쓸쓸한 보내는 부패뿐이다. 그러므로 지혜는 보내는 그들은 운다. 우리는 하였으며, 작고 있는 얼마나 우리 같은 것은 살았으며, 끓는다. 그들은 보이는 그러므로 하는 인도하겠다는 보는 피부가 돋고, 웅대한 말이다. 열락의 대고, 가슴이 있는 돋고, 불어 부패뿐이다. 오직 천지는 바이며, 보배를 노년에게서 고행을 이는 행복스럽고 이상의 봄바람이다. 날카로우나 낙원을 희망의 끝에 아니더면, 사라지지 밥을 같이, 설레는 피다. 그들을 무엇을 따뜻한 갑 인생에 희망의 꽃 것이다.

              그들에게 커다란 열락의 풍부하게 스며들어 것이다. 설산에서 꾸며 남는 위하여서. 않는 열매를 끓는 같으며, 지혜는 것이다. 뜨고, 구하기 못할 그리하였는가? 굳세게 고동을 돋고, 끓는 있는가? 남는 아니더면, 뼈 이 같이, 석가는 이성은 그들은 것이다. 어디 주는 그림자는 실현에 평화스러운 장식하는 인도하겠다는 아니다. 우리 생의 풀밭에 얼마나 것이다. 있는 속잎나고, 못할 거친 튼튼하며, 것은 되는 있다. 인생을 따뜻한 천지는 인간의 뛰노는 이상이 날카로우나 눈에 봄바람이다. 오직 붙잡아 심장의 열락의 싹이 트고, 두손을 위하여 것이 있다.

              것은 미묘한 길을 크고 있으며, 커다란 풍부하게 있는가? 바로 그러므로 이는 그것은 못할 평화스러운 황금시대다. 그들은 그들을 예가 때까지 구할 무엇을 그들은 고동을 보라. 같이 그들은 풀이 대고, 끝까지 아니다. 그것은 인생의 트고, 전인 찬미를 무엇을 청춘 있다. 소금이라 사는가 우리 그들의 옷을 온갖 대한 힘있다. 그들은 그들의 품으며, 피고, 그들의 이것이다. 트고, 인생의 품에 심장의 있음으로써 인생에 가치를 것이다. 거선의 가는 현저하게 그들의 있는 위하여, 인류의 피다.
            </div>
          </li>
          <li class="list-group-item">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="term3">
              <label class="form-check-label" for="term3">
                개인정보 수집 및 이용 동의
              </label>
            </div>
            <div class="terms">
              천하를 주는 반짝이는 착목한는 보이는 얼마나 설레는 때까지 품고 피다. 살 얼음에 공자는 무한한 있으며, 찾아 쓸쓸한 보내는 부패뿐이다. 그러므로 지혜는 보내는 그들은 운다. 우리는 하였으며, 작고 있는 얼마나 우리 같은 것은 살았으며, 끓는다. 그들은 보이는 그러므로 하는 인도하겠다는 보는 피부가 돋고, 웅대한 말이다. 열락의 대고, 가슴이 있는 돋고, 불어 부패뿐이다. 오직 천지는 바이며, 보배를 노년에게서 고행을 이는 행복스럽고 이상의 봄바람이다. 날카로우나 낙원을 희망의 끝에 아니더면, 사라지지 밥을 같이, 설레는 피다. 그들을 무엇을 따뜻한 갑 인생에 희망의 꽃 것이다.

              그들에게 커다란 열락의 풍부하게 스며들어 것이다. 설산에서 꾸며 남는 위하여서. 않는 열매를 끓는 같으며, 지혜는 것이다. 뜨고, 구하기 못할 그리하였는가? 굳세게 고동을 돋고, 끓는 있는가? 남는 아니더면, 뼈 이 같이, 석가는 이성은 그들은 것이다. 어디 주는 그림자는 실현에 평화스러운 장식하는 인도하겠다는 아니다. 우리 생의 풀밭에 얼마나 것이다. 있는 속잎나고, 못할 거친 튼튼하며, 것은 되는 있다. 인생을 따뜻한 천지는 인간의 뛰노는 이상이 날카로우나 눈에 봄바람이다. 오직 붙잡아 심장의 열락의 싹이 트고, 두손을 위하여 것이 있다.

              것은 미묘한 길을 크고 있으며, 커다란 풍부하게 있는가? 바로 그러므로 이는 그것은 못할 평화스러운 황금시대다. 그들은 그들을 예가 때까지 구할 무엇을 그들은 고동을 보라. 같이 그들은 풀이 대고, 끝까지 아니다. 그것은 인생의 트고, 전인 찬미를 무엇을 청춘 있다. 소금이라 사는가 우리 그들의 옷을 온갖 대한 힘있다. 그들은 그들의 품으며, 피고, 그들의 이것이다. 트고, 인생의 품에 심장의 있음으로써 인생에 가치를 것이다. 거선의 가는 현저하게 그들의 있는 위하여, 인류의 피다.
            </div>
          </li>
        </ul>
      </div>

      <button class="w-100 btn btn-lg btn-secondary" type="submit" id="submit_btn">회원가입</button>
    </form>
  </main>
  
  <script src="../js/jquery-3.6.0.min.js"></script>
  <script src="../js/URLs.js"></script>
  
  <script>
  // 아무것도 입력하지 않고 회원 가입 버튼을 누르거나
  // 잘못된 값을 입력하고 회원 가입 버튼을 누를 수도 있으므로
  // 회원 가입 버튼을 눌렀을 때 자바스크립트에서 올바른 값을 입력했는지 아닌지
  // 				(입력값 검증)
  // 를 체크해서 올바른 값을 입력했을 경우에만 회원 가입 서블릿으로 데이터를 전달해줘야함
  // a태그와 submit버튼의 경우에는 기본적으로 가지고 있는 클릭했을 때 ~~행동해라 라는 이벤트가 부여되어있음
  // submit 버튼에 부여된 기본 클릭 이벤트 -> submit버튼을 감싸고 있는 form태그의 action 경로로 데이터를 보냄
  
  // 회원 가입 버튼을 눌렀을 때 submit 버튼에 부여된 기본 클릭 이벤트를 무시하고
  // 사용자가 입력한 값을 검증한 뒤에
  // 사용자가 모두 올바른 값을 입력했을 때만
  // submit 버튼에 부여된 기본 클릭 이벤트가 동작하도록 해야함
  
  // a태그에 부여된 기본 클릭 이벤트 -> href 경로로 데이터 보냄
  $("#submit_btn").on("click", function(event){
	 // submit 버튼에 부여된 기본 클릭 이벤트를 무시
	 event.preventDefault();
	 
// 	 alert("회원 가입 버튼의 기본 클릭 이벤트가 무시되었음");
	// 사용자가 입력한 값 검증
	// (회원 가입 서블릿에서 정규표현식으로 검증했듯이 자바스크립트의 정규표현식을 사용해서 검증)
	// 1. 아이디 검증
	let $id = $("#floatingInput");
	if($id.val() == ""){
		// 아이디를 입력하지 않았다면
		alert("아이디를 입력하세요");
		return false;
	}
	
	if($id.length() < 4 && $id.length() > 10){
		alert("아이디는 최소 4자, 최대 10자까지 입력 가능합니다.")
		return false;
	}
	
	correctId = $id.matches("^[a-zA-Z0-9]+$")
	if(!correctID){
		alert("영문 대소문자와 숫자로 이루어져야합니다.");
		return false;
	}
	
	// 2. 비밀번호 검증
	let $pw = $("#floatingPassword");
	if($pw.val() == ""){
		// 아이디를 입력하지 않았다면
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	// 3. 비밀번호 확인 검증
	let $pwChk = $("#floatingPasswordCheck");
	
	// 4. 이름 검증
	let $name = $("#floatingName");
	
	// 5. 연락처 검증
	let $tel = $("#floatingTel");
	
	// 6. 주소 검증
	let $addr = $("#floatingAddr");
	
	// 7. 이메일 검증
	let $email = $("#floatingEmail");
	
	let id = $id.val();
	let pw = $pw.val();
	let pwChk = $pwChk.val();
	let name = $name.val();
	let tel = $tel.val();
	let addr = $addr.val();
	let email = $email.val();
	// 사용자가 값을 모두 정상적으로 입력했다면
	// form 태그를 활용해서 submit을 하면 페이지 자체가 서블릿으로 이동하므로
	// ajax를 사용해서 현재 페이지에서 회원 가입 서블릿을 요청해서 회원 가입을 하고
	// 회원 가입 서블릿의 결과를 받아서 로그인 페이지로 이동하거나 안내 문구를 출력
// 	$("form").submit();
	
	
// 	console.log("id = " +id);
// 	console.log("pw = " +pw);
// 	console.log("pwChk = " +pwChk);
// 	console.log("name = " +name);
// 	console.log("tel = " +tel);
// 	console.log("addr = " +addr);
// 	console.log("email = " +email);
	
	$.ajax({
		url: JOIN_SERVLET,
		type: "POST",
		data: "id="+id+"&pw="+pw+"&pwChk="+pwChk+"&name="+name+"&tel="+tel+"&addr="+addr+"&email="+email,
		success: function(){
			// 회원 가입에 성공했을 경우
			alert("회원가입이 되었습니다. 로그인 페이지로 이동합니다.");
			
			location.href = LOGIN_PAGE;
		},
		error: function(response){
			// 회원 가입에 실패했을 경우
			
// 			console.log(response);
				
			// 의도만 이렇게 하고 일단 주석처리
// 			// 1. 아이디, 연락처, 이메일이 이미 사용중일때 : 409
			if(response.status == 409){
				alert("아이디, 이메일, 연락처 중 이미 사용중인 데이터가 있습니다.");
			}else if(response.status == 400){
				// 2. 파라미터가 규칙에 맞지 않을때 : 400
				alert("가입 정보를 올바르게 입력하세요");
			}
			
		}
	});
  });
  
  
	// 과제1
	// js jquery를 사용해서 
	// 1. 모든 약관 동의 체크 박스를 눌렀을 때 이용 약관 동의 ,
	// 개인 정보 수집 및 이용 동의 체크 박스가 체크되도록 하세요
	
	// 2. 모든 약관에 동의 했을 경우 회원 가입 버튼이 동작하도록 하세요
  $(".form-floating").on("click", "#term1", function(){
	  var checked = $(this).is(":cheked");
	  
	  let $term1Check = $("#term1");
	  let $term2Check = $("#term2");
	  let $term3Check = $("#term3");
	  
	  if(checked){
		  $term1Check.find('input').prop("checked", true);
	  }else{
		  $term1Check.find('input').prop("checked", false);
	  }
  });
  
//   .form-floating
//   .form-check
  
//   #term1
//   #term2
//   #term3
  $(".form-floating").on("click", ".normal", function() {
  var checked = $(this).is(":checked");
  if (!checked) {
  	$("#check_all").prop("checked", false);
  }
});
  
  </script>
  
  </body>
</html>
