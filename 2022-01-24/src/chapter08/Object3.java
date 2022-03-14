package chapter08;

public class Object3 {

	// 매개변수는 이 메서드를 호출할 때 반드시 전달해야하는 값의 타입과 개수를 나타냄
	
	// 매개변수 타입 없음, 값을 전달하면 안된다
	void  printLines1() {
		System.out.println("printLines1 메서드 호출");
	}
	
	
	// 매개변수 타입 int, 개수 1개
	// 매개변수가 있다면 매개변수도 가지고 출력됨
	void printLines2(int n) {
		System.out.println("printLines2 메서드 호출");
		System.out.println("매개변수 n = " + n);
	}
	
	// 매개변수 타입 double, 개수 1개
	void printLines3(double n) {
		System.out.println("printLines3 메서드 호출");
		System.out.println("매개변수 n = " + n);
	}
	
	// 매개변수 타입 int, 개수 2개
	void printLines4(int x, int y) {
		System.out.println("printLines4 메서드 호출");
		System.out.println("매개변수 x = " + x);
		System.out.println("매개변수 y = " + y);
	}
	
	
}
