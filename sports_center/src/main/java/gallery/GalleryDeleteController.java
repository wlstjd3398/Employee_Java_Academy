package gallery;

import java.io.File;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryInfoDao;
import vo.GalleryInfo;

@WebServlet("/gallery/delete")
public class GalleryDeleteController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("GalleryId") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 첨부파일이 있는 공지사항을 삭제하는 과정을 다시 떠올려보세요
		// 이미지가 가지고 있는 상품정보는 먼저 이미지를 삭제하고
		// DB에서 상품 정보를 삭제해야함
		GalleryInfoDao dao = new GalleryInfoDao();
		
		// 해당 아이디가 이미지를 가지고있는지 조회
		GalleryInfo galleryInfo = dao.selectByIdx(idx);
		if(galleryInfo.getImg() == null) {
			// 파일 삭제
			String img = galleryInfo.getImg();
			String path = request.getRealPath("images/Gallery");
			
			File file = new File(path + "/"+img);
			file.delete();
		}
		
		dao.deleteByIdx(idx);
	}
}
