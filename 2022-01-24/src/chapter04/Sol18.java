package chapter04;

public class Sol18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 피보나치 수열 = 앞의 두항을 더해 현재 항의 값을 구할수있는 수열
		// n = n-2  +  n-1
		// 첫번째 항 : 1
		// 두번재 항 : 1
		// 피보나치 수열의 세번째 항을 계산하면
		// x3 = x1 + x2 이렇게 됨
		// 배열을 사용해서 피보나치 수열의 10번째 항을 구해라
		int num1 = 1;
		int num2 = 1;
		
		int num3 = num1 + num2;
		int num4 = num2 + num3;
		int num5 = num3 + num4;
		int num6 = num4 + num5;
		int num7 = num5 + num6;
		int num8 = num6 + num7;
		int num9 = num7 + num8;
		int num10 = num8 + num9;
		System.out.println("피보나치 수열의 10번째 항 = "+ num10);
		
		
		
		
	}

}
