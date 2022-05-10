package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import exception.BadParameterException;
import service.MemberService;
import util.Validator;
import vo.MemberInfo;

@WebServlet("/member/update")
public class MemberInfoUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// badParameter 때매 try catch해줘야함
		try {
		
		request.setCharacterEncoding("utf-8");
			
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		
		Validator validator = new Validator();
		if(!validator.pwValidator(pw))			throw new BadParameterException();
		else if(!validator.nameValidator(name))		throw new BadParameterException();
		else if(!validator.telValidator(tel))		throw new BadParameterException();
		else if(!validator.addrValidator(addr))		throw new BadParameterException();
		else if(!validator.emailValidator(email))	throw new BadParameterException();
		
		// 회원 정보를 수정할 때 pw ~ email 까지 모든 파라미터를 다 전달할 것
		// 바꾸지 않을 정보는 기존의 정보 그대로 전달하고
		// 바꿀 정보는 바꿀 새로운 값으로 전달할 것
		
		// pw로 전달 받은 값이 바꿀 새로운 비밀번호 라는 보장은 없음
		// tel로 전달 받은 값이 무조건 바꿀 새로운 연락처라는 보장은 없음
		
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
		memberInfo.setPw(pw);
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
