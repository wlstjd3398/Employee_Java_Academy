package chapter05;

import java.util.Scanner;

public class Sol19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		System.out.println("id와 pw를 입력해야합니다");
		System.out.print("id를 입력해주세요--> ");
		String id = scanf.next();
		System.out.print("pw를 입력해주세요--> ");
		String pw = scanf.next();
		
		
		int idlen = id.length();
		int pwlen = pw.length();
		
		
		if(idlen >= 4 && idlen <= 16) {
			System.out.println("등록한 아이디의 길이가 일치합니다.");
		}else {
			System.out.println("등록한 아이디의 길이가 일치하지 않습니다.");
		}
		
		
		if(pwlen >= 6 && pwlen <= 16) {
			System.out.println("등록한 패스워드의 길이가 일치합니다.");
		}else {
			System.out.println("등록한 패스워드의 길이가 일치하지 않습니다.");
		}
		
		
	}

}