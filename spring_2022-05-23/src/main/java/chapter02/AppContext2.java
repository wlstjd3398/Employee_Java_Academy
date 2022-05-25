package chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//의존 객체를 빈으로 등록하는 컨텍스트
@Configuration
public class AppContext2 {
	
	// 멤버변수에도 annotation이 붙었음
	// 자동 의존 주입 애노테이션 = Autowired
	// 설정클래스에서 해당 타입의 데이터를 
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;

	
	// 아래는 수동으로 의존주입하게 작성
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		// 세터방식을 지워도 autowired 덕분에 의존주입을 하도록 해줌
//		memberInfoPrinter.setMemberDao(memberDao);
//		memberInfoPrinter.setMemberPrinter(memberPrinter);
		
		
		return memberInfoPrinter;
	}
	
}
