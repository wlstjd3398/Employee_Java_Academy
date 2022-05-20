package buy;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyListDao;
import dao.ProductInfoDao;
import vo.BuyInfo;
import vo.MemberInfo;
import vo.ProductInfo;

@WebServlet("/buy")
public class BuyController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request.getParameter를 하기 전에 utf-8 설정을 해줘야 정상적으로 적용됨
//		System.out.println("utf-8 설정 전");
		request.setCharacterEncoding("utf-8");
//		System.out.println("utf-8 설정 후");
		
		if(request.getParameter("userId") == null || request.getParameter("productId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// userId 값을 알아내야함
		// 구매 인터페이스에서 로그인한 사용자의 id값을 사용해야하는데 

		// 로그인 정보를 기록하는 로그인 인터페이스에서 로그인한 사용자의 idx값은 저장하지 않음
		HttpSession session = request.getSession();
		MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		
//		System.out.println("utf-8 설정 전");
//		request.setCharacterEncoding("utf-8");
//		System.out.println("utf-8 설정 후");

		
		// 불러옴
		String paymentMethod = request.getParameter("paymentMethod");
		int userId = loginUserInfo.getIdx();
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductInfoDao productInfoDao = new ProductInfoDao();
		
		// 재고가 있다면 아래 쭉 진행
		// 재고가 없다면 상태코드 403 반환
		ProductInfo productInfo = productInfoDao.selectByIdx(productId);
		if(productInfo.getStock() <= 0) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		productInfoDao.decreaseStockById(productId);
		
		// dao 사용해서 
		BuyInfo buyInfo = new BuyInfo(paymentMethod, userId, productId, LocalDateTime.now());
		
		BuyListDao buyListdao = new BuyListDao();
		boolean result = buyListdao.insertBuyInfo(buyInfo);
		
		response.setStatus(HttpServletResponse.SC_OK);
		
	}

}