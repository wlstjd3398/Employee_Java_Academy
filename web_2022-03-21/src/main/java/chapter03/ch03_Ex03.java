package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/ch03_Ex03", urlPatterns= {"/ch03_ex03"})
public class ch03_Ex03 extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(301);
		response.setHeader("Location", "http://localhost/ch03_ex02");
		// 상태코드를 지정해 응답하게함 
		// 상태코드404로 하면 안됐는데 크롬업데이트가 되어 정상작동이됨
		// 다른 브라우저는 정상작동이 안됨
		
		// 상태코드 500
		// 상태코드 301 -> sendRedirect 니가 원하는건 내한테 없으니 다른 곳에 있으니 저기로 가봐
		// sendHeader가 필요함
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("ex03으로 접근했습니다.");
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
