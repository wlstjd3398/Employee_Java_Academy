package chapter06;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int sum = 1 + 2 + 3 + 4 + 5;
		
//		int sum = 1;
//		sum = sum + 2;
//		sum = sum + 3;
//		sum = sum + 4;
//		sum = sum + 5;
		
		// 위 아래 코드의 연산 결과가 동일해지도록
		// (while이 끝나고 난 다음에는 sum변수에 15(1+2+3+4+5)가 들어있어야함)
		// while과 관련된 코드를 수정하세요
		
		int sum = 1;
		int n = 2;
		
		while(n <= 5) {
			sum = sum + n;
			n++;
		}
		System.out.println("sum = " + sum);
		
		
	}

}
