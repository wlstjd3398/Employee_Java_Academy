<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row g-5">
                    <div class="col-md-5 col-lg-4 order-md-last">
                      <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">Your cart</span>
                        <span class="badge bg-primary rounded-pill">3</span>
                      </h4>
                      <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Product name</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$12</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Second product</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$8</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between lh-sm">
                          <div>
                            <h6 class="my-0">Third item</h6>
                            <small class="text-muted">Brief description</small>
                          </div>
                          <span class="text-muted">$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between bg-light">
                          <div class="text-success">
                            <h6 class="my-0">Promo code</h6>
                            <small>EXAMPLECODE</small>
                          </div>
                          <span class="text-success">−$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                          <span>Total (USD)</span>
                          <strong>$20</strong>
                        </li>
                      </ul>
              
                      <form class="card p-2">
                        <div class="input-group">
                          <input type="text" class="form-control" placeholder="Promo code">
                          <button type="submit" class="btn btn-secondary">Redeem</button>
                        </div>
                      </form>
                    </div>
                    <div class="col-md-7 col-lg-8">
                      <h4 class="mb-3">구매자 정보</h4>
                      <form class="needs-validation" novalidate="">
                        <div class="row g-3">
                          <div class="col-12">
                            <label for="firstName" class="form-label">이름</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
              
                          <div class="col-12">
                            <label for="firstName" class="form-label">연락처</label>
                            <input type="tel" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>

                          <div class="col-12">
                            <label for="firstName" class="form-label">주소</label>
                            <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
              
                          <div class="col-12">
                            <label for="firstName" class="form-label">이메일</label>
                            <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                            <div class="invalid-feedback">
                              Valid last name is required.
                            </div>
                          </div>
                        </div>
              
                        <hr class="my-4">
              
                        <div class="form-check">
                          <input type="checkbox" class="form-check-input" id="same-address">
                          <label class="form-check-label" for="same-address">구매자 정보와 주문자 정보가 동일합니다.</label>
                        </div>

                        <hr class="my-4">

                        <h4 class="mb-3">주문자 정보</h4>
                          <div class="row g-3">
                            <div class="col-12">
                              <label for="firstName" class="form-label">이름</label>
                              <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
                
                            <div class="col-12">
                              <label for="firstName" class="form-label">연락처</label>
                              <input type="tel" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
  
                            <div class="col-12">
                              <label for="firstName" class="form-label">주소</label>
                              <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
                
                            <div class="col-12">
                              <label for="firstName" class="form-label">이메일</label>
                              <input type="email" class="form-control" id="firstName" placeholder="" value="" required="">
                              <div class="invalid-feedback">
                                Valid last name is required.
                              </div>
                            </div>
                          </div>
              
                        <hr class="my-4">
              
                        <h4 class="mb-3">결제 방법</h4>
              
                        <div class="my-3">
                          <div class="form-check">
                            <input id="deposit" name="paymentMethod" type="radio" class="form-check-input" checked="" required="">
                            <label class="form-check-label" for="deposit">무통장입금</label>
                          </div>
                          <div class="form-check">
                            <input id="credit" name="paymentMethod" type="radio" class="form-check-input" required="">
                            <label class="form-check-label" for="credit">카드</label>
                          </div>
                        </div>
              
                        <hr class="my-4">
              
                        <button class="w-100 btn btn-primary btn-lg" type="submit" id="buy_btn">구매</button>
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
        <script src="../js/jquery-3.6.0.min.js"></script>
        <script src="../js/functions.js"></script>
        <script>
        	// productId에 들어있는 값을 전달
        	let id = getParamter("productId");
        
        $("#buy_btn").on("click", function(event){
        	event.preventDefault;
        	
        	let $deposit = $("#deposit");
        	
        	let paymentMethod;
        	
        	
        	if($deposit.prop("checked")){
        		// 무통장입금 라디오버튼을 선택했다면
        		paymentMethod = "무통장입금";
        	}else{
        		// 그렇지 않다면 (카드 라디오버튼을 선택했다면)
        		paymentMethod = "카드";
        	}
        	
        	$.ajax({
        		url: "/shoppingmall/buy",
        		type: "POST",
        		data: "productId="+id+"&paymentMethod="+paymentMethod,
        		success: function(){
        			alert("구매 성공!");
        			
        			location.href = "/shoppingmall/shop/product_list.jsp?active=product_list&pageNumber=1";
        		},
        		error: function(){
        			alert("재고가 부족합니다.");
        			
        		}
        	});
        });
        </script>
        
    </body>
</html>
