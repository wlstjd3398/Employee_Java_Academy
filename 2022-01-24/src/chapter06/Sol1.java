package chapter06;

public class Sol1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum1 = 0;
		for(int i=1; i<=100; i++) {
			sum1 = sum1 + i;
		}
		System.out.println("1부터 100까지 정수의 합 = " + sum1);
		// i가 100일때의 합 = 1부터 100까지 정수의 합이다
		
		
		int sum2 = 0;
		for(int l=1; l<=5; l++) {
			sum2 = sum2 + l;
		}
		System.out.println("1부터 5까지 정수의 합 = " + sum2);
		// i가 5일때의 합 = 1부터 5까지 정수의 합이다
		// sum0i1 sum1i2 sum3i3 sum6i4 sum10i5
		
	}
	

}