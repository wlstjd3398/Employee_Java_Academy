package chapter05;

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 1;
		
		// 변수가 만들어지는 시기 : 변수를 선언하는 코드를 만났을 때
		// switch는 예외적으로 switch를 만나는 순간
		// switch 안에서 선언한 모든 변수가 만들어짐
		switch(num1) {
		case 1:
			int num2 = 1;
			break;
			
		case 2:
			int num3 = 1;
			break;
			
		case 3:
			int num4 = 1;
			break;	
		}
		
		
		
	}

}