package chapter13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	// 컨트롤러가 service에 의존주입함
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginRequest loginRequest,@CookieValue(value="rememberEmail", required=false) Cookie cookie) {
		if(cookie != null) {
			// 쿠키의 값을 불러와서 저장함(ex)a@gmail.com)
			loginRequest.setEmail(cookie.getValue());
			// 이메일 기억하기버튼을 눌렀나요?
			loginRequest.setRememberEmail(true);
		}
		
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginRequest loginRequest, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginRequestValidator().validate(loginRequest, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			AuthInfo authInfo = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
			
			session.setAttribute("authInfo", authInfo);	
			
			// 1. 이메일 기억하기를 눌렀다면(쿠키만들기 이전에 흐름이 중요, 코드말고 흐름!)
			// rememberEmail을 눌렀을때 다음 로그인하기 할때 email이 저장되도록
			if(loginRequest.getRememberEmail()) {
				// 2. 이름이 rememberEmail인 쿠키에 로그인한 사용자의 이메일을 저장
				// 쿠키의 유지 시간은 한 달(30일)
				Cookie c1 = new Cookie("rememberEmail", authInfo.getEmail());
				c1.setMaxAge(60 * 60 * 24 * 30);
				// 초단위 인것을 까먹지 않기
		
				response.addCookie(c1);
			}
			
			return "login/loginSuccess";
			
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			
			return "login/loginForm";
		}
	}
	
}
