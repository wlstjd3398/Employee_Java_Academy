package chapter06;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1부터 9 까지의 합을 for문을 이용해서 출력해라
		
//		int sum = 1;
//		sum = sum + 2;
//		sum = sum + 3;
//		sum = sum + 4;
//		sum = sum + 5;
//		sum = sum + 6;
//		sum = sum + 7;
//		sum = sum + 8;
//		sum = sum + 9;
		
		int sum = 1;
		for(int val=1; val<=9; val++) {
			sum = sum + val;
		}
		System.out.println("sum = " + sum);
		
		
	}

}