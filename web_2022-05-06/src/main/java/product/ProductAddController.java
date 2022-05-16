package product;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductInfoDao;
import exception.BadParameterException;
import util.ProductValidator;
import vo.ProductInfo;

@WebServlet("/product/add")
public class ProductAddController extends HttpServlet {
	
	private static final int MAXINUM_FILE_SIZE = 5 * 1024 * 1024; // 5MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// 1. 전달 받은 값을 꺼낸다(시작)
			String path = request.getRealPath("images/product");
			
			// 첨부 파일을 꺼내서 저장
			MultipartRequest mr = new MultipartRequest(request, path, MAXINUM_FILE_SIZE, "utf-8", new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			String category = mr.getParameter("category");
			
			if(mr.getParameter("stock") == null || mr.getParameter("price") == null) {
				throw new BadParameterException();
			}
			
			int stock = Integer.parseInt(mr.getParameter("stock"));
			int price = Integer.parseInt(mr.getParameter("price"));
			// img 파라미터에 담긴 파일을 저장했을 때 저장된 실제 파일의 이름
			String img = mr.getFilesystemName("img");
			LocalDateTime insertDate = LocalDateTime.now();
			// 1. 전달 받은 값을 꺼낸다(종료)
			
			// 2. 전달 받은 값을 검증한다
//			ProductValidator validator = new ProductValidator();
//			// 전달 받은 값 검증하는 코드는 직접 만들기
//			if(!validator.nameValidator(name))				throw new BadParameterException();
//			else if(!validator.categoryValidator(category))	throw new BadParameterException();
//			else if(!validator.stockValidator(stock))		throw new BadParameterException();
//			else if(!validator.priceValidator(price))		throw new BadParameterException();
//			else if(!validator.imgValidator(img))			throw new BadParameterException();
//					
			// 3. 전달 받은 값을 하나의 정보로 뭉친다
			ProductInfo productInfo = new ProductInfo(name, category, stock, price, img, insertDate);
			
			// 4. DB에 새로운 상품 정보를 추가한다
			ProductInfoDao productInfoDao = new ProductInfoDao();
			
			productInfoDao.insertProductInfo(productInfo);
			
			//아무것도 하지않으면 상태코드 200을 전달함
//			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("http://localhost:8080/shoppingmall/shop/product_list.jsp?active=product_list&pageNumber=1");
			
			
			
	}

}