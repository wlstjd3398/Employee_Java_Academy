package chapter02;

public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(3.0 / 10.0);
		System.out.println(3.0 / 10);
		System.out.println(3 / 10.0);
		
		int val1 = 3;
		int val2 = 10;
		
		// 이 코드의 동작원리를 이해하고 이 연산의 결과가 올바른 값이 되도록 수정하세요(0.0 -> 0.3)
		 double result =(double) val1 / val2;
		System.out.println("result = " + result);
		
		
	}

}
