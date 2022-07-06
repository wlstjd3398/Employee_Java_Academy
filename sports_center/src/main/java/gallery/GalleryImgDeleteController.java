package gallery;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryInfoDao;
import vo.GalleryInfo;

@WebServlet("/gallery/img/delete")
public class GalleryImgDeleteController extends HttpServlet{

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			return;
		}
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		GalleryInfoDao dao = new GalleryInfoDao();
		
		GalleryInfo galleryInfo = dao.selectByIdx(idx);
		
		// img가 실제 있는 경로
		String path = request.getRealPath("/images/Gallery/"+galleryInfo.getImg());
		
		// 해당 경로의 파일 삭제
		File file = new File("삭제할 파일의 경로");
		file.delete();
		
		// DB 상에서 이미지 파일 삭제
		dao.deleteImgById(idx);
		
	}
	
}
