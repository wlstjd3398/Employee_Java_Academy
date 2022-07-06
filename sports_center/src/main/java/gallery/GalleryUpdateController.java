package gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryInfoDao;
import vo.GalleryInfo;


// 갤러리 img빼고 수정
@WebServlet("/gallery/update")
public class GalleryUpdateController extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		// idx을 사용해서 갤러리 정보를 수정해라
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 전달 받은 값을 하나의 정보로 합침
		GalleryInfo galleryInfo = new GalleryInfo();
		
		galleryInfo.setIdx(idx);
		galleryInfo.setTitle(title);
		galleryInfo.setContent(content);

		GalleryInfoDao dao = new GalleryInfoDao();
		
		dao.updateGalleryInfo(galleryInfo);
		
	
	}
	
}
