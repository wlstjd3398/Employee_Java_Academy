package chapter04;

public class StudentManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] kors = {64, 58};
		int[] engs = {21, 23};
		int[] mats = {91, 76};
		int[] sums = {
				kors[0]+engs[0]+mats[0],
				kors[1]+engs[1]+mats[1]
		};
		double[] avgs = {
				(double) sums[0]/sums.length,
				(double) sums[1]/sums.length
		};
		
		int[] orders = new int[2];
		orders[0] = avgs[0] > avgs[1] ? 1 : 2;
		orders[1] = avgs[0] < avgs[1] ? 1 : 2;
		orders[0] = avgs[0] == avgs[1] ? 1 : orders[0];
		orders[1] = avgs[0] == avgs[1] ? 1 : orders[1];
		
		System.out.println("<<1번째 학생의 성적>>");
		System.out.println("국어 성적 : " +kors[0]);
		System.out.println("영어 성적 : " +engs[0]);
		System.out.println("수학 성적 : " +mats[0]);
		System.out.println("총점 : " + sums[0]);
		System.out.println("평균 : " + avgs[0]);
		System.out.println("석차 : " + orders[0]);
		System.out.println("<<2번째 학생의 성적>>");
		System.out.println("국어 성적 : " +kors[1]);
		System.out.println("영어 성적 : " +engs[1]);
		System.out.println("수학 성적 : " +mats[1]);
		System.out.println("총점 : " + sums[1]);
		System.out.println("평균 : " + avgs[1]);
		System.out.println("석차 : " + orders[1]);
		
//		int[] arr1 = {64, 21, 91};
//		int[] arr2 = {58, 23 ,76};
//		int sum1 = arr1[0]+arr1[1]+arr1[2];
//		int sum2 = arr2[0]+arr2[1]+arr2[2];
//		double avg1 = (double)sum1/arr1.length;
//		double avg2 = (double)sum2/arr2.length;
		
//		int order1 = ;
//		int order2 = ;
//		
	}

}