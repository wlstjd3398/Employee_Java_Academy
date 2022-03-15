package chapter06;

import java.util.Random;

public class StudentManagement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int studentCount = 2;
		int subjectCount = 3;
		
		int[] kor = new int[studentCount];
		int[] eng = new int[studentCount];
		int[] mat = new int[studentCount];
		int[] sums = new int[studentCount];
		double[] avgs = new double[studentCount];
		int[] ranks = new int[studentCount];
		
		Random random = new Random();
		
//		System.out.println("1 번째 학생의 성적을 입력하세요");
//		System.out.println("국어 => ");
//		kor[0] = random.nextInt(101);
//		System.out.println("영어 => ");
//		eng[0] = random.nextInt(101);
//		System.out.println("수학 => ");
//		mat[0] = random.nextInt(101);
//		
//		System.out.println("2 번째 학생의 성적을 입력하세요");
//		System.out.println("국어 => ");
//		kor[1] = random.nextInt(101);
//		System.out.println("영어 => ");
//		eng[1] = random.nextInt(101);
//		System.out.println("수학 => ");
//		mat[1] = random.nextInt(101);
		
		for(int i=0; i<sums.length; i++) {
			kor[i] = random.nextInt(101);
			eng[i] = random.nextInt(101);
			mat[i] = random.nextInt(101);
			
			sums[i] = kor[i]+eng[i]+mat[i];
			avgs[i] = (double) sums[i] / subjectCount;
		}
		
		
//		sums[0] = kor[0]+eng[0]+mat[0];
//		avgs[0] = (double) sums[0] / 3;
//		
//		sums[1] = kor[1]+eng[1]+mat[1];
//		avgs[1] = (double) sums[1] / 3;
		
//		ranks[0] = avgs[0] > avgs[1] ? 1 : 2; 
//		ranks[1] = avgs[0] < avgs[1] ? 1 : 2; 
//		ranks[0] = avgs[0] == avgs[1] ? 1 : ranks[0]; 
//		ranks[1] = avgs[0] == avgs[1] ? 1 : ranks[1]; 
		
//		if(avgs[0] > avgs[1]) {
//			ranks[0]=1;
//		}else if(avgs[0] < avgs[1]){
//			ranks[0]=2;
//		}else {
//			ranks[0]=1;
//		}
//		
//		if(avgs[0] < avgs[1]) {
//			ranks[1]=1;
//		}else if(avgs[0] > avgs[1]){
//			ranks[1]=2;
//		}else {
//			ranks[1]=1;
//		}
		for(int i=0;i<sums.length;i++) {
			ranks[i] = 1;
			
			for(int j=0; j<sums.length; j++) {
				if(sums[i] < sums[j]) {
					ranks[i]++;
				}
			}
		}
		
		for(int i=0; i<sums.length; i++) {
			System.out.println("<<" + (i+1) +" 번째 학생의 성적 >>");
			System.out.println("국어 = " + kor[i]);
			System.out.println("영어 = " + eng[i]);
			System.out.println("수학 = " + mat[i]);
			System.out.println("총점 = " + sums[i]);
			System.out.println("평균 = " + avgs[i]);
			System.out.println("석차 = " + ranks[i]);

		}
		
		
	}

}