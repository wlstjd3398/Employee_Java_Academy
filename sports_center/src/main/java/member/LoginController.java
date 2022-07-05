package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadParameterException;
import service.MemberService;
import util.Validator;
import vo.MemberInfo;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 전달 받은 값을 꺼냄
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			// 전달 받은 값을 검증함
			Validator validator = new Validator();
			
			
			// 전달 받은 값들을 하나의 로그인 정보로 합친다(id와 pw 입력 값을 비교할수있게 저장한다)
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			MemberService service = new MemberService();
			
			loginInfo = service.selectById(id);
			
			if(loginInfo == null || !loginInfo.getPw().equals(pw)) {
				
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				
				response.setStatus(HttpServletResponse.SC_OK);
				
			}
			
		} catch(BadParameterException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
			
	}
		
}

