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
			// 1. 전달 받은 값을 꺼낸다
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			// 2. 전달 받은 값을 검증한다
			Validator validator = new Validator();
			if(!validator.idValidator(id))		 throw new BadParameterException();
			else if(!validator.pwValidator(pw)) throw new BadParameterException();
			
			// 3. 전달 받은 값을 하나의 로그인 정보로 합친다(id와 pw 입력 값을 비교하게 저장한다)
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			// 4. 로그인 성공 / 실패 여부를 판단한다(service에서 아이디와 비밀번호에 맞는 값을 가져온다)
			// 4-1. 로그인 성공 : 상태 정보를 세션에 저장하고 상태 코드 200으로 응답한다
			// 4-2. 로그인 실패
			// 4-2-1. 전달 받은 값이 규칙에 맞지 않을때 : 상태코드 400으로 응답한다
			// 4-2-2. 아이디 또는 비밀번호가 틀렸을때 : 상태코드 401로 응답한다
			MemberService service = new MemberService();
			if(service.isLogin(loginInfo)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				
				response.setStatus(HttpServletResponse.SC_OK);
			}else {
				
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		
		} catch(BadParameterException e) {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	}

}
