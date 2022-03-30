package jquery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jquery/second")
public class Second extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 첫 번째 컨텐츠를 DB에서 불러옴
		// 2초간 기다리게 함
		try {
		Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//불러온 첫 번째 컨텐츠를 클라이언트에게 전달
		response.setStatus(500); // 400번 코드로 응답함
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
