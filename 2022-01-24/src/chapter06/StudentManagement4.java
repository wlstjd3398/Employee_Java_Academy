package chapter06;

import java.util.Random;

public class StudentManagement4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		int studentCount = random.nextInt(9)+2;
		int subjectCount = 3;
		
		int[] kor = new int[studentCount];
		int[] eng = new int[studentCount];
		int[] mat = new int[studentCount];
		int[] sums = new int[studentCount];
		double[] avgs = new double[studentCount];
		int[] ranks = new int[studentCount];
		
		for(int i=0; i<sums.length; i++) {
			kor[i] = random.nextInt(101);
			eng[i] = random.nextInt(101);
			mat[i] = random.nextInt(101);
			
			sums[i] = kor[i] + eng[i] + mat[i];
			avgs[i] = (double) sums[i] / subjectCount;
		}
		
		for(int i=0; i<sums.length; i++) {
			ranks[i]=1;
			for(int j=0; j<sums.length; j++) {
				if(sums[i] < sums[j]) {
					ranks[i]++;
				}
			}
		}				
		
		for(int i=2; i<studentCount; i=i+2) {
			System.out.print("\t");
		}
		System.out.println("<< 학생들의 성적 >>");
		
		System.out.print("국어 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%5d |", kor[i]);
		}
		System.out.println();
		
		System.out.print("영어 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%5d |", eng[i]);
		}
		System.out.println();
		
		System.out.print("수학 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%5d |", mat[i]);
		}
		System.out.println();
		
		System.out.print("총점 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%5d |", sums[i]);
		}
		System.out.println();
		
		System.out.print("평균 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%3.2f |", avgs[i]);
		}
		System.out.println();
		
		System.out.print("석차 :\t");
		for(int i=0; i<sums.length; i++) {
			System.out.printf("%5d |", ranks[i]);
		}
		System.out.println();
		
	}

}