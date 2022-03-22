package chapter01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //직렬화 때문에 필요한 데 쓸일이 없음

    public Ex01() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		// response라는 객체를 set메서드로 클라이언트한테 전달 UTF-8이라는 것으로 포장했다(문자 인코딩)
		response.getWriter().append("Ex01 서비스를 이용해주셔서 감사합니다!");
		// response라는 객체를 getWriter메서드로, append메서드이용하여 (" ")추가한다 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
