package chapter14;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("MyException 발생 전");
		
		// 예외정보를 가진 나만의 객체를 생성하는것 = throw 사용해서 발생시킴
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("숫자를 입력하세요 >> ");
			int number = scan.nextInt();
			
			if(number % 2 ==0) {
				System.out.println("짝수");
			}else {
				throw new MyException();
			}
		}catch(Exception e) {
			System.out.println("MyException 발생");
		}finally {
			// 예외 발생 여부에 상관없이 항상 동작해야하는 소스코드
			System.out.println("finally 안의 소스코드");
		}
//		System.out.println("MyException 발생 전");
		
	}

}