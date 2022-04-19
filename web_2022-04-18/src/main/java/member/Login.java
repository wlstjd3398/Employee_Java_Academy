package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 아이디 비번 둘중 하나라도 비면
		if(id.length() == 0 || pw.length() == 0){
			//fail을 empty로 
			request.setAttribute("fail", "empty");
			
			RequestDispatcher rd = request.getRequestDispatcher("/chapter01/login.jsp");
			rd.forward(request, response);
		// 로그인 성공했다면	
		}else {
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogin", true);
			session.setMaxInactiveInterval(60);
			
			RequestDispatcher rd = request.getRequestDispatcher("/chapter01/login.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
