package chapter06;

import java.util.Scanner;

public class Sol8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		
		System.out.println("id를 입력해주세요. 최소 4자 ~ 최대 16자 입니다.");
		String id = scanf.next();
		System.out.println("pw를 입력해주세요. 최소 6자 ~ 최대 16자 입니다.");
		String pw = scanf.next();
		
		int idLen = id.length();
		int pwLen = pw.length();
		
		// 아스키코드로 string상태를 각각 한자리씩 검사?
		
		if(idLen >= 4 && idLen <= 16) {
			if(int id >= 0x30 && id <= 0x39) {
				System.out.println("자리수 제한과 아이디 영문 대소문자와 숫자 조건에 만족합니다.");
			}else {
				System.out.println("아이디 영문 대소문자와 숫자 조건에 만족해야합니다.");
			}
		}
		
		// 정규식?
		if(pwLen >= 6 && pwLen <= 16) {
			if(pw=="^[A-Za-z[0-9]]{10,20}$") {
				System.out.println("자리수 제한과 비밀번호 영문 대소문자와 숫자 조건에 만족합니다.");
			}else {
				System.out.println("비밀번호 영문 대소문자와 숫자 조건에 만족해야합니다.");
			}
		}
		
		
		
	}

}