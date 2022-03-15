package chapter06;

public class Sol5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {30, 24, 71, 43, 86, 70, 68, 78, 86, 98};
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		double avg = (double) sum / arr.length;
		
		System.out.println("합 = " + sum);
		System.out.println("평균 = " + avg);
		
		int max = arr[0];
		for(int l=0; l<arr.length; l++) {
			 if(arr[l] >= max) {
				  max = arr[l];
			 }
		}
		System.out.println("최대값 = " + max);
		
		int min = arr[0];
		for(int l=0; l<arr.length; l++) {
			 if(arr[l] <= min) {
				  min = arr[l];
			 }
		}
		System.out.println("최소값 = " + min);
	}

}
