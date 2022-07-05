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
import etc.URLConfig;
import service.BoardService;
import vo.BoardInfo;

@WebServlet("/board/controller")
public class BoardController extends HttpServlet{

//	자유게시판 목록,  
//	자유게시판 쓰기, 자유게시판 삭제,
	
//	자유게시판 전체갯수, 자유게시판 수정,
	
//	상세보기페이지 데이터불러오기
	

	// 자유게시판 목록
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트가 페이지넘버 담겨있는 것을 정수로 담아서 전달해줌
		// 문자열을 숫자로 래퍼클래스 사용
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		BoardService service = new BoardService();
		String data = service.loadBoardInfoListToJson(pageNumber);
		
		// JSON을 전달한다.
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
		
	}

	
	// 자유게시판 쓰기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		LocalDateTime insertDate = LocalDateTime.now();
		
		BoardInfo boardInfo = new BoardInfo(title, content);
		
		BoardService service = new BoardService();
		
		boolean result = service.addBoard(boardInfo);
		
		if(result) {
			// 자유게시판 목록 페이지로 이동
			response.sendRedirect(URLConfig.PAGE_Board_LIST_URL);
		} else {
			// 자유게시판 추가 실패와 관련된 처리를 함
		}
	}
	
	
	// 자유게시판 삭제
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardInfoDao dao = new BoardInfoDao();
		boolean result = dao.deleteBoardInfoByIdx(idx);
		
		if(result) {
			
		}else {
			
		}
		
		
	}
	
}
