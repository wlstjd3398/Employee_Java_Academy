package chapter04;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 국어 점수를 0번 인덱스, 수학점수를 1번인덱스, 영어점수를 2번인덱스
		int[][] stScores = {
				{84, 93, 52, 42},
				{62, 71, 79, 100},
				{55, 80, 33, 52}
		};
		
		
		// stScores 배열과 연산자만을 이용해서
		// 학생들의 국어점수 평균과 길동이의 평균을 계산해라
		int korSum = stScores[0][0] + stScores[0][1] + stScores[0][2] + stScores[0][3];
		// 0행이 국어점수
		double korAvg =(double) korSum / stScores[0].length;
		System.out.println("학생들 국어점수 평균 = " + korAvg);
				
		int kilSum = stScores[0][2] +stScores[1][2] + stScores[2][2];
		// 길동이의 점수는 3가지행을 가짐 
		double kilAvg = (double) kilSum / stScores.length;
		System.out.println("길동이의 평균 = " + kilAvg);
		
		
		
				
		
	}

}
