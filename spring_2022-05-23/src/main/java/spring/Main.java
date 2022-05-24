package spring;

import java.util.Scanner;

public class Main {
	// Assembler를 매개변수로
	private static Assembler assembler = new Assembler();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력하세요 : ");
			String commend = scanf.nextLine();
		
			if(commend.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			// startsWith("new ")는 new라는 것으로 시작을 하나요?
			if(commend.startsWith("new ")) {
				processNewCommand(commend.split(" "));
			}else if(commend.startsWith("change ")) {
				processChangeCommand(commend.split(" "));
			}else {
				printHelp();
			}
			
			
		}
	}

	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("<< 명령어 사용법 >>");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}

	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.");
			System.out.println();
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.");
			System.out.println();
		}catch(DuplicateMemberException e) {
			System.out.println("이미 사용중인 이메일입니다.");
			System.out.println();
		}
	}
	
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService pwdSvc = assembler.getPwdSvc();
		
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.");
			System.out.println();
		}catch(MemberNotFoundException e){
			System.out.println("존재하지 않는 이메일입니다.");
			System.out.println();
		}catch(WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
			System.out.println();
		}
		
		
		
		
	}
	
}
