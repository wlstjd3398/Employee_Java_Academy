package chapter07;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object2 obj2 = new Object2();
		Object2 obj3 = new Object2();
		
		obj2.num1 = 1;
		obj3.num1 = 2;
		
		// 이 프로그램의 동작 원리를 분석하세요
		System.out.println("obj2.num1 = " + obj2.num1);
		System.out.println("obj3.num1 = " + obj3.num1);
		
		// Object2를 보면 num2는 클래스 멤버변수로 static이 붙어있음
		Object2.num2 = 3;
		System.out.println("Object2.num2 = " + Object2.num2);
		
		// obj2의 int num1=1; 부분에 저장하려고 들어갔는데
		// Object2 클래스의 정보로 이동해서 int num2 = 4;를 저장함
		obj2.num2 =4;
		System.out.println("obj2.num2 = " + obj2.num2);
		
		
	}

}
