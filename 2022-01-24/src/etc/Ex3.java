package etc;

import chapter11.SimpleType;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleType type = new SimpleType();
		
		type.num1 = 10;
//		type.num2 = 20; default로 다른 패키지에서는 접근 못함
//		type.num3 = 30; private로 자기 자신 내부에서만 사용가능해서 접근 못함
		
//		접근제어자에 맞게 호출할 수 있는 메서드는
//		모두 호출하고 메모리의 상태를 정확하게 표현해라
		type.func1();
//		type.func2(); default로 다른 패키지에서는 접근 못함
//		type.func3(); private로 자기 자신 내부에서만 사용가능해서 접근 못함
		
		
	}

}
