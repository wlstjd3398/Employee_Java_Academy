package product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductInfoDao;
import vo.ProductInfo;

//상품 정보 추가, 수정과 같이 클라이언트가 multipart/form-data 로 파라미터를 보내면 
//request로 파라미터를 꺼낼 수 없음
//반드시 request를 MultipartRequest로 변환해야함

//상품 정보를 수정할 때 이미지 파일은 그대로이고
//상품 이름, 카테고리, 재고, 가격을 수정하는 상황에서는
//img 파라미터를 보내지 않기 때문에
//DB의 상품 정보에 이미지 파일이 NULL이 됨
//-> 해결방법 : 이와 같은 상황에서는 img 파라미터에 기존에 이미지 파일명을 담아서 보내도록
//		(postman을 사용해서 이와 같이 해결하는건 쉬움, HMTL/CSS/JS를 사용해서 이와 같이 처리하는 건 약간 어려울 수 있음)


//@WebServlet("/product/update") 충돌일어남
public class ProductUpdateController2 extends HttpServlet {
	private static final int MAXINUM_FILE_SIZE = 5 * 1024 * 1024; // 5MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRealPath("images/product");
		// 공지사항의 첨부파일을 수정
		// 첨부파일 삭제 -> 새롭게 첨부파일 등록 
		MultipartRequest mr = new MultipartRequest(request, path, MAXINUM_FILE_SIZE, "utf-8", new DefaultFileRenamePolicy());
		
		if(mr.getParameter("productId") == null || mr.getParameter("stock") == null || mr.getParameter("price") == null ) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int productId = Integer.parseInt(mr.getParameter("productId"));
		// idx을 사용해서 상품정보를 수정해라
		String name = mr.getParameter("name");
		String category = mr.getParameter("category");
		int stock = Integer.parseInt(mr.getParameter("stock"));
		int price = Integer.parseInt(mr.getParameter("price"));
		// getFilesystemName() 메서드 : DefaultFileRenamePolicy 때문에 클라이언트가 전달한 파일의 이름 그대로 저장되지 않을 수 있음
		//							getFilessystemName() 메서드를 사용하면 인자로 넣은 이름으로 전달된 파일이
		//							저장된 실제 이름을 반환
		//							인자로 넣은 이름으로 전달된 파일이 없다면 null을 반환
		// 이미지파일수정경우는 새로운 이미지파일이름으로, 이미지파일수정하지않는 경우는 기존의 이미지파일이름으로
		String img = mr.getFilesystemName("img");
		if(img == null) {
			img = mr.getParameter("img");
		}
//		System.out.println("img -> " + img); // null이 나오는지 확인
		
		
		// 전달 받은 값 검증
		
		// 전달 받은 값을 하나의 정보로 합침
		ProductInfo productInfo = new ProductInfo();
		
		productInfo.setIdx(productId);
		productInfo.setName(name);
		productInfo.setCategory(category);
		productInfo.setStock(stock);
		productInfo.setPrice(price);
		productInfo.setImg(img);

		ProductInfoDao dao = new ProductInfoDao();
		
		dao.updateProductInfo(productInfo);
		
	
	}
	
	
	

}