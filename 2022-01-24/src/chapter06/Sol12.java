package chapter06;

public class Sol12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int total = 0;
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) {
				int sum = i*1;
				total = total + sum;
			}
		}
		System.out.println("1 ~ 100 정수 중에서 3배수 총합 = " + total);
		
	}

}
