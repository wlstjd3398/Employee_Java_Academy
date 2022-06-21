package chapter12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

@Controller
public class ChangePasswordController {
	private ChangePasswordService changePasswordService;
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	
	@GetMapping("/edit/changePassword")
	public String edit(@ModelAttribute("command") ChangePasswordRequest changePasswordRequest, HttpSession session) {
		// 커맨드객체 이름이 command였으니 modelAttribute로 간단히 만들어줌
		// 뷰로 만드는게 있으나 이것보다는 번거로움
		
		// 세션에 들어있는 로그인 상태 정보를 꺼내기(AOP이용해서 로그인정보를 여기저기서 사용할수있게 인터셉터할 예정)
//		AuthInfo authInfo = (AuthInfo) session.getAttribute("AuthInfo");
//		
//		if(authInfo == null) {
//			return "redirect:/login";
//		}
		
		return "edit/changePwdForm";
	}
	
	@PostMapping("/edit/changePassword")
	public String success(@ModelAttribute("command") ChangePasswordRequest changePasswordRequest, Errors errors, HttpSession session) {
		new ChangePasswordRequestValidator().validate(changePasswordRequest, errors);
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		
		// 세션에 들어있는 로그인 상태 정보를 꺼내기
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		if(authInfo == null) {
			return "redirect:/login";
		}
		// 로그인 상태 정보의 이메일, 커맨드 객체의 현재 비번, 바꿀 비번을 사용해서
		// ChangePasswordService를 사용해서 비밀번호를 변경하세요
//			ChangePasswordService service = new ChangePasswordService();
		// 의존하고 있으니 의존하는 객체는 세터방식으로 의존주입을 위private처럼 해준다
		
		try {
			changePasswordService.changePassword(authInfo.getEmail(), changePasswordRequest.getCurrentPassword(), changePasswordRequest.getNewPassword());
			
			return "edit/changedPwdSuccess";
//		}catch(MemberNotFoundException e) {
			// MemberNotFoundException 예외는 발생하지 않음
			// 이유는?
				// 언제 MemberNotFoundException가 생기는지 보면 알 수 있음
				// changePassword에서 예외가 발생하는데 session에 들어있는 로그인 상태정보를 사용하기에 
			
		}catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			
			return "edit/changePwdForm";
		}
		// 위 방법은 스프링 문법에 어긋남
		
		
		
		// 비밀번호 변경하기 다 해결한 분은 비밀번호가 변경되는지 테스트
		
		// 그 후 로그아웃을 하고 비밀번호 변경 페이지 URL을 직접 입력해서 접근한 다음 비밀번호를 변경해라
		
		
		
		
	}
	
}
