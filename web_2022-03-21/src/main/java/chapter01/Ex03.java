package chapter01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 컴퓨터가 참고하는 주석 = annotation
// 정석은 @WebServlet(urlPatterns="/second")
// @WebServlet(urlPatterns="/second", name = "second")
@WebServlet("/second")
public class Ex03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ex03 서블릿 호출!");
	}

	

	
	
}
