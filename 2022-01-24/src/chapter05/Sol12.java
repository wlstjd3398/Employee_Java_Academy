package chapter05;

import java.util.Scanner;

public class Sol12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자에게 입력을 받기 위한 scanf 객체 생성
				Scanner scanf = new Scanner(System.in);
				
				System.out.print("첫 번째 값 입력 >> ");
				int num1 = scanf.nextInt();
				
				System.out.print("두 번째 값 입력 >> ");
				int num2 = scanf.nextInt();
				
				System.out.print("연산자 입력 >> ");
				char operator = scanf.next().charAt(0);
				
				int result = 0;
				switch(operator) {
					case '+':
						result = num1 + num2;
						break;
					case '-':
						result = num1 - num2;
						break;
					case '*':
						result = num1 * num2;
						break;
					case '/':
						result = num1 / num2;
						break;
				}
				
				System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

		
	}

}