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
import util.Validator;
import vo.MemberInfo;

@WebServlet("/member/password/update")
public class MemberPasswordUpdateController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPw = request.getParameter("oldPassword");
		String newPw = request.getParameter("newPassword");
		String newPwChk = request.getParameter("newPasswordChk");
		
		Validator validator = new Validator();
		if(!validator.pwValidator(oldPw))			throw new BadParameterException();
		else if(!validator.pwValidator(newPw))			throw new BadParameterException();
		else if(newPw.equals(newPwChk))			throw new BadParameterException();
		
		
		
		
		HttpSession session = request.getSession();
		
		MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		if(loginUserInfo.getPw().equals(oldPw)) {
			// 로그인한 사용자의 비밀번호와 전달 받은 oldPw가 일치한다면
			// 새 비밀번호로 변경
			String id = loginUserInfo.getId();
			
			MemberInfoDao dao = new MemberInfoDao();
			dao.updatePassWordById(id, newPw);
		}else {
			// 일치하지 않는다면 400 상태코드 응답
			throw new BadParameterException();
		}
		
		
		
		
	}

}
