package chapter04;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chapter04"}
		)
// type 정규표현식으로 필터를 지정하겠다
// pattern chapter04\\..*Dao chapter04로 시작해서 Dao로 끝나는 것들을 제외대상으로 지정하는 정규표현식  
// \\는 동작할때 \ 하나로 인식

// 두번째 필터방법은 정규표현식을 사용안하고 제외대상을 여러개면 배열{ , }로, 한개면 위처럼 사용하면 됨 
public class AppContext2 {


	@Bean
	public DateTimeFormatter dtf() {
		return DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 HH시 mm분 ss초");
	}
	
	// 직접 등록한 MemberDao도 있고 컴포넌트 스캔 자동으로 한 것이 있으면
	// 컴포넌트 스캔의 대상이 되는 빈과
	// 수동으로 등록한 빈의 이름이 같아서 충돌이 발생하면
	// 예외는 발생하지 않고 수동으로 등록한 빈이 살아남음
	
		
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	@Qualifier("printer2")
	public MemberSummaryPrinter memberSummaryPrinter() {
		return new MemberSummaryPrinter();
	}
	
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		
		return memberInfoPrinter;
	}
	
	
	
	
	
}
