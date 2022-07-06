package gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GalleryInfoDao;
import vo.GalleryInfo;


// 갤러리 img포함 수정
//@WebServlet("/gallery/update")
public class GalleryUpdateController2 extends HttpServlet{
	private static final int MAXINUM_FILE_SIZE = 5 * 1024 * 1024; // 5MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRealPath("images/picture");
		// 갤러리의 첨부파일을 수정
		// 첨부파일 삭제 -> 새롭게 첨부파일 등록 
		MultipartRequest mr = new MultipartRequest(request, path, MAXINUM_FILE_SIZE, "utf-8", new DefaultFileRenamePolicy());
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		// idx을 사용해서 상품정보를 수정해라
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("img");
		
		if(img == null) {
			img = mr.getParameter("img");
		}
		
//		System.out.println("img -> " + img); // null이 나오는지 확인
		
		
		// 전달 받은 값 검증
		
		// 전달 받은 값을 하나의 정보로 합침
		GalleryInfo galleryInfo = new GalleryInfo();
		
		galleryInfo.setIdx(idx);
		galleryInfo.setTitle(title);
		galleryInfo.setContent(content);
		galleryInfo.setImg(img);

		GalleryInfoDao dao = new GalleryInfoDao();
		
		dao.updateGalleryInfo(galleryInfo);
		
	
	}
	
}
