package notice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.NoticeInfoDao;
import etc.Database;
import etc.URLConfig;
import service.NoticeService;
import vo.NoticeInfo;

@WebServlet("/notice/controller")
public class NoticeController extends HttpServlet {
	// 공지사항 목록 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항의 목록을 불러와 전달해주는 서블릿
		
		// 지금 우리 컨트롤러의 구조는
		// 1. 공지사항의 목록을 불러온다.
		// 2. 불러온 목록을 JSON으로 구성해 전달한다.
		
		// 컨트롤러의 구조를 다르게 생각해서
		// 1. 공지사항의 목록을 불러와 JSON으로 구성한다.
		// 2. JSON을 전달한다.
		
		
		
		// 공지사항 
		
		// 클라리언트가 페이지넘버 담겨있는것을 정수로 담아서 전달해줌
		// 문자열로 숫자로 래퍼클래스 사용
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 첨부파일을 보낼 가능성이 있다면
		// request를 그대로 사용하면 안됨
		
		String path = "/file/notice";
		path = request.getRealPath(path);
		// path는 상대경로를 절대경로로 바꿔주며 정확한 메서드를 파악하는 것이 중요함
		
//		request.getServletContext().getRealPath(path);
		// 기존방식은 이방식으로 쓰이지만 간단히 쓰기 위해 위위 코드로 사용함
		
		int maximumSize = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(request, path, maximumSize, encoding, new DefaultFileRenamePolicy());
		
		request.setCharacterEncoding("UTF-8");
		
		String title = multi.getParameter("title");
		String contents = multi.getParameter("contents");

		
		// file 파라미터로 전달된 파일의 실제 서버에 저장된 이름을 알 수 있음
		// multi.getFilesystemName("file");
		
		String fileSystemName = multi.getFilesystemName("file");
		String filePath = null;
		if(fileSystemName != null) {
			filePath = "/file/notice/" + fileSystemName;
		}
		
		
		
		// 클라이언트가 보낸 첨부파일을 꺼냄(컨트롤러가 처리하도록 할 것)
		// -> MultipartRequest (cos.jar 파일이 필요)
		// 또는 commons-fileupload (commons-fileupload.jsr, commons-io.jar 파일을 필요)
		
		// 첨부파일을 적절한 위치에 저장함(서비스가 처리하도록 할 것)
		
		
		// DB에 첨부파일의 위치를 기록함(DAO가 처리하도록 할 것)
		
		
		
		// 클라이언트가 보낸 파라미터 값 검증
		
		// 공지사항 데이터들을 공지사항 정보로 뭉쳐줌
		NoticeInfo noticeInfo = new NoticeInfo(title, contents, filePath);
		
		NoticeService service = new NoticeService();
		
		boolean result = service.addNotice(noticeInfo);
		
		if(result) {
			// 공지사항 목록 페이지로 이동
			response.sendRedirect(URLConfig.PAGE_NOTICE_LIST_URL);
		} else {
			// 공지사항 추가 실패와 관련된 처리를 함
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		// 클라이언트가 전달한 id를 사용해서 
		// DB에서 해당 id를 가지고 있는 공지사항을 삭제
			//서비스가 없어도되는 단순한 것
		NoticeInfoDao dao = new NoticeInfoDao();
		
		NoticeInfo noticeInfo = dao.selectNoticeInfoById(id);
		if(noticeInfo.getFilePath() != null) {
			String path = req.getRealPath(noticeInfo.getFilePath());
			
			File file = new File(path);
			file.delete();
		}
		
		
		boolean result = dao.deleteNoticeInfoById(id);
		
		// 클라이언트에게 삭제 결과인 200 상태코드를 전달
		if(result) {
			// 200 상태코드 전달
			
		} else {
			// 삭제 하지 못했다는 의미의 상태 코드를 전달
		}
		
	}

	// 공지사항 수정

	
}