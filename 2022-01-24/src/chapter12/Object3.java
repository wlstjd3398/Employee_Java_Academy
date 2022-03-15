package chapter12;

// Object3이 같은패키지내라서 protected 사용가능
public class Object3 {

	public void func2() {
		
		Object1 object1 = new Object1(); // 클래스 내 멤버변수에 접근하려면 인스턴스 생성해야함
		
		object1.num = 10;
		
		object1.func();
		
	}
	
}