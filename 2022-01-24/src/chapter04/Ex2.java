package chapter04;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 철수의 국수영 점수를 st1Scores 배열에 저장하고
		// st1scores 배열과 연산자를 활용해서
		// 철수의 총점, 평균을 계산해 출력해라
		
//		int[] st1Scores = new int[4];
//		st1Scores = new int[3];
//		
//		st1Scores[0] = 84;
//		st1Scores[1] = 62;
//		st1Scores[2] = 55;

		
		int[] st1Scores = new int[] {84, 62, 55};
		
		int sum = st1Scores[0] + st1Scores[1] + st1Scores[2];
		System.out.println("sum = " + sum);
		
		double avg = sum / 3;
		System.out.println("avg = " + avg);
		
		
	}

}