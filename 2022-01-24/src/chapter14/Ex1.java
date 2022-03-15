package chapter14;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.print("분자 >>");
		int val1 = scan.nextInt();
		
		System.out.print("분모 >>");
		int val2 = scan.nextInt();
		
		if(val2==0) {
			System.out.println("분모는 0일 수 없습니다.");
		}else {
//			int result = val1 / val2;
//			System.out.println("result = " + result);
		}
		// if예외처리끝
		
		// 예외처리 try catch
		try {
			int result = val1 / val2;
			System.out.println("result = " + result);
			System.out.println("try 끝");
		}catch(ArithmeticException e) {
			System.out.println("분모는 0일 수 없습니다.");
			System.out.println("catch 끝");
		}
		System.out.println("try 후");
		
		
	}

}