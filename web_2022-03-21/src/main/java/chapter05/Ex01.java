package chapter05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet{
	private int value;
	private String name;

	// HttpServlet 호출시 doget 
	
	//오버라이딩 저번과는 다른 매개변수가 있는 init을 생성(서블릿이 생성되면서 담기는 변수를 사용하기위해서)
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 생성");
		
		String value = config.getInitParameter("value");
		//int value 가 아니라 String인 이유는 Parameter가 어떤 변수이든 문자열로 리턴해줌
		
		System.out.println("value = " + value);
		
		//value 변수 안에는 숫자처럼 생긴 문자열이 있습니다.
		//value 변수 안에는 들어있는 값을 정수로 바꿔 value 멤버 변수에 저장하세요
		
		//래퍼클래스 parseInt 사용
//		Integer.parseInt(value);
		
		//래퍼클래스(chapter16)
//		Integer temp = new Integer(value);
		
		
		
		this.value = Integer.parseInt(value);
	}

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		
		//클라이언트가 요청한것을  꺼내기위해
		req.setCharacterEncoding("UTF-8");
		
		//name 멤버변수를 사용하도록 바꿈 String name -> name
		//servlet의 name 멤버변수를 사용하면 프로세스가 관리를 함
		//(서블릿의 멤버변수는 서블릿 프로세스 만들어지는 시점에 만들어지고 프로세스에 만들어짐)
		//프로세스가 갖고있던 멤버변수를 호출시키게됨
		
		name = req.getParameter("name");
		
		//쓰레드에 sleep메서드로 밀리초만큼 멈추기(밀리초) -> 예외처리해야 컴파일오류풀림
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//내가 응답할 것을 클라이언트가 잘꺼내서 쓸수있게
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("당신이 전달한 name 파라미터 값은 [ " + name + " ] 입니다.");
		
		System.out.println("init-param 태그로 전달 받은 value의 값 => " + value);
	}

	
	
	
	
}
