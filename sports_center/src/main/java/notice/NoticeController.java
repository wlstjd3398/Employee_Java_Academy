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
import etc.URLConfig;
import service.NoticeService;
import vo.NoticeInfo;

@WebServlet("/notice/controller")
public class NoticeController extends HttpServlet{

//	공지사항 목록,  
//	공지사항 쓰기, 공지사항 삭제,
	
//	공지사항 전체갯수, 공지사항 수정,
	
//	상세보기페이지 데이터불러오기
	

	// 공지사항 목록
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트가 페이지넘버 담겨있는 것을 정수로 담아서 전달해줌
		// 문자열을 숫자로 래퍼클래스 사용
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		NoticeService service = new NoticeService();
		String data = service.loadNoticeInfoListToJson(pageNumber);
		
		// JSON을 전달한다.
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
		
	}

	
	// 공지사항 쓰기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		LocalDateTime insertDate = LocalDateTime.now();
		
		NoticeInfo noticeInfo = new NoticeInfo(title, content, writer, insertDate);
		
		NoticeService service = new NoticeService();
		
		boolean result = service.addNotice(noticeInfo);
		
		if(result) {
			// 공지사항 목록 페이지로 이동
			response.sendRedirect(URLConfig.PAGE_NOTICE_LIST_URL);
		} else {
			// 공지사항 추가 실패와 관련된 처리를 함
		}
	}
	
	
	// 공지사항 삭제
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		NoticeInfoDao dao = new NoticeInfoDao();
		boolean result = dao.deleteNoticeInfoByIdx(idx);
		
		if(result) {
			
		}else {
			
		}
		
		
	}
	
}
