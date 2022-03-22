package chapter01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Ex02 extends HttpServlet{
// 서블릿 사용하려면  extends HttpServlet 하고 import해야함
	// get으로만 접근하게하려면 doget 사용
	// get, post 다 접근하게하려면 goget, gopost 사용
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("서비스 메서드 호출!");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출!");
	}
	
	
}
