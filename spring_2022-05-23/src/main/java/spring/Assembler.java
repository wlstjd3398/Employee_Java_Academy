package spring;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		
		regSvc = new MemberRegisterService(memberDao);
		
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
				
	}

	// 게터만 불러오는 경우 select getters 클릭
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
}
