package etc;

import chapter12.Object1;
// 다른패키지지만 자식클래스 Object2로 부모클래스Object1에게 코드 물려받음 -> 사용가능
public class Object2 extends Object1{

	public void func() {
		
		num = 10;
		
		func();
	}
	
}
