package chapter08;

public class Ex6 {

	// 메서드는 변수와 마찬가지로
	// 기본적으로 중복해서 선언할 수 없음
	// 중복이라는 의미가 메서드랑 변수가 다름
	// 변수는 데이터 타입이 달라도 이름이 같은 변수는 중복 선언으로 판단
	
	// 메서드는 메서드 이름이 같아도 매개변수의 개수나 타입이 다르면 중복으로 판단하지 않음
	
	// 메서드중복아님
	void func() {
		System.out.println("func");
	}
	
	void func(int num) {
		System.out.println("func");
	}
	
	void func(double num) {
		System.out.println("func");
	}

	
	// 변수 중복임, 메서드중복아닌거 확인
	public static void main(String[] args) {
		int num = 1;
		
//		double num = 1;
		
		Ex6 ex = new Ex6();
		
		ex.func();
		ex.func(3);
		ex.func(3.14);	
	}
}