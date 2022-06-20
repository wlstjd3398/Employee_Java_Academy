package chapter12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	// 컨트롤러가 service에 의존주입

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginRequest loginRequest) {
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginRequest loginRequest, Errors errors, HttpSession session) {
		new LoginRequestValidator().validate(loginRequest, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			AuthInfo authInfo = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
		
			session.setAttribute("authInfo", authInfo);
			
			return "login/loginSuccess";
			
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			
			return "login/loginForm";
		}
	}
	
}
