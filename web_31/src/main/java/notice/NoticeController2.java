package notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeInfoDao;
import service.NoticeService;
import vo.NoticeInfo;


@WebServlet("/notice/controller2")
public class NoticeController2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공지사항의 전체 개수를 불러와서 전달한다
		NoticeInfoDao dao = new NoticeInfoDao();
		
		int amount = dao.getAmountOfNotice();
		
		PrintWriter out = response.getWriter();
		
		out.print(amount);
		
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(req.getParameter("id"));
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		NoticeInfo noticeInfo = new NoticeInfo(id, title, contents);
		
		NoticeService service = new NoticeService();
		
		boolean result = service.updateNoticeInfo(noticeInfo);
		
		if(result) {
			// 공지사항을 성공적으로 수정했다면
			// 상태코드 200으로 응답
			
		}else {
			// 공지사항을 성공적으로 수정하지 못했다면
			// 상태코드 400으로 응답
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
		
	}
	
	


}
