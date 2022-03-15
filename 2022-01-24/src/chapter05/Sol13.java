package chapter05;

import java.util.Scanner;

public class Sol13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Sol12번을 if문으로 고쳐라
		// 나눗셈을 할 경우 분모가 0이면 프로그램이 비정상적으로 종료됨
		// 나눗셈을 할 때 분모가 0이라면 "분모는 0일 수 없습니다"를 추가해서 if문 바꿔라
		
		Scanner scanf = new Scanner(System.in);
		System.out.print("첫번째 값을 입력해라 -->");
		int num1 = scanf.nextInt();
		
		System.out.print("두번째 값을 입력해라 -->");
		int num2 = scanf.nextInt();
		
		System.out.print("연산자를 (+, -, *, /) 중 하나를 입력해라 -->");
		char operator = scanf.next().charAt(0);
		
		int result = 0;
		
		if(operator == '+') {
			System.out.println(num1 + " " + operator + " " + num2 + " == " + (num1 + num2));
		}else if(operator == '-'){
			System.out.println(num1 + " " + operator + " " + num2 + " == " + (num1 - num2));
		}else if(operator =='*') {
			System.out.println(num1 + " " + operator + " " + num2 + " == " + (num1 * num2));
		}else if(operator == '/') {
			if(num1 == 0) {
				System.out.println("분모가 0일 수 없습니다");
				return;
			}
			System.out.println(num1 + " " + operator + " " + num2 + " == " + (num1 / num2));
		}
		
		
		
		
	}

}