package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import dao.UserInfoDao;
import etc.Database;
import etc.URLConfig;
import vo.MemberInfo;

@WebServlet("/member/join")
public class Join extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 전달한 파라미터에서 회원 정보를 꺼냄
		// 서블릿에서 요청정보를 받음(id, pw, nickname 담아서)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("name");
		
		//파라미터 검증 해보기
		//1. 아이디 값이 비어있는지 확인
		//2. 비밀번호 값이 비어있는지 확인
		//3. 이름 값이 비어있는지 확인
		//4. 아이디의 길이 또는 비밀번호의 길이 또는 이름의 길이가 적절한지 체크
		//5. 아이디에 반드시 들어가야할것과 들어가지 말아야할것 체크
		//6. 비밀번호에 반드시 들어가야할것과 들어가지 말아야할것 체크
		//7. 이름에 반드시 들어가야할 것, 들어가지 말아야할 것 체크
		
		
		// 회원 정보 생성
		MemberInfo memberInfo = new MemberInfo(id, pw, nickname);
		
		// 아이디 중복 체크
		
		UserInfoDao userInfoDao = new UserInfoDao();
		
		boolean isJoin = userInfoDao.insertUserInfo(memberInfo);
		
		if(isJoin) {
			// 회원 가입 성공 처리
			response.sendRedirect(URLConfig.PAGE_JOIN_SUCCESS_URL);
		}else {
			// 회원 가입 실패 처리
			
		}
		
//UserInfo에 메서드 리팩토링 해놓음		
//		// 아이디 중복 체크
//		
//		
//		// 회원 정보 table에 저장
//		
//		// Connection을 가져오려면 db 생성
//		Database db = new Database();
//		
//		// 1. 커넥션 연결 -> 성공적으로 커넥션이 되면 stmt 실행
//		// 커넥션이 문제가 생겨 null을 stmt로 nullpointer를 보내게됨
//		Connection conn = db.getConnection();
//		Statement stmt = null;
//		
//		try {
//			// 2. stmt 생성
//			stmt = conn.createStatement();
//			
//			// 3. 쿼리 작성
//			String sql = "INSERT INTO usertbl(id, pw, name) VALUES('" + id + "', '" + pw + "', '" + nickname + "')";
//			
//			
//			// 4. stmt 를 통해서 쿼리 실행 및 결과 전달
//			int count = stmt.executeUpdate(sql);
//			
//			// 5. 결과를 활용해서 서비스 구현
//			if(count == 1) {
//				// 회원 가입 성공
//				// 회원가입 성공 페이지로 이동
//				response.sendRedirect("/web_31/member/joinSuccess.html");
//			}else{
//				// 회원 가입 실패
//				
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch(NullPointerException e) {
//			e.printStackTrace();
//		} finally {
//			//db에서 close메서드 호출
//			db.closeStmt(stmt);
//			db.closeConnection(conn);
//		}
//		
////		Database.memberInfoTable.add(memberInfo);
////		이것 대신에 위처럼 DB연동을 실행시킴
		
		
		
		
	}

}




