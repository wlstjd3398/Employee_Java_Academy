package chapter05;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 조건문
		
		// num의 값이 0이상이고 10이하라면
		// "num의 값이  0 ~ 10 사이의 수입니다" 를 출력하는 if문
		int num1 = 10;
		if(num1 >= 0 && num1 <= 10)
			System.out.println("num1의 값이 0 ~ 10 사이의 수입니다");
		
		int num = -1;
		// num 변수에 들어간 값이 0이상인가요? 라면
		// "num 의 값이 0 이상입니다."를 출력하는 if문
		if(num >= 0)
			System.out.println("num의 값이 0 이상입니다.");
		
		// num 변수에 들어간 값이 10이하인가요? 라면
		// "num 의 값이 10이하입니다."를 출력하는 if문
		if(num <= 10)
			System.out.println("num의 값이 10이하입니다.");
			
	
//		System.out.println("프로그램 시작");
//		if(false)
//			System.out.println("실행");
//		System.out.println("프로그램 종료");
		
	}

}
