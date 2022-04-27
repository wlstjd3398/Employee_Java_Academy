package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeInfoDao;
import etc.Database;
import etc.URLConfig;
import service.NoticeService;
import vo.NoticeInfo;

@WebServlet("/notice/controller")
public class NoticeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항의 목록을 불러와 전달해주는 서블릿
		
		
		// 지금 우리 컨트롤러의 구조는
		// 1. 공지사항의 목록을 불러옴
		// 2. 불러온 목록을 json으로 구성해 전달함
		
		// 컨트롤러의 구조를 다르게 생각해서
		// 1. 공지사항의 목록을 불러와 json으로 구성함
		// 2. json을 전달함
		
		
		
		NoticeService service = new NoticeService();
		String data = service.loadNoticeInfoToJson();
		
		// json을 전달한다
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
		
		
		// 불러온 목록을 json으로 구성해 전달함
//		response.setContentType("application/json; charset=utf-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print("{\"noticeList\":[");
//		
//		String data = "";
//		
//		for(NoticeInfo noticeInfo : noticeInfoList) {
//			data = data + "{\"title\":\""+ noticeInfo.getTitle() + "\","
//					+ "\"contents\":\"" + noticeInfo.getContents() +"\"},";
//		}
//			data = data.substring(0, data.length()-1);
//			// 마지막,를 substring으로 data.length()-2로 잘라줌
//			// -2를 -1로 수정하면 원하는대로 수정됨
//			
//			out.print(data);
//		// json으로 공지사항정보를 전달해줘야함
//		
//		out.print("]}");
//		out.close();
	}
	
	

	// 공지사항 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		// 클라이언트가 보낸 파라미터 값 검증
		
		
		// 공지사항 데이터들을 공지사항 정보로 뭉쳐줌
		NoticeInfo noticeInfo = new NoticeInfo(title, contents);
		
		// 공지사항 
		NoticeService service = new NoticeService();
		
		boolean result = service.addNotice(noticeInfo);
		
		if(result) {
			// 공지사항 목록 페이지로 이동
			response.sendRedirect(URLConfig.PAGE_NOTICE_LIST_URL);
		}else {
			// 공지사항 추가  실패와 관련된 처리를 함
//			공지사항 실패경우는 거의 없어서 뺌
		}
	}

}
