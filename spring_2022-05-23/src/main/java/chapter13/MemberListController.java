package chapter13;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MemberListController {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	@GetMapping("/members")
	public String list(@ModelAttribute("cmd")ListRequest listRequest) {
		return "member/list";
	}
	
}
