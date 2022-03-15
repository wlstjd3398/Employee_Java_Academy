package chapter06;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 반복적으로 사용되는 코드를 반복문으로 바꿀때는
		// 1. 반복적으로 사용되는 코드를 찾음
		// 2. 반복적으로 사용되는 코드에서 변하는 부분, 변하지 않는 부분을 찾음
		// 3. 변하지 않는 부분은 반복문 안에 그대로 복붙
		// 4. 변하는 부분은 변화의 시작 값, 변화의 종료 값, 변화의 증감 값을 찾는다.
		// 5. (4)를 찾았다면 반복문으로 바꿀 수 있음
		// 6. (4)를 찾지 못했다면 반복문을 바꿀 수 없음
		
//		System.out.println("2 * 1 = 2");
//		System.out.println("2 * 2 = 4");
//		System.out.println("2 * 3 = 6");
//		System.out.println("2 * 4 = 8");
//		System.out.println("2 * 5 = 10");
//		System.out.println("2 * 6 = 12");
//		System.out.println("2 * 7 = 14");
//		System.out.println("2 * 8 = 16");
//		System.out.println("2 * 9 = 18");
		
		// 구구단 2단 while이용해서 출력
		int back = 1;
		
		while(back <= 9) {
			System.out.println("2 * " + back + " = " + (2 * back));
			back++;
		}
		
		
		
	}

}