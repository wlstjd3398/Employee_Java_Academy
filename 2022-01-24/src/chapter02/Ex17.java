package chapter02;

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// mod  연산의 결과는  0 ~ 분모-1 사이의 수 중 하나
		System.out.println(1 % 3);
		System.out.println(2 % 3);
		System.out.println(3 % 3);
		System.out.println(4 % 3);
		System.out.println(5 % 3);

		
		// 어떤 수가 짝수인지 홀수인지 판별하는 프로그램
		System.out.println(5 % 2);
	
		
		// 철수네 과일가게 사과3, 바나나3, 오렌지2
		int shopApple = 3;
		int shopBanana = 3;
		int shopOrange = 2;
		
		// 철수네 과일가게 과일총량(total) 계산하고 평균 과일 보유량(avg)을 계산해 보기좋게 출력
		int total = shopApple + shopBanana + shopOrange;
		double avg = (double) total / 3;
		
		System.out.println("total = " + total);
		System.out.println("avg = " + avg);
	}

}
