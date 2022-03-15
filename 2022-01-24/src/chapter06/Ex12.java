package chapter06;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 구구단 2단, 3단, 4단, ... 을 출력하는 프로그램 for문으로 개발해라(중첩for문설명)
//		for(int num=1; num<=9; num++) {
//			System.out.println("2 * " + num + " = " + (2 * num));
//		}
//		for(int num=1; num<=9; num++) {
//			System.out.println("3 * " + num + " = " + (3 * num));
//		}
//		for(int num=1; num<=9; num++) {
//			System.out.println("4 * " + num + " = " + (4 * num));
//		}
//		for(int num=1; num<=9; num++) {
//			System.out.println("5 * " + num + " = " + (5 * num));
//		}
		
		
		// 중첩 for문
		for(int front=2; front<=9; front++) {
			for(int back=1; back<=9; back++) {
				System.out.println(front + " * " + back +" = " + (front * back));
			}
		}
		
		
		
	}

}