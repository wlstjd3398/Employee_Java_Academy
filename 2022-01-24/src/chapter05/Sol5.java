package chapter05;

import java.util.Arrays;
import java.util.Random;

public class Sol5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 중간고사 평균이상인 학생들 수 출력
		int[] test = {38, 86, 68, 68, 97, 25, 84, 72, 34, 8};
		double sum = test[0] + test[1] + test[2] + test[3] + test[4] + test[5] + test[6] + test[7] + test[8] + test[9]; 
		double avg = sum / test.length; 
		System.out.println("10명의 중간고사 점수 총합 = " + sum);
		System.out.println("10명의 중간고사 점수 평균 = "  + avg);
		
		int pass = 0;
		
		for(int n=0; n<test.length; n++) {
			if(test[n]>=avg) {
				pass++;
			}
			
		}
		
		

		
		System.out.println("중간고사 평균점수 이상의 학생 수는 " + pass + "명입니다.");
		
	}

}