package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;

// 회원 정보와 관련된 요청을 처리하는 컨트롤러
// 컨트롤러의 URL에 꼭 controller 라고 들어갈 필요는 없음
// 로그인, 로그아웃 구현

@WebServlet("/member/controller")
public class MemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		// 사용자가 입력한 아이디, 비밀번호, 이름이 올바른 값인지 확인하는 
		// 입력값 검증이 반드시 필요!
		// 입력값을 검증하기 위해서는 아이디에 대한 규칙이 필요
		// 또 비밀번호에 대한 규칙, 이름에 대한 규칙이 필요함
		
		// 입력값 검증에 실패했을 경우 입력값 검증 실패와 관련된 페이지로 이동
		
		MemberDTO newMemberInfo = new MemberDTO(id, pw, name);		

		// 회원가입 처리
		MemberService service = new MemberService();
		
		int statusCode = service.join(newMemberInfo);
		
		// 회원가입 처리 결과에 맞는 페이지 전달(응답)
		if(statusCode == HttpServletResponse.SC_CREATED) {
			// 회원 가입 완료 페이지로 이동
			response.sendRedirect("/web_2022-04-25/memberOutput.jsp");
		}else {
			// 회원 가입 실패와 관련된 페이지로 이동
			
		}
		
	}

}
