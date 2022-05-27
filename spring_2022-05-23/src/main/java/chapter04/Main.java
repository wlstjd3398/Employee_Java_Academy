package chapter04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;
import exception.WrongIdPasswordException;

public class Main {
	// Assembler를 매개변수로
	private static ApplicationContext ctx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Scanner scanf = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력하세요 : ");
			String command = scanf.nextLine();
		
			if(command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			// startsWith("new ")는 new라는 것으로 시작을 하나요?
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}else if(command.startsWith("list")) {
				processListCommand();
			}else if(command.startsWith("info")) {
				processInfoCommand(command.split(" "));
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
		System.out.println("list ");
		System.out.println("info 이메일");
		System.out.println();
	}

	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean("memberRegisterService", MemberRegisterService.class);
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
		
		ChangePasswordService pwdSvc = ctx.getBean("changePasswordService", ChangePasswordService.class);
		
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
	
	
	private static void processListCommand() {
		MemberListPrinter memberListPrinter = ctx.getBean("memberListPrinter", MemberListPrinter.class);
		
		memberListPrinter.printAll();
	}
	
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		
		try {
			MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
			
			memberInfoPrinter.printMemberInfo(arg[1]);
		} catch(MemberNotFoundException e){
			System.out.println("존재하지 않는 이메일입니다.");
			System.out.println();
		}
	}
}
