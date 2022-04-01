package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import etc.Database;
import vo.MemberInfo;

@WebServlet(name = "member/Login", urlPatterns = { "/member/login" })
public class Login extends HttpServlet {
	// 로그인, 회원가입으로 계속 확인하는게 번거로움
	// 범위데이터 생성
	public Login() {
		MemberInfo memberInfo = new MemberInfo("id1", "pw1", "name1");
		
		Database.memberInfoTable.add(memberInfo);
	}
	// 로그인했을때 이름이 한글로 나오게하려면 일단 주석처리했음 아직X
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 파라미터를 꺼냄
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 처리
		boolean success = false; // 찾지 못했다를 가정하고 찾음
		
		
		String loginUserName = null;
		
		// - DB에서 아이디와 비밀번호를 사용해서 일치하는 사용자를 찾는다
		for(MemberInfo nthMemberInfo : Database.memberInfoTable) {
			String nthMemberId = nthMemberInfo.getId();
			String nthMemberPw = nthMemberInfo.getPw();

			success = nthMemberId.equals(id) && nthMemberPw.equals(pw);		
			if(success) {
				loginUserName = nthMemberInfo.getNickname();
				
				break;
			}
		}
		
		// - 찾았으면 로그인 성공
		// - 찾지 못했으면 로그인 실패
		if(success) {
			// 로그인 성공 상태 정보 기록
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("loginUserName", loginUserName);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=\"UTF-8\">"
					+ "<title>Servlet Project</title>"
					+ "<link rel=\"stylesheet\" href=\"/web_31/css/header.css\">"
					+ "<link rel=\"stylesheet\" href=\"/web_31/css/footer.css\">"
					+ "<link rel=\"stylesheet\" href=\"/web_31/css/main_index.css\">"
					+ "</head>"
					+ "<body>"
					+ "	<header>"
					+ "		<div id=\"login_area\">"
					+ 		loginUserName + " 님 환영합니다~"
					+ "		</div>"
					+ "		<div id=\"join_area\">"
					+ "			<button type=\"button\">회원가입</button>"
					+ "		</div>"
					+ "	</header>"
					+ "	"
					+ "	<main>"
					+ "		<h2>공지사항</h2>"
					+ "		<div id=\"notice_list\">공지사항이 없습니다.</div>"
					+ "	</main>"
					+ "	"
					+ "	<footer>메가스터디 IT 아카데미 웹개발 취업반 Servlet 프로젝트</footer>"
					+ "</body>"
					+ "</html>");
			
			out.close();
			
		}else {
			// 로그인 실패
			response.sendRedirect("/web_31/main/index.html");
		}
		
		
		
	}

}
