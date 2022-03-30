package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch07_Ex01", urlPatterns = { "/chapter07/ex01" })
public class Ex01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<< Servlet 호출 >>");
		
//		response.setContentType("text/html;charset=utf-8");
		//불필요하게 두번쓰임
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>여기는 Servlet1 입니다.</h1>");
		
//		out.close();
		//불필요하게 두번쓰임 더이상 보낼 데이터가 없다 -> Filter1의 doFilter로 가야함
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
