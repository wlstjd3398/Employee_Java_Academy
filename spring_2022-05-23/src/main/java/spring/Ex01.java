package spring;

public class Ex01 {

	public static void main(String[] args) {
		
//		MemberDao memberDao = new MemberDao();
		// 이렇게 MemberDao를 불러오는게 아니가
		Assembler assembler = new Assembler();
		
		
		
		// 생성자 이용해서 의존주입
//		MemberRegisterService mrs = new MemberRegisterService(memberDao);
		
		MemberRegisterService mrs = assembler.getRegSvc();
		
		
		
		
		// 객체 생성해서 의존주입
		// 별로 패키지를 만드는 것이 좋음 -> 팩토리메서드
//		ChangePasswordService cps = new ChangePasswordService();
//		cps.setMemberDao(memberDao);
		
		ChangePasswordService cps = assembler.getPwdSvc();
		
		
	}

	
	
	
}
