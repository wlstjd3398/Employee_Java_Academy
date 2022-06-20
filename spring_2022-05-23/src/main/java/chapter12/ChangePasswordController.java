package chapter12;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePasswordController {

	@GetMapping("/edit/changePassword")
	public String edit(@ModelAttribute("command") ChangePasswordRequest changePasswordRequest) {
		// 커맨드객체 이름이 command였으니 modelAttribute로 간단히 만들어줌
		// 뷰로 만드는게 있으나 이것보다는 번거로움
		
		return "edit/changePwdForm";
	}
	
	
}
