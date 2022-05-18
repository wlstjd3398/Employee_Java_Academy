<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>두두몰</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        <link href="../css/logo.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <%@ include file="../includes/header_nav.jsp" %>
        
        <!-- Header-->
        <%@ include file="../includes/header.jsp" %>
        
        <!-- Section-->
        <section class="py-5">
            <div class="container col-xxl-8 px-4 py-5">
                <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
                  <div class="col-10 col-sm-8 col-lg-6">
                    <img src="#" class="d-block mx-lg-auto img-fluid" id="product_image" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
                  </div>
                  <div class="col-lg-6">
                    <h1 class="display-5 fw-bold lh-1 mb-3" id="product_name">상품명 / Responsive left-aligned hero with image</h1>
                    <p class="lead">상품 소개 / Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
                    <p class="lead" id="product_category">카테고리 / 노트북</p>
                    <p class="lead" id="product_price">가격 / 1,200,000원</p>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                    
      				<button type="button" class="btn btn-primary btn-lg px-4 me-md-2" id="buy_btn">구매 하기</button>
                      
					<%-- 로그인이 되어있고 관리자로 로그인을 했다면 --%>
					<c:if test="${loginUserInfo ne null and loginUserInfo.id eq 'Admin1234' }">
					  <button type="button" class="btn btn-secondary btn-lg px-4 me-md-2" id="update_btn">상품 수정</button>
                      <button type="button" class="btn btn-danger btn-lg px-4 me-md-2" id="delete_btn">상품 삭제</button>
					</c:if>
                    
                    
                    </div>
                  </div>
                </div>
              </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        
        <script src="../js/jquery-3.6.0.min.js"></script>
         <script src="../js/functions.js"></script>
        
        <%-- 로그인이 되어있지 않다면 --%>
		<c:if test="${loginUserInfo eq null }">
		<script>
			$("#buy_btn").on("click", function() {
				location.href = "/shoppingmall/login/login.jsp";
			});
		</script>
		</c:if>
		<%-- 로그인이 되어있다면 --%>
		<c:if test="${loginUserInfo ne null}">
		<script>
			$("#buy_btn").on("click", function() {
				alert("구현 예정 중인 기능입니다.");
			});
		</script>
		</c:if>
        
        <script>
	   		// idx를 꺼내오기 javascript로 꺼내기 쉽게 함수화 할것임
	      	let idx = getParameter("idx");
	   		
	   		
	   		
	   		
	   		$("#update_btn").on("click", function(){
	   			location.href = "/shoppingmall/manager/product_form2.jsp?active=product_update&idx="+idx;
	   		});
        </script>
        
        <script>
        	$("#delete_btn").on("click", function(){
        		$.ajax({
        			url: "/shoppingmall/product/delete",
        			type: "POST",
        			data: "productId="+idx,
        			success: function(){
        				alert("상품을 삭제했습니다.");
        				location.href= "/shoppingmall/shop/product_list.jsp?active=product_list&pageNumber=1";
        			}
        		});
        	});
        </script>
        
        <script>
        	$.ajax({
        		url: "/shoppingmall/product/detail",
        		data: "GET",
        		data: "productId="+idx,
        		success: function(productInfo){
        			let $productName = $("#product_name");
        			let $productCategory = $("#product_category");
        			let $productPrice = $("#product_price");
        			let $productImage = $("#product_image");
        			
        			$productName.text(productInfo.name);
        			$productCategory.text(productInfo.category);
        			$productPrice.text(productInfo.price);
        			$productImage.attr("src", "/shoppingmall/images/product/" + productInfo.img);
        			
        		},
        		error: function(response){
        			console.log(response);
        		}
        	});
        </script>
    </body>
</html>
