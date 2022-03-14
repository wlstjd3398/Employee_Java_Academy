package chapter13;

public interface Calculatorable {

	// 멤버변수
//	어디서든접근가능한 클래스멤버변수 상수화된 데이터타입 변수이름;
//	접근제어자 데이터타입 변수이름;
	
	// 인터페이스에는 상수화된 멤버변수(public static final ~)와 추상메서드(abstract가 있으면 소스코드 없음)가 필수
	public static final int value = 10;
	
	
	// 추상메서드
	// 덧셈
	public abstract int plus(int num1, int num2);
	// 뺄셈
	public abstract int minus(int num1, int num2);
	// 곱셈
	public abstract int multiply(int num1, int num2);
	// 나눗셈
	public abstract int division(int num1, int num2);
	
}
