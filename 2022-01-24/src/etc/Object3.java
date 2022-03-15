package etc;

import chapter12.Object1;
// 다른패키지이고 자식클래스도 아니고 인스턴스를 생성해도 접근제어자protected로 접근 불가
public class Object3 {

	public void func2() {
		
		Object1 object1 = new Object1(); // 클래스 내 멤버변수에 접근하려면 인스턴스 생성해야함
		
		object1.num = 10;
		object1.func();
		
	}
	
	
	
}
