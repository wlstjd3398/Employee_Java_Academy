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
        <link rel="stylesheet" href="../css/product_form.css">
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
                  <div class="col-lg">
                    <form action="/shoppingmall/product/update" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="productId" value="${param.idx }">
                        
                        <div class="input-group input-group-lg" id="product_name_wrapper">
                            <span class="input-group-text" id="inputGroup-sizing-lg">상품명</span>
                            <input type="text" class="form-control" id="product_name" aria-label="Sizing example input" name="name" aria-describedby="inputGroup-sizing-lg">
                        </div>

                        <div class="input-group" id="product_category_wrapper">
                            <label class="input-group-text" for="inputGroupSelect01">카테고리</label>
                            <select class="form-select" id="inputGroupSelect01" name="category">
                              <option value="smartphone">스마트폰</option>
                              <option value="notebook">노트북</option>
                              <option value="tablet">테블릿</option>
                            </select>
                        </div>

						<div class="input-group" id="product_price_wrapper">
                            <span class="input-group-text">가격</span>
                            <input type="number" class="form-control" id="product_price" aria-label="Sizing example input" name="price" aria-describedby="inputGroup-sizing-sm">
                        </div>
                        
                        <div class="input-group" id="product_price_wrapper">
                            <span class="input-group-text">재고</span>
                            <input type="number" class="form-control" id="product_stock" aria-label="Sizing example input" name="stock" aria-describedby="inputGroup-sizing-sm">
                        </div>

                        <div class="input-group" id="product_file_wrapper">
                            <label class="input-group-text" for="inputGroupFile01">상품 이미지</label>
                            <input type="file" class="form-control" id="inputGroupFile01" name="img">
                            
                        </div>

                        <div class="input-group" id="product_content_wrapper">
                            <span class="input-group-text">상품 소개</span>
                            <textarea class="form-control" aria-label="With textarea"></textarea>
                        </div>
                        
                        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                      		<button type="submit" class="btn btn-primary btn-lg px-4 me-md-2" id="update_btn">상품 수정</button>
                   		</div>
                    </form>
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
        <script src="../js/scripts.js"></script>
        <script src ="../js/jquery-3.6.0.min.js"></script>
        <script src="../js/functions.js"></script>
        <script>
        	let idx = getParameter("idx");
        	
        	$("#update_btn").on("click", function(event){
        		event.preventDefault();
        		
        		let $name = $("#product_name");
        		let $category = $("#inputGroupSelect01");
        		let $price = $("#product_price");
        		let $stock = $("#product_stock");
//         		let $img = $("#inputGroupFile01");
        		
        		let name = $name.val();
        		let category = $category.val();
        		let price = $price.val();
        		let stock = $stock.val();
//         		let img = $img;
        		
        		// ajax를 통해서 상품 수정 요청이 들어가도록
        		$.ajax({
        			url: "/shoppingmall/product/update",
        			type: "POST",
        			data: "productId="+idx+"&name="+name+"&category="+category+"&price="+price+"&stock="+stock,
        			success: function(){
        				// 상품 정보가 수정됐을 경우
        				alert("상품 정보를 수정했습니다.");
        				location.href = "/shoppingmall/shop/product_detail.jsp?active=product_detail&idx="+idx;
        			},
        			error: function(){
        				// 상품 정보가 수정하지 못했을 경우
        				alert("상품 정보를 수정하지 못했습니다.");
        			}
        		});
        	});
        	
        		$.ajax({
        			url: "/shoppingmall/product/detail",
        			type: "GET",
        			data: "productId="+idx,
        			success: function(productInfo){
        				// 상품 명 출력 input태그라 text말고 val로
        				$("#product_name").val(productInfo.name);
        				
        				// 상품 카테고리 출력
        				// 이 상품의 카테고리에 맞게 select 태그의 옵션이 자동으로 선택되게 하려면? 
      					// 검색하는 방법
        				// inputGroupSelect01 을 불러와서
        				if(productInfo.category == "스마트폰"){
        					$("#inputGroupSelect01").val("smartphone").prop("selected", true);
        					
        				}else if(productInfo.category == "노트북"){
        					$("#inputGroupSelect01").val("notebook").prop("selected", true);
        					
        				}else if(productInfo.category == "테블릿"){
        					$("#inputGroupSelect01").val("tablet").prop("selected", true);
        				}
        				
        				// 상품 가격 출력
        				$("#product_price").val(productInfo.price);
        				
        				// 상품 재고 출력
        				$("#product_stock").val(productInfo.stock);
        				
        				// 상품 이미지 출력
        				// 상품에 등록된 이미지가 있을 경우
        				// 이미지의 경로만 출력하고 이미지 경로 옆에 이미지 삭제 버튼을 추가
        				if(productInfo.img != null){
        					$("#inputGroupFile01").css("display", "none");
        					
        					$("#product_file_wrapper").append("<span class=\"product_file_path\">" + productInfo.img + "</span>");
        					$("#product_file_wrapper").append("<button type=\"button\" class=\"btn btn-secondary btn-lg px-4 me-md-2\" id=\"img_delete_btn\">삭제</button>");
        					
        					$("#img_delete_btn").on("click", function(){
        						deleteImg();
        					});
        				}
        			},
        			error: function(response){
        				
        				console.log(response);
        			}
        		});
        		
        		function deleteImg() {
        			// 이미지 삭제
					$.ajax({
						url: "/shoppingmall/product/img/delete",
						type: "POST",
						data: "productId="+idx,
						success: function(){
							alert("상품 이미지를 삭제했습니다.");
							$("#product_file_wrapper .product_file_path").remove();
							$("#img_delete_btn").remove();
							
							$("#inputGroupFile01").css("display", "initial");
							// 위 세가지를 안하고 새로고침을 하면 나름? 편법?으로 수정됨
							
							// location.reload();
						},
						error: function(){
							alert("상품의 이미지를 삭제하지 못했습니다.");
						}
					});
        		}
        		
        		
        		$("#inputGroupFile01").on("change", function(){
        			console.log("파일을 선택 또는 선택하지 않음");
        			
        			// 사용자가 선택한 파일을
        			// 파일 업로드 서비스를 사용해서 업로드를 한다
        			
        			// 페이지 새로고침을 한다
        			
        		});
        		
        </script>
    </body>
</html>
