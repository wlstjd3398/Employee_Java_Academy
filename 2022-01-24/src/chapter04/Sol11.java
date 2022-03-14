package chapter04;

public class Sol11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int[][] scoreList = {
				{4, 6, 2, 9},
				{7, 8, 3, 7},
				{6, 9, 7, 6},
		};
		
		int movieAmount = scoreList[0].length;
		
		double avgScore = scoreList[0][0] + scoreList[0][1] + scoreList[0][2] + scoreList[0][3];
		avgScore = avgScore / movieAmount;
		
		System.out.println("두 번째 평론가의 평균 평점은 " + avgScore + "점입니다.");

	}

}
