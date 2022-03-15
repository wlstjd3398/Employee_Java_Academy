package chapter05;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner 라이브러리 -> 사용자에게 값을 입력 받기 위한 기능들이 들어있음, 인스턴스 = Scanner가 scanf를 구체화시켰다
		// scanf. = .안에라는 뜻으로, nextInt 안에 정수를 받아본다
		
		Scanner scanf = new Scanner(System.in);
		
		System.out.println("철수의 국어점수를 입력하세요 -> ");
		
		int kor = scanf.nextInt();
		
		System.out.println("실수 입력 -> ");
		double num = scanf.nextDouble();
		
		System.out.println("문자열 입력 -> ");
		String str = scanf.next();
		
		System.out.println("문자 입력 -> ");
		char ch = scanf.next().charAt(0);
		
		System.out.println("철수의 국어점수 = " + kor);
		
		
				
				
				
	}

}