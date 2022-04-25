package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. controller에서 클라이언트가 보낸 데이터를 꺼냄(수업자료는 service에서 함 이런저런 방법이있다로 알고있으면됨)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 2. 클라이언트가 보낸 데이터를 검증한다(유효성 검사)
		
		
		// 3. 서비스 객체의 메서드를 호출해서 파라미터를 서비스 객체로 전달한다
		
		
		// 4. 
		
		
		
	}

}
