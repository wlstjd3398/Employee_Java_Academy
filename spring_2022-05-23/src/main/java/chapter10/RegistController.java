package chapter10;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// GetMapping, PostMapping, ... 애노테이션 -> 스프링 4.3버전에서 추가된 것
// 스프링 4.3 미만의 버전에서는 @RequestMapping 밖에 없음
// 정해진 mapping만 쓰고싶은 경우에는 속성 value와 method를 사용
//@RequestMapping(value="/step3", method=RequestMethod.POST) 이런 형식으로 사용

@Controller
// register로 시작하는 것을 뺄수있음
@RequestMapping("/register")
public class RegistController {

	// 이 경로로 들어오는 GET 요청 처리
	// 경로 하나가 딱 정해진건 아님 클라이언트도 get말고 post도 같이 step1로 접근가능함
	@GetMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}
//	@PostMapping("/step1")
//	public String handleStep1() {
//		return "register/step1";
//	}
	
	// 이 경로로 들어오는 POST 요청 처리
	@PostMapping("/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		// 클라이언트가 보낸 값 (agree이름을 가짐 매개변수 HttpServletRequest request으로 가져옴)을 사용
		// String agreeParam = request.getParameter("agree");
		
		// if(agreeParam == null || !agreeParam.equals("true"))
		
		
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	@GetMapping("/step2")
	public String handleStep2Get() {
		// 뷰 페이지를 반환하면 RequestDispatcher의 forward 방식으로 뷰를 보여줌
		// -> 지금 이 상황이 적합하지 않음 -> 매개변수에 HttpServletResponse response를 사용하거나
		// 아래처럼 redirect:/ 를 붙여주면 URL로 이동해도 step1으로 가는걸 볼수있음
		return "redirect:/register/step1";
	}
	
	// 이 경로로 들어오는 모든 요청을 처리하겠다
//	@RequestMapping("/step3")
	@RequestMapping(value="/step3", method=RequestMethod.POST)
	public String handleStep3(RegisterRequest regReq) {
			
//			@RequestParam(value="email") String email,
//								@RequestParam(value="name") String name,
//								@RequestParam(value="password") String password,
//								@RequestParam(value="confirmPassword") String confirmPassword) {
//		// 클라이언트가 보내는 데이터를 꺼내서 출력하세요
//		System.out.println("email = " + email);
//		System.out.println("name = " + name);
//		System.out.println("password = " + password);
//		System.out.println("confirmPassword = " + confirmPassword);
//		
//		RegisterRequest regReq = new RegisterRequest();
//		regReq.setEmail(email);
//		regReq.setName(name);
//		regReq.setPassword(password);
//		regReq.setConfirmPassword(confirmPassword);
		
		// ...
		
		
		// DB를 활용한 회원가입
		
		
		// ...
		
		
		
		return "register/step3";
	}
	
}
