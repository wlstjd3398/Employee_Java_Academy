package chapter06;

import java.util.Random;
import java.util.Scanner;

public class Sol19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수를 한줄에 하나씩 입력해주세요");
		int i = scan.nextInt();
		int j = scan.nextInt();
		System.out.println("두 정수는 "+ i+" 와"+j+" 입니다.");
		System.out.println("두 정수의 합은 얼마라고 생각하세요?");
		int think=scan.nextInt();
		
		임의의 두 정수는 1 ~ 100 사이에 존재
		정답을 맞추면 반복적으로 문제를 내기
		
		if(think==(i+j)) {
			System.out.println("정답!!");
		}else {
			System.out.println("오답!! 프로그램을 종료합니다.");
		}
		
	}

}
