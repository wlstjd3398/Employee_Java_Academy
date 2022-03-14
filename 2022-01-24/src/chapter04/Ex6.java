package chapter04;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// 선언과 저장을 한번에 하게되면 배열안의 배열이 더 잘보이게된다
		int[][] studentScores = {
				{84, 62, 55},
				{93, 71, 80},
				{52, 79, 33},
				{42, 100, 52}
		};
		
		int[] student1 = studentScores[0];
		
		int total1 = student1[0] + student1[1] + student1[2];
		
		// 학생들 국어점수 평균
//		System.out.println("학생들 국어점수 평균 = " + 
//		(double)(studentScores[0][0] + studentScores[1][0] + studentScores[2][0] + studentScores[3][0]) / 4);
		
		// 강사님 방법
		int totalKor = studentScores[0][0] + studentScores[1][0] + studentScores[2][0] + studentScores[3][0];
		double avgKor1 = (double) totalKor / 4;
		double avgKor2 = (double) totalKor / studentScores.length;

		System.out.println("강사님 국어평균 = " + avgKor1);
		System.out.println("강사님 국어평균 = " + avgKor2);
		
		System.out.println(studentScores.length);
		
		
		// 길동이 평균
		System.out.println("길동이의 평균 = " + (double)(studentScores[2][0] + studentScores[2][1] + studentScores[2][2]) / 3);
		
		// 강사님 방법
		double[] student3Total = {studentScores[2][0] +studentScores[2][1] + studentScores[2][2]};
		  // student3Total 배열안에 20, 21, 22 가 들어있으니 하나의 배열이다 그래서 밑에 student3Total[0]으로 총점을 대체가능
		double student3Avg = (double) student3Total[0] / studentScores[2].length;
		
		System.out.println("길동이의 평균 = " + student3Avg);
		
		
		
	}

}
