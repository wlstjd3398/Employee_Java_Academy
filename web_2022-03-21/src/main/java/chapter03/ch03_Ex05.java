package chapter03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url은 이런식으로 구성됨 http://192.168.10.178/ch03_ex05?id=abcd&pw=1234
@WebServlet(name="/ch03_Ex05", urlPatterns= {"/ch03_ex05"})
public class ch03_Ex05 extends HttpServlet {
       
// 요청정보안에 이름으로 받는법
	//doGet방식으로 name과 value과 한쌍으로 전달이 됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//문자열로 꺼내줌
		
		System.out.println("클라이언트가 전달한 id값 = " + id);
		System.out.println("클라이언트가 전달한 pw값 = " + pw);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
