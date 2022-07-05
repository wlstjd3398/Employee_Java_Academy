package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;

@WebServlet("/Board/controller3")
public class BoardController3 extends HttpServlet{

//	상세보기페이지 데이터불러오기
	

	// 자유게시판 목록
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 자유게시판 상세보기 페이지에 필요한 데이터를 불러와 전달
	
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 클라이언트가 전달한 id를 활용해서
		// 해당 id의 자유게시판 상세 정보(제목, 내용)를 데이터베이스에서 불러와
		// JSON으로 전달하도록 컨트롤러, 모델을 만드세요
		BoardService service = new BoardService();
		String data = service.loadBoardInfoToJson(idx);
		
		response.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
			
	}
}
