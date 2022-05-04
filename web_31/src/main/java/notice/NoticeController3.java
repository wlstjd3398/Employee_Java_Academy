package notice;

import java.io.File;
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

@WebServlet("/notice/controller3")
public class NoticeController3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 상세보기 페이지에 필요한 데이터를 불러와 전달
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		// 클라이언트가 전달한 id를 활용해서
		// 해당 id의 공지사항 상세 정보(제목, 내용)를 데이터베이스에서 불러와
		// JSON으로 전달하도록 컨트롤러, 모델을 만드세요
		NoticeService service = new NoticeService();
		
		String data = service.loadNoticeInfoToJson(id);
		
		response.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
	}

	
	// 공지사항의 첨부파일을 삭제하는 역할
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트가 전달한 첨부파일을 삭제할 공지사항의 id를 꺼낸다
		int id = Integer.parseInt(req.getParameter("id"));
		
		// 공지사항 id를 사용해서 첨부파일의 경로를 가져온다
		NoticeInfoDao dao = new NoticeInfoDao();
		NoticeInfo noticeInfo = dao.selectNoticeInfoById(id); // filePath 까지 리턴하는지 확인
		
		
		
		// 가져온 첨부파일의 경로를 사용해서 해당 경로의 파일을 삭제한다
		String path = req.getRealPath(noticeInfo.getFilePath()); // 실제 경로 사용
		
		File file = new File(path);
		
		file.delete(); // 이 경로에 있는 파일 삭제
		
		// 공지사항 id를 사용해서 DB에 저장된 해당 공지사항의 정보 중 filePath 칼럼의 값을 null로 만든다
		noticeInfo.setFilePath(null);
		
		dao.updateNoticeInfo(noticeInfo);
		
		
	}
	

	


}
