package product;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;
import vo.ProductInfo;

@WebServlet("/product/img/delete")
public class ProductImgDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("productId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			return;
		}
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductInfoDao dao = new ProductInfoDao();
		
		ProductInfo productInfo = dao.selectByIdx(productId);
		
		// img가 실제 있는 경로
		String path = request.getRealPath("/images/product/"+productInfo.getImg());
		
		// 해당 경로의 파일 삭제
		File file = new File("삭제할 파일의 경로");
		file.delete();
		
		// DB 상에서 이미지 파일 삭제
		dao.deleteImgById(productId);
		
	}

}
