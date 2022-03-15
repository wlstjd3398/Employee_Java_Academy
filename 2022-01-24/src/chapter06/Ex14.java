package chapter06;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ageArray = {21, 21, 23, 22};
		
		// ageArray 안에는 네 학생의 나이가 들어있습니다.
		// 네 학생의 합계 나이와 평균 나이를 계산해 출력해라
		
//		for(int n=0; n<=ageArray.length; n++) {
//			System.out.println(ageArray[n]);
//			
//		}
		
		// 방법2
		int totalAge = 0;
//		totalAge = totalAge + ageArray[0];
//		totalAge = totalAge + ageArray[1];
//		totalAge = totalAge + ageArray[2];
//		totalAge = totalAge + ageArray[3];
		
		for(int i=0; i<=3; i++) {
			totalAge = totalAge + ageArray[i];
		}
		System.out.println("학생들 총나이 = " + totalAge);
		
		double avgAge = (double) totalAge / ageArray.length;
		System.out.println("학생들 평균나이 = " + avgAge);
		
		
		
		
		// 방법1
//		int totalAge = ageArray[0] + ageArray[1] + ageArray[2] + ageArray[3];
//		double avgAge =(double) totalAge / ageArray.length;
//		System.out.println("학생들 총나이 = " + totalAge);
//		System.out.println("학생들 나이 평균 = " + avgAge);
		
	}

}