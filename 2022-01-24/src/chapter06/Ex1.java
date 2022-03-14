package chapter06;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// num이 1부터
		int num = 1;
		// 3이하일 동안
		while(num <= 3) {
			// 하나씩 증가하면서 while안의 코드를 반복적으로 실행한다.
			num++;
			System.out.println("Hello World~!");
		}
		System.out.println("num = " + num);
		
		 // num 변수의 영향을 받는 코드는 int, while, num++ 세개 전부다이다.
		
	}

}
