package chapter03;

public class StudentManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int kor1 = 64;
		int eng1 = 27;
		int mat1 = 91;
		int sum1 = kor1+eng1+mat1;
		double avg1 = (double)sum1/3;
		
		int kor2 = 58;
		int eng2 = 23;
		int mat2 = 76;
		int sum2 = kor2+eng2+mat2;
		double avg2 = (double)sum2/3;
		
		int order1 = avg1>avg2 ? 1 : 2;
		int order2 = avg1<avg2 ? 1 : 2;
		
		System.out.println("국어 성적 : " + kor1);
		System.out.println("영어 성적 : " + eng1);
		System.out.println("수학 성적 : " + mat1);
		System.out.println("총점 : " + sum1);
		System.out.println("평균 : " + avg1);
		System.out.println("석차 : " + order1);
		
		System.out.println("국어 성적 : " + kor2);
		System.out.println("영어 성적 : " + eng2);
		System.out.println("수학 성적 : " + mat2);
		System.out.println("총점 : " + sum2);
		System.out.println("평균 : " + avg2);
		System.out.println("석차 : " + order2);
		
		
	}

}
