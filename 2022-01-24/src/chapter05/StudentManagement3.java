package chapter05;

import java.util.Random;

public class StudentManagement3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] kor = new int[2];
		int[] eng = new int[2];
		int[] mat = new int[2];
		int[] sums = new int[2];
		double[] avgs = new double[2];
		int[] ranks = new int[2];
		
		Random random = new Random();
		
		System.out.println("1 번째 학생의 성적을 입력하세요");
		System.out.println("국어 => ");
		kor[0] = random.nextInt(101);
		System.out.println("영어 => ");
		eng[0] = random.nextInt(101);
		System.out.println("수학 => ");
		mat[0] = random.nextInt(101);
		
		System.out.println("2 번째 학생의 성적을 입력하세요");
		System.out.println("국어 => ");
		kor[1] = random.nextInt(101);
		System.out.println("영어 => ");
		eng[1] = random.nextInt(101);
		System.out.println("수학 => ");
		mat[1] = random.nextInt(101);
		
		sums[0] = kor[0]+eng[0]+mat[0];
		avgs[0] = (double) sums[0] / 3;
		
		sums[1] = kor[1]+eng[1]+mat[1];
		avgs[1] = (double) sums[1] / 3;
		
//		ranks[0] = avgs[0] > avgs[1] ? 1 : 2; 
//		ranks[1] = avgs[0] < avgs[1] ? 1 : 2; 
//		ranks[0] = avgs[0] == avgs[1] ? 1 : ranks[0]; 
//		ranks[1] = avgs[0] == avgs[1] ? 1 : ranks[1]; 
		
		if(avgs[0] > avgs[1]) {
			ranks[0]=1;
		}else if(avgs[0] < avgs[1]){
			ranks[0]=2;
		}else {
			ranks[0]=1;
		}
		
		if(avgs[0] < avgs[1]) {
			ranks[1]=1;
		}else if(avgs[0] > avgs[1]){
			ranks[1]=2;
		}else {
			ranks[1]=1;
		}
		
		
		System.out.println("<< 1 번째 학생의 성적 >>");
		System.out.println("국어 = " + kor[0]);
		System.out.println("영어 = " + eng[0]);
		System.out.println("수학 = " + mat[0]);
		System.out.println("총점 = " + sums[0]);
		System.out.println("평균 = " + avgs[0]);
		System.out.println("석차 = " + ranks[0]);
		System.out.println("<< 2 번째 학생의 성적 >>");
		System.out.println("국어 = " + kor[1]);
		System.out.println("영어 = " + eng[1]);
		System.out.println("수학 = " + mat[1]);
		System.out.println("총점 = " + sums[1]);
		System.out.println("평균 = " + avgs[1]);
		System.out.println("석차 = " + ranks[1]);
		
	}

}