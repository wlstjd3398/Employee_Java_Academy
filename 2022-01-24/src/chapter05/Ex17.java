package chapter05;

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 1;
		if(true) {
			// 변수가 만들어지는 시기 : 컴퓨터가 변수를 선언하는 코드를 만났을 때
			// 변수가 사라지는 시기 : 변수가 선언된 코드 블록을 끝을 만났을 때
			
			int num2 = 2;
			
			System.out.println("num1 = " + num1);
			System.out.println("num2 = " + num2);
			
		}
		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
	}

}
