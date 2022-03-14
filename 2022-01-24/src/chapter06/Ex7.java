package chapter06;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		int num = 1;
//		
//		while(true) {
//			System.out.println("Hello World~!");
//			
//			num++;
//			
//			if(num==4) {
//				
//				break;
//			}
//				
//		}
		// while 에 true를 써 while(num <= 3) 안 써도 빠져나가는 문을 while 안에 둔다
		
		
		// 1 ~ 10 사이의 수 중에서 짝수를 출력하는 프로그램을 개발해라
//		int num = 2;
//		
//		while(num <= 10) {
//			System.out.println(num);
//			
//			num = num + 2;
//		}
		
		
		// if continue를 사용한 방법
		int num = 2;
		
		while(num <= 10) {
			if(num % 2 == 1) {
				num++;
				continue;
			}
			
			System.out.println(num);
			num++;
			
		}
		
		
		
	}

}
