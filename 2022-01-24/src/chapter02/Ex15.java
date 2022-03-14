package chapter02;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 값자리에 변수이름과 숫자 넣을수 있다
		System.out.println(3 + 10);
		
		int result = 3 - 10;
		System.out.println("result = " + result);
		
		int val1 = 3;
		result = val1 * 10;
		System.out.println("result = " + result);
		
		int val2 = 10;
		// 우리가 컴퓨터가 되어서 동작 원리를 파악하는 것도 중요하지만
		// 우리가 파악한 원리대로 결과가 나왔는지도 같이 봐야함
		// 정수 <연산자> 정수를 하게되면 연산의 결과는 정수임
		// 그래서 나눗셈의 결과를 실수로 구하고 싶으면
		// 실수 / 실수 를 해야함
		result = val1 / val2;
		System.out.println("result = " + result);
		
		result = val1 % val2;
		System.out.println("result = " + result);
		
	}

}
