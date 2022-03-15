package chapter06;

public class Sol4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrGrade = {38, 86, 68, 68, 97, 25, 84 ,72, 34, 8};
		
		int total = 0;
		
		for(int i=0; i<arrGrade.length; i++) {
			total = total + arrGrade[i];
		};
		double avg = (double) total / arrGrade.length;
	System.out.println("학생들의 총합 점수 = " + total);
	System.out.println("학생들의 평균 점수 = " + avg);
	}

}