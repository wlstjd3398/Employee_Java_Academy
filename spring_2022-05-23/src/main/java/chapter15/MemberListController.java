package chapter15;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;

// 뷰 대신 JSON을 반환하는 컨트롤러
@RestController
public class MemberListController {
	private MemberDao memberDao;
	private MemberRegisterService memberRegSvc;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberRegSvc(MemberRegisterService memberRegSvc) {
		this.memberRegSvc = memberRegSvc;
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
	public ResponseEntity<Object> detail(@PathVariable("id") long memberId, HttpServletResponse response) {
//		매개변수로 Member를 사용하면 덩치가 너무큼(사용하지 않는 것도 사용하게됨)
		
		Member member = memberDao.selectById(memberId);
		if(member == null) {
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("not found"));
			
//			return null;
		}
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(member);
		
//		return member;
	}
	
	// 컨트롤러 내에서만 handleNotFound 사용가능
	// -> 글로벌 예외처리기에 사용하면 글로벌로 컨트롤안뿐만아니라 전체적으로 사용가능
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<Object> handleNotFound(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseMessage("not found"));
	}
	
	
	@PostMapping("/member")
	public ResponseEntity<Object> newMember(@RequestBody RegisterRequest regReq, HttpServletResponse response) {
		try {
			
			long newMemberId = memberRegSvc.regist(regReq);
			
//			response.sendRedirect("http://localhost/spring_2022-05-23/member/" + newMemberId);
			
//			response.setHeader("Location", "http://localhost/spring_2022-05-23/member/" + newMemberId);
//			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); // 상태코드 302
			
			ResponseEntity<Object> re = ResponseEntity
					.status(HttpServletResponse.SC_MOVED_TEMPORARILY)
					.header("Location", "http://localhost/spring_2022-05-23/member/" + newMemberId)
					.build();
			return re;
			
//		}catch(IOException e) {
//			// sendRedirect에서 알 수 없는 예외가 발생했을 때
//			e.printStackTrace();
		}catch(DuplicateMemberException e) {
			// regist메서드에서 예외 발생
//			response.setStatus(HttpServletResponse.SC_CONFLICT); // 상태코드 409
			
			
//			try {
//				response.sendError(HttpServletResponse.SC_CONFLICT); // 상태코드 409
			// setStatus 대신 sendError 사용해서 상태코드를 응답하면 상태 코드만 응답되는게 아니라
			// 서버 설정에 따라서 상태 코드에 맞는 기본 에러 페이지가 같이 응답될 수 있음
				
				// 서버가 클라이언트에게 결과를 응답할 때 일관되게 하나의 방법으로만 응답하는게 좋음
				// 안그러면 클라이언트 쪽에서 상황에 맞는 응답 방법별로 나눠서 처리를 해야하므로 
				// 나는 협업하기 어려운 개발자가 됨
				// 일관되게 동작하게 하는게 중요함 void 대신 ResponseEntity<Object>를 사용해서 일관되게 할수있음
				
				
//				ResponseEntity<Object> re = ResponseEntity.status(HttpServletResponse.SC_CONFLICT).build();
				
				// 데이터를 담아서 전달하고 싶을때는 아래방식으로 하는데 
				// contenttype으로 어떤 형식의 데이터를 사용할지 적을수있음
				ResponseEntity<Object> re = ResponseEntity
						.status(HttpServletResponse.SC_CONFLICT)
						.contentType(MediaType.TEXT_PLAIN)
						.body("already used email");
				
				return re;
			
//			} catch(IOException e1) {
//				e1.printStackTrace();
//			}
			
			
		}
		
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
