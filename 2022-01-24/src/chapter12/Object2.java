package chapter12;

// 같은 패키지내 Object2가 자식클래스, Object1이 부모클래스 protected 사용가능
public class Object2 extends Object1{

	public void func2() {
		
		num = 10;
		
		func();
	}
	
	
}