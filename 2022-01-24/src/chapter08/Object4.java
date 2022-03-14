package chapter08;


// 두개의 정수를 전달 받아 더한 결과를 출력하는 메서드를 선언해라
public class Object4 {

	void sum(int number1, int number2) {
		System.out.println(number1 + number2);
	}
	
// 두개의 정수를 전달 받아 두 정수 중 큰 수를 출력하는 메서드
	void big(int num1, int num2) {
		if(num1>=num2) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}
		
	}
	
}
