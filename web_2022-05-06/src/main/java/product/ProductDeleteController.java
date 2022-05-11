package product;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductInfoDao;
import vo.MemberInfo;
import vo.ProductInfo;

@WebServlet("/product/delete")
public class ProductDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("productId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		// 첨부파일이 있는 공지사항을 삭제하는 과정을 다시 떠올려보세요
		// 이미지가 가지고 있는 상품정보는 먼저 이미지를 삭제하고
		// DB에서 상품 정보를 삭제해야함
		ProductInfoDao dao = new ProductInfoDao();
		
		// 해당 아이디가 이미지를 가지고있는지 조회
		ProductInfo productInfo = dao.selectByIdx(productId);
		if(productInfo.getImg() == null) {
			// 파일 삭제
			String img = productInfo.getImg();
			String path = request.getRealPath("images/product");
			
			File file = new File(path + "/"+img);
			file.delete();
		}
		
		dao.deleteByIdx(productId);
		
	}

}
