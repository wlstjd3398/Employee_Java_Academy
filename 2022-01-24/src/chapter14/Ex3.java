package chapter14;

import java.util.Random;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 예외가 두개
//		ArrayIndexOutOfBoundsException 배열 3번째가 없음
//		ArithmeticException 0으로 나눌수 없다
		
		Random random = new Random();
		
		int[] numberList = {2, 1, 0};
		
		int index = random.nextInt(4);
		
		// try catch 2개
//		int number = 1;
//		try {
//			number = numberList[index];
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열의 인덱스 범위를 벗어났습니다.");
//		}
//		try {
//			int result = 7 / number;
//			System.out.println("7 / " + number + " = " + result);
//		}catch(ArithmeticException e) {
//			System.out.println("분모는 0일 수 없습니다.");
//		}
		
		
		// try catch 한번에 2개 합침
//		try {
//			int number = numberList[index];
//			int result = 7 / number;
//			System.out.println("7 / " + number + " = " + result);
//		}catch(ArithmeticException e) {
//			System.out.println("분모는 0일 수 없습니다.");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열의 인덱스 범위를 벗어났습니다.");
//		}
		
		
		// try catch에서 catch 합치기
		try {
			int number = numberList[index];
			int result = 7 / number;
			System.out.println("7 / " + number + " = " + result);
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			// 앞의 예외가 발생했거나 뒤의 예외가 발생했다면 println 출력
			System.out.println("예외가 발생했습니다.");
		}
		
//		String message = e.getMessage();
//		System.out.println("message = " + message);
//		 메서드를 가지고올때
//		 접근제어자 반환타입 메서드이름(매개변수){
//		 소스코드
//	     }
		 
		 // 반환타입이 String으로 데이터타입을 받음
		 // 예외사유가 리턴됨
//		 e.printStackTrace();
		 // 예외의 상세정보를 알려줌
		
	}

}