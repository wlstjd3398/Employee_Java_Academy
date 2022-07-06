package gallery;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryInfoDao;
import exception.BadParameterException;
import vo.GalleryInfo;


//갤러리 추가(img 추가)
@WebServlet("/gallery/add")
public class GalleryAddController {
	private static final int MAXINUM_FILE_SIZE = 10 * 1024 * 1024; // 10MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 1. 전달 받은 값을 꺼낸다(시작)
			String path = request.getRealPath("images/picture");
			
			// 첨부 파일을 꺼내서 저장
			MultipartRequest mr = new MultipartRequest(request, path, MAXINUM_FILE_SIZE, "utf-8", new DefaultFileRenamePolicy());
			
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");

			// img 파라미터에 담긴 파일을 저장했을 때 저장된 실제 파일의 이름
			String img = mr.getFilesystemName("img");
			String writer = mr.getParameter("writer");
			LocalDateTime insertDate = LocalDateTime.now();
			int hits = Integer.parseInt(mr.getParameter("hits"));
			
			
			// 3. 전달 받은 값을 하나의 정보로 뭉친다
			GalleryInfo galleryInfo = new GalleryInfo(title, content, img, writer, insertDate, hits);
			
			// 4. DB에 새로운 상품 정보를 추가한다
			GalleryInfoDao galleryInfoDao = new GalleryInfoDao();
			
			galleryInfoDao.insertGalleryInfo(galleryInfo);
			
			//아무것도 하지않으면 상태코드 200을 전달함
//			response.setStatus(HttpServletResponse.SC_OK);
			
			response.sendRedirect("http://localhost:8080/shoppingmall/shop/Gallery_list.jsp?active=Gallery_list&pageNumber=1");
			
	}
	
}
