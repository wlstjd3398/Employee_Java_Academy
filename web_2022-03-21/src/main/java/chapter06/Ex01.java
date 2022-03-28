package chapter06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex01", urlPatterns = { "/ch06_Ex01" })
public class Ex01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		서버가 쿠키를 만들어서 해당 클라이언트의 상태를 기록
		Cookie c1 = new Cookie("id", "guest");
//		쿠키는 클라이언트가 가지고 있다가
//		예로 60초(1시간) 동안 가지고 있다가 버림(브라우저를 닫아도 유지기간동안은 쿠키는 살아있음)
		c1.setMaxAge(60 * 60);
		
		response.addCookie(c1);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
