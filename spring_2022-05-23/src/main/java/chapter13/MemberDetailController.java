package chapter13;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberDetailController {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@GetMapping("/member/{id}")
	public String detail(@PathVariable("id") long memberId, Model model) {
//		매개변수로 Member를 사용하면 덩치가 너무큼(사용하지 않는 것도 사용하게됨)
		
		Member member = memberDao.selectById(memberId);
		if(member == null) {
			return "member/404";
		}
		
		model.addAttribute("member", member);
		
		return "member/detail";
	}
	
//	@ExceptionHandler(TypeMismatchException.class)
//	public String handlerTypeMismatchException(TypeMismatchException e) {
//		return "member/invalid";
//	}
	
}
