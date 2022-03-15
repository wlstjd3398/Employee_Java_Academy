package chapter06;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자에게 문자열을 입력 받아 변수에 저장하고
		Scanner scanf = new Scanner(System.in);
		
		String str = scanf.next();
		
		// 사용자가 입력한 문자열의 처음부터 끝까지
		// 문자 하나씩 접근해서
		for(int i=0; i<str.length(); i++) {
			char n = str.charAt(i);
		
		
		// 사용자가 입력한 문자열의 n번째 문자가
		// 대문자면 소문자로
		// 소문자면 대문자로
		// 변환하는 프로그램을 개발해라
		
		if(n >= 'A' && n <= 'Z') {
			n = (char) (n + 32);
		}else if(n >= 'a' && n <= 'z'){
			n = (char) (n - 32);
		}
		
		System.out.println(n);
		}
		
	}

}