package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex12", urlPatterns = { "/ch06_Ex12" })
public class Ex12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("! ch06_Ex12 Servlet !");
		
		request.setAttribute("name", "value1");
		
		//close전에 forward해야함 응답이 나가기전에 실행해야함
		//forward, include 둘 중 하나 사용함
		RequestDispatcher rd = request.getRequestDispatcher("/ch06_Ex11");
		rd.include(request, response);
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
