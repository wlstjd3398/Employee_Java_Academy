package chapter03;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자동 의존 주입을 적용하려면 컨테이너가 자동 의존 주입 타입의 빈을 가지고 있어야함
// 자동 의존 주입을 할때는 자동 의존 주입 대상 객체의 타입을 봄


// 이 클래스를 스프링 설정 클래스로 지정하는 애노테이션
@Configuration
public class AppContext {

	// 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록
	
	// Assembler의 역할을 appcontext가 할수있게함

	@Bean
	public DateTimeFormatter dtf() {
		return DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 HH시 mm분 ss초");
	}
		
	// Bean 객체에 @Qualifier 애노테이션을 사용해서 Bean 객체에 별명을 달아줄 수 있음
	@Bean
	@Qualifier("memberDao")
	public MemberDao memberDao1() {
		return new MemberDao();
	}
	
//	@Bean
//	public MemberDao memberDao2() {
//		return new MemberDao();
//	}

	// 자바의 상속과 다형성 때문에 빈 객체의 타입이 다르지만
	// 자동 의존 주입을 할 때 스프링이 빈 객체의 타입을 혼동함
	// 이때도 한정자를 사용해서 어떤 빈 객체를 사용할지 지정
	
	@Bean
	@Qualifier("printer1")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("printer2")
	public MemberSummaryPrinter memberSummaryPrinter() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());
		
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//		memberInfoPrinter.setMemberDao(memberDao());
//		memberInfoPrinter.setMemberPrinter(memberPrinter());
		
		
		return memberInfoPrinter;
	}
	
	
	
	
	
}
