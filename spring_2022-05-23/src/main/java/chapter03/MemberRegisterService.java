package chapter03;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exception.DuplicateMemberException;

public class MemberRegisterService {

	// 자동 의존 주입 대상 객체에  @Qualifier 애노테이션을 사용하면
	// 이러한 한정자를 갖는 Bean 객체를 자동 의존 주입해라가 됨
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;
	
//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	public long regist(RegisterRequest req) throws DuplicateMemberException{
		// 이메일로 회원 정보 조회
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			// 같은 이메일을 가진 회원이 존재한다면 예외 발생
			throw new DuplicateMemberException("이미 사용중인 이메일입니다.");
		}
		
		// 같은 이메일을 가진 회원이 존재하지 않으면 DB에 저장
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		
		memberDao.insert(newMember);
		
		return newMember.getId();
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
