package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	// 스프링이 자동으로 멤버변수에 의존주입을 함
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
	}
	
}
