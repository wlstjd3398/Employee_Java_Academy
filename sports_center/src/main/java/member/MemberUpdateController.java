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

@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("utf-8");
				
//			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			
			Validator validator = new Validator();
			
			
			HttpSession session = request.getSession();
			
			// 세션에 들어있는 로그인정보에서 아이디를 꺼냄
			MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			String id = loginUserInfo.getId(); // NullpointerException
			
			MemberService service = new MemberService();
			// 이메일 또는 연락처 변경 시 중복 여부 확인
			// 중복 됐다면 409 상태코드
			if(service.isAlreadyTelorEmail(id, tel, email)) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				
				return;
			}
			
			
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(id);
//			memberInfo.setPw(pw);
			memberInfo.setName(name);
			memberInfo.setTel(tel);
			memberInfo.setAddr(addr);
			memberInfo.setEmail(email);
			
			service.updateMemberInfo(memberInfo);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
			} catch(BadParameterException e) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
	
	}

	
	
}
