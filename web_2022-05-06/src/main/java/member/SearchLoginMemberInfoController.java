package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import vo.MemberInfo;

@WebServlet("/member/search")
public class SearchLoginMemberInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 사용자의 정보를 불러와 전달해주는 서블릿 -> 로그인 상태 정보가 세션이나 쿠키에 저장되어있어야함
		
		// 로그인한 사용자의 식별값이 필요함(로그인한 사용자가 어떤 사용자인지 식별할 수 있는 값)
		HttpSession session = request.getSession();
		MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
//		System.out.println(loginUserInfo);
		
		String id = loginUserInfo.getId();
		
		MemberInfoDao dao = new MemberInfoDao();
		loginUserInfo = dao.selectById(id);
		
//		System.out.println(loginUserInfo.getId());
//		System.out.println(loginUserInfo.getName());
//		System.out.println(loginUserInfo.getTel());
//		System.out.println(loginUserInfo.getAddr());
//		System.out.println(loginUserInfo.getEmail());
		
		
		response.setContentType("application/json;charset=UTF-8");
		
		String data = "{\"id\":\"(1)\",\"name\":\"(2)\",\"tel\":\"(3)\",\"addr\":\"(4)\",\"email\":\"(5)\"}";
		
//		String name = loginUserInfo.getName() == null ? "" : loginUserInfo.getName();
//		String tel = loginUserInfo.getTel() == null ? "" : loginUserInfo.getTel();
//		String addr = loginUserInfo.getAddr() == null ? "" : loginUserInfo.getAddr();
//		String email = loginUserInfo.getEmail() == null ? "" : loginUserInfo.getEmail();
		
		
		data = data.replace("(1)", loginUserInfo.getId());
		data = data.replace("(2)", loginUserInfo.getName());
		data = data.replace("(3)", loginUserInfo.getTel());
		data = data.replace("(4)", loginUserInfo.getAddr());
		data = data.replace("(5)", loginUserInfo.getEmail());
		
		PrintWriter output = response.getWriter();
		output.print(data);
		output.close();
		
	}


}
