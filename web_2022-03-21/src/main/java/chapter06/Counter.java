package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용자의 IP를 사용해서 우리 서비스를 이용한 횟수를 세주는 서블릿
@WebServlet(name = "ch06_Counter", urlPatterns = { "/ch06_Counter" })
public class Counter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientIP = request.getRemoteAddr();
		
		ServletContext context = getServletContext();
		
		int count = 0;
		
		try {
			//object로 저장이 되기에 int 형변환함
			count = (int)context.getAttribute(clientIP);

		}catch(NullPointerException e) {
			
		}
		//이용횟수가 없는상태에서 예외처리
		
		count++;
		
		//count++이 여기서 수를 올리고 사라지기에 ip와 함께 넣어주어 사용할수있게함
		context.setAttribute(clientIP, count);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("<h1>아이피 : " + clientIP + "</h1>");
		output.print("<h1>이용횟수 : " + count + "</h1>");
		
		output.close();
		//예외를 어디서 자세히 발생했는지 알아야함 23줄 에서 get으로 못꺼내면 NullPointer예외가 발생함
		//null을 int로 받으려고 하니 예외 발생 -> Integer로 변경하면 깔끔해짐
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
