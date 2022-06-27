package chapter15;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 뷰 대신 JSON을 반환하는 컨트롤러
@RestController
public class MemberListController {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	@GetMapping("/members")
	public List<Member> list(@ModelAttribute("cmd")ListRequest listRequest, Errors errors, HttpServletResponse response) {
		new ListRequestValidator().validate(listRequest, errors);
		if(errors.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			// 잘못 호출 했다
			
			return null;
		}
		// 정상작동 상태코드를 200에서 400으로 리턴시켜줌
		
		List<Member> memberList = memberDao.selectByRegdate(listRequest.getFrom(), listRequest.getTo());
		
		return memberList;
	}
	
	// 컨트롤러의 동작 결과를 뷰로 반환하지 말고 JSON으로 반환하도록 수정하세요
	@GetMapping("/member/{id}")
	public Member detail(@PathVariable("id") long memberId, HttpServletResponse response) {
//		매개변수로 Member를 사용하면 덩치가 너무큼(사용하지 않는 것도 사용하게됨)
		
		Member member = memberDao.selectById(memberId);
		if(member == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		return member;
	}
	
	
	// 클라이언트가 보내는 값을 해당 기간에 맞는 회원 정보들을 조회하도록 구현하세요
	// 위와같이 커맨드객체 사용하거나 HtttpServletRequest를 사용해야함
//	@PostMapping("/members")
//	public String search(@ModelAttribute("cmd")ListRequest listRequest, Errors errors, Model model) {
//		// 커맨드 객체를
//		new ListRequestValidator().validate(listRequest, errors);
//		
//		if(errors.hasErrors()) {
//			return "member/list";
//		}
//		
//		// 기간에 맞는 회원정보들을 조회
//		List<Member> memberList = memberDao.selectByRegdate(listRequest.getFrom(), listRequest.getTo());
//		
//		// 조회 결과를 뷰에서 사용하도록 코드를 추가하세요
//		model.addAttribute("members", memberList);
//		
//		System.out.println(memberList);
//		
//		// 조회 결과를 보여줄 뷰를 생성
//		return "member/list";
//		
//	}
	
}
