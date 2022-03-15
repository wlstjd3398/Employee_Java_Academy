package chapter10;

public class Object1 {

	// 클래스의 구성요소는 멤버변수와 메서드이다
	
	int num1;
	
	double num2;
	
	void func1() {
		System.out.println("func1");
		System.out.println("this.num1 = " + this.num1); // this.num1 여기 안에 있는 num1 멤버변수 호출
		System.out.println("this.num2 = " + this.num2); // 인스턴스에 올라가서 찾음
	}
	
	void func2() {
		System.out.println("func2");
		System.out.println("this.num1 = " + this.num1);
		System.out.println("num2 = " + num2); // 메서드 공간 안에 들어가는 변수임 -> 차선책으로 num2을 가져옴
		// 메서드안에 있는 선언한 변수나 매개변수를 찾고 없으면, 차선책으로 인스턴스로 올라가서 찾음
	}
	
}