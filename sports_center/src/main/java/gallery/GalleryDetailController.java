package gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryInfoDao;
import exception.BadParameterException;
import vo.GalleryInfo;

@WebServlet("/gallery/detail")
public class GalleryDetailController {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if(request.getParameter("idx") == null) {
				throw new BadParameterException();
			}
			
			int idx = Integer.parseInt(request.getParameter("idx"));
			
			GalleryInfoDao dao = new GalleryInfoDao();
			GalleryInfo galleryInfo = dao.selectByIdx(idx);
			
			// selectByIdx에 나온 다음
			// 문제 발생상황 : 존재하지 않는 GalleryId를 넣었을 경우
			// 이 문제를 적절히 해결해보세요
			
			if(galleryInfo == null) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return;
			}
			
			String data = "{\"title\":\"(1)\", \"content\":\"(2)\",\"img\":(3)\"}";
			data = data.replace("(1)", galleryInfo.getTitle());
			data = data.replace("(2)", galleryInfo.getContent());
			
			// 문자열화는 valueOf 사용 
			// String.valueOf(GalleryInfo.getStock()) 이런식으로 사용함
			
			// + "" 해도 문자열화가 됨
			// 보통은 + "" 빈문자열을 넣어서 사용함
			
			data = data.replace("(3)", galleryInfo.getImg());
			
			response.setContentType("application/json;charset=utf=8");
			
			PrintWriter out = response.getWriter();
			
			out.print(data);
			
			out.close();
			
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}
	
}
