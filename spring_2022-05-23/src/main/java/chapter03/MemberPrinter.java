package chapter03;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	// 자동 의존 주입이 선택사항 일때 멤버변수에 이와 같이 붙일수 있음
	// @Autowired(required = false)
	// 또는
	// @Autowired
	// @Nullable
	
	@Autowired
	@Nullable
	private DateTimeFormatter dtf;

	public void print(Member member) {
		String text1 = "아이디="+ member.getId();
		String text2 = "이메일="+ member.getEmail();
		String text3 = "이름="+ member.getName();
		String text4 = "등록일="+ member.getRegisterDateTime();
		
		if(dtf != null) {
			// dtf가 null이 아니라면 dtf에 설정된 날짜 형식으로 등록일을 보여주겠다
			text4 = "등록일=" + dtf.format(member.getRegisterDateTime());
		}
		
		String text = "회원 정보 : "+ text1 + ", "+ text2 + ", " + text3 + ", "+ text4;
		
		System.out.println(text);
	}

	// required = false -> 자동 의존 주입이 선택사항이 됨1
//	@Autowired(required = false)
//	public void setDateTimeFormatter(DateTimeFormatter dtf) {
//		this.dtf = dtf;
//	}
	
	// 매개변수앞에 @Nullable -> 자동 의존 주입이 선택사항이 됨2
//	@Autowired
//	public void setDateTimeFormatter(@Nullable DateTimeFormatter dtf) {
//		this.dtf = dtf;
//	}
	
}
