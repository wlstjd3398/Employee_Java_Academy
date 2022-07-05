package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardInfoDao;
import service.BoardService;
import vo.BoardInfo;

@WebServlet("/Board/controller2")
public class BoardController2 extends HttpServlet{

//	자유게시판 전체갯수, 자유게시판 수정,
	

	// 자유게시판 전체 갯수
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 자유게시판의 전체 개수를 불러와서 전달한다
			BoardInfoDao dao = new BoardInfoDao();
			
			int amount = dao.getAmountOfBoard();
			
			PrintWriter out = response.getWriter();
			
			out.print(amount);
					
			out.close();
		
	}

	
	// 자유게시판 수정
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardInfo boardInfo = new BoardInfo(idx, title, content);
		
		BoardService service = new BoardService();
		
		boolean result = service.updateBoardInfo(boardInfo);
		
		if(result) {
			// 자유게시판을 성공적으로 수정했다면
			// 상태코드 200으로 응답

		}else {
			// 자유게시판을 성공적으로 수정하지 못했다면
			// 상태코드 400으로 응답
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
		
}
