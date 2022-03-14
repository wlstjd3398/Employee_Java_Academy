package chapter05;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 철수의 정보를 입력 받는 프로그램을 개발해라
		// 이름 김철수, 나이 23세, 연락처 010-1234-5678, 키 156.7cm, 혈액형 A형
		
		Scanner scanf = new Scanner(System.in);
		System.out.println("철수의 정보를 입력해라.");
		
		String str1 = scanf.next();
		System.out.println("이름  = " + str1);
		
		int age = scanf.nextInt();
		System.out.println("나이 = " + age + "세"); 
		
		String num1 = scanf.next();
		System.out.println("연락처 = " + num1);
		
		double height = scanf.nextDouble();
		System.out.println("키 = " + height);
		
		char blood = scanf.next().charAt(0);
		System.out.println("혈액형 = " + blood + "형");
		
		System.out.println("철수의 모든 정보는 = ");
		System.out.println("이름  = " + str1);
		System.out.println("나이 = " + age + "세"); 
		System.out.println("연락처 = " + num1);
		System.out.println("키 = " + height);
		System.out.println("혈액형 = " + blood + "형");
		
		
	}

}
