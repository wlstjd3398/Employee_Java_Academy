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
		
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
		
		
		
	}
	
	


}
