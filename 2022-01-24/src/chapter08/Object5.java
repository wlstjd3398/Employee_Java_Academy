package chapter08;

public class Object5 {

	// 두 정수를 전달받아 두 정수 중 큰 수를 호출 한쪽으로 되돌려주는 메서드
	int big(int num1, int num2) {
		if(num1 >= num2) {
			return num1;
		}else {
			return num2; // return 을 만나서 메서드의 끝으로, Ex4로 가서 해당부분을 반환한다
			// 그리고 밑으로 쭉 내려감
		}
	}
	
	
	// 하나의 정수를 전달 받아 
	// 그 수가 짝수라면 짝수
	// 홀수라면 홀수
	// 호출한쪽을 되돌려주느 메서드
	String compare(int a) {
		if(a % 2 == 0) {
			return "짝수";
		}else {
			return "홀수";
		}
	}
	
	
	void sum() {
		System.out.println(1 + 1);
	}
	
	// 메서드의 반환타입이 void가 아니면
	// 반환타입이 있는 메서드다 라고 표현(= void 안쓴다면 return이 있다)
	// 반환타입 -> 메서드를 호출하면 반환 타입과 일치하는 타입의 데이터가 반환된다, return이 int(정수 중에 하나)와 한쌍
	// 반환타입이 있는 메서드 = return 무조건 있어야함
	int sum2() {
		System.out.println(3);
		
		return 3;
		
	}
	
	
	double sum3() {
		
		return 170.6;
		
	}
}