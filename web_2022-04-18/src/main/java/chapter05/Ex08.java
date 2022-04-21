package chapter05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;

@WebServlet("/chapter05/ex08")
public class Ex08 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int[] arr = new int[3];
		
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		
//		request.setAttribute("arr", arr);
		
		List<BookBean> bookList = new ArrayList<>();

		BookBean b1 = new BookBean();
		b1.setTitle("자바 웹을 다루는 기술");
		b1.setAuthor("이병승");
		b1.setPublisher("길벗");
		
		BookBean b2 = new BookBean();
		b2.setTitle("JSP & Servlet 웹 프로그래밍 입문");
		b2.setAuthor("정동진, 최주호, 윤성훈");
		b2.setPublisher("앤써북");
		
		bookList.add(b1);
		bookList.add(b2);
		
		request.setAttribute("bookList", bookList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/chapter05/Ex08.jsp");
		rd.forward(request, response);
		
		
		
	}


}
