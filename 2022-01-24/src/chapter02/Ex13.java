package chapter02;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 실수 > 정수 > 문자
		
//		char ch = 'A';
//		
//		// 업캐스팅(문자를 정수화시킴) : 형 변환 연산자 생략가능
//		int num1 = (int) ch;
//		
//		
////		int num1 = ch;
//		
//		System.out.println("ch = " + ch);
//		System.out.println("num1 = " + num1);
//		
//		
//		// 업캐스팅(정수에서 실수화시킴)
//		double num2 = (double) num1;
//		
//		System.out.println("num1 = " + num1);
//		System.out.println("num2 = " + num2);
		
		
		
		// 다운캐스팅(실수를 정수화시킴)
		double num1 = 3.14;
		
		// 다운캐스팅을 할때에는 형 변환 연산자를 반드시 붙여야함
		// 왜? 다운캐스팅의 경우에는 원래 데이터가 변형 될수 있으므로
		// 우리가 그걸 인지하고 있다는 의미로 반드시 붙여줘야함
				
		int num2 = (int) num1;
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		
		// 다운캐스팅(정수를 문자화시킴)
		num2 = 65;
		char ch = (char) num2;
		System.out.println("num2 = " + num2);
		System.out.println("ch = " + ch);
		 
		
	}

}
