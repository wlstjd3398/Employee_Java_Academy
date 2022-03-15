package chapter05;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		
		System.out.println("----자판가----");
		
		System.out.println("1.콜라");
		System.out.println("2.콜라");
		System.out.println("3.환타");
		System.out.println("4.사이다");
		System.out.println("5.사이다");
		System.out.println("6.사이다");
		System.out.println("7.마운틴듀");
		
		System.out.println("메뉴선택 해주세요(1 ~ 7) ->");

		int menu = scanf.nextInt();
		switch(menu) {
			case 1:
			case 2:
				System.out.println("콜라가 나왔습니다.");
				break;
				
			case 3:
				System.out.println("환타가 나왔습니다.");
				break;
				
			case 4:
			case 5:
			case 6:
				System.out.println("사이다가 나왔습니다.");
				break;
			
			case 7:
				System.out.println("마운틴듀가 나왔습니다.");
				break;
				
			default :
				System.out.println("잘못 입력하셨습니다. 올바른 숫자를 입력해주세요");
				break;
		}
	}

}