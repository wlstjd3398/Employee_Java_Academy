package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeInfoDao;
import service.NoticeService;
import vo.NoticeInfo;

@WebServlet("/notice/controller2")
public class NoticeController2 extends HttpServlet{

//	공지사항 전체갯수, 공지사항 수정,
	

	// 공지사항 전체 갯수
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 공지사항의 전체 개수를 불러와서 전달한다
			NoticeInfoDao dao = new NoticeInfoDao();
			
			int amount = dao.getAmountOfNotice();
			
			PrintWriter out = response.getWriter();
			
			out.print(amount);
					
			out.close();
		
	}

	
	// 공지사항 수정
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		LocalDateTime insertDate = LocalDateTime.now();
		
		NoticeInfo noticeInfo = new NoticeInfo(idx, title, content, writer, insertDate);
		
		NoticeService service = new NoticeService();
		
		boolean result = service.updateNoticeInfo(noticeInfo);
		
		if(result) {
			// 공지사항을 성공적으로 수정했다면
			// 상태코드 200으로 응답

		}else {
			// 공지사항을 성공적으로 수정하지 못했다면
			// 상태코드 400으로 응답
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
		
}
