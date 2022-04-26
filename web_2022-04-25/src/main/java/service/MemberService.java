package service;

import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


// POJO(Plain Old JAva Ojbect)
// 순수 자바로만 이루어진 소스 파일
public class MemberService {
	
	public static final int JOIN_SUCCESS = 201;
	public static final int JOIN_FAIL = 409;
	// 이렇게 멤버변수를 활용해서 가독성 좋게 불러오게함
	
	public boolean login(MemberDTO memberDto) {
		// 로그인 처리
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO selectMemberDto = dao.selectMemberInfo(memberDto);
		
		if(selectMemberDto == null) {
			// 로그인 실패 처리
			return false;
		}else {
			// 로그인 성공 처리
			return true;
		}
	
	}

	public int join(MemberDTO newMemberInfo) {
		
		// 회원 가입 처리
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.insertMemberInfo(newMemberInfo);
		
		// 회원 가입 처리 결과 반환
		//각 상황에 맞는 결과 반환할수있게함
		// 회원 가입 성공 : ~~ 반환
		// 회원 가입 실패
		// 1. 이미 사용중인 아이디 : ~~ 반환
		
//		return result; // 성공과 실패 두가지니 return으로 반환도 괜찮음
		// 상태코드로 반환하는 방법도 있음
		// 상태코드 200번대에서 201(성공적으로 요청되었으며 서버가 새 리소스를 작성했따)으로 반환하는 것도 좋음
		// 상태코드 400번대에서 409(충돌 : 서버가 요청을 수행하는 중에 충돌이 발생했다)
		
		if(result) {
//			return MemberService.JOIN_SUCCESS;
			// 위처럼 직접 만드는 것도 좋지만
			
			return HttpServletResponse.SC_CREATED;
			// 위처럼 공식적으로 사용하는 상태코드들을 불러 올 수 있음
			
		}else {
//			return MemberService.JOIN_FAIL;
			// 정수를 반환하니까 void를 int로 수정
			
			return HttpServletResponse.SC_CONFLICT;
		}
		
		
		// DB연결
		
		// 쿼리 생성
		
		// 쿼리 실행
		
		// ...
		
		// ...
		
		// 쿼리 해제
		
		// DB 연결 해제
	
	}
}
