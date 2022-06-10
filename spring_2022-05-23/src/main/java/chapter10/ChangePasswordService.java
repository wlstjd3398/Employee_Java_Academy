package chapter10;

import org.springframework.transaction.annotation.Transactional;

import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

public class ChangePasswordService {
	private MemberDao memberDao;
	// 스프링이 자동으로 멤버변수에 의존주입을 함
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 트랜잭션으로 묶고 싶은 메서드의 @Transactional 애노테이션을 붙여주면
	// 스프링이 알아서 트랜잭션 기능을 붙여줌
	// 메서드 안의 코드가 정상적으로 동작해서 컴퓨터가 메서드 끝까지 도달했다면 commit이 이뤄지고
	// 메서드 안의 코드가 동작하다 예외가 발생하면 rollback이 이루어짐
	@Transactional
	public void changePassword(String email, String oldPw, String newPw) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
	}
	
}
