package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import service.MemberService;
import util.Validator;
import vo.MemberInfo;

@WebServlet("/member/join")
public class JoinController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 전달받은 값을 꺼냄
			request.setCharacterEncoding("utf-8");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwChk = request.getParameter("pwChk");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");

			LocalDateTime joinDate = LocalDateTime.now();
			
			
			// 전달 받은 값을 검증함
			Validator validator = new Validator();

			
			// 하나의 정보로 값들을 뭉침
			MemberInfo newMemberInfo = new MemberInfo(id, pw, name, tel, addr, email, joinDate);
			
			MemberService service = new MemberService();
			
			if(service.isAlreadyIDorTelorEmail(newMemberInfo)) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			
				return;
			}
			
			// 새로운 회원의 정보를 DB에 저장함
			int status = service.join(newMemberInfo);
			
			response.setStatus(status);
			
		}catch(BadParameterException e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
			
	}
}
