<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- active 파라미터의 값을 꺼낸다 -->
<%-- ${param.active } --%>
<!-- active 파라미터의 값이 home 이라면 -->

<!-- active 파라미터의 값이 product_list라면 -->

<c:set var="header_title" value="홈" />
<c:if test="${param.active eq 'product_list' }" >
	<c:set var="header_title" value="모든 상품" />
</c:if>

<header class="bg-dark py-5">
      <div class="container px-4 px-lg-5 my-5">
          <div class="text-center text-white">
              <h1 class="display-4 fw-bolder" id="header_title">${header_title}</h1>
              <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
          </div>
      </div>
</header>



<!-- <script src="../js/jquery-3.6.0.min.js"></script> -->
<!-- <script> -->
<!-- // 	let parameter = location.search; -->
<!-- // 	parameter = parameter.substr(1); -->
<!-- // 	parameter = parameter.split("="); -->
	
<!-- // 	if(parameter[1] == "home"){ -->
<!-- // 		// header_title 아이디를 사용하는 태그에 홈 텍스트를 출력 -->
<!-- // 		$("#header_title").text("홈"); -->
		
<!-- // 	}else if(parameter[1] == "product_list"){ -->
<!-- // 		// header_title 아이디를 사용하는 태그에 모든 상품 텍스트를 출력 -->
<!-- // 		$("#header_title").text("모든 상품"); -->
		
<!-- // 	} -->
<!-- </script> -->