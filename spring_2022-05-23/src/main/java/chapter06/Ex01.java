package chapter06;

public class Ex01 {

	public static void main(String[] args) {
		// 반복문 factorial 수행 시간 측정
		long start1 = System.currentTimeMillis();
		
		ImpleCalculator1 ic1 = new ImpleCalculator1();
		ic1.factorial(1000);
		
		long end1 = System.currentTimeMillis();
		
		long duration1 = end1 - start1;
		
		System.out.println("실행 시간 = > " + duration1);
		
		
		// 반복문 factorial 수행 시간 측정
		System.out.println("= = = = = =");
		
		
		// 재귀 함수 factorial 수행 시간 측정
		long start2 = System.currentTimeMillis();
		
		ImpleCalculator2 ic2 = new ImpleCalculator2();
		ic2.factorial(1000);
		
		long end2 = System.currentTimeMillis();
		
		long duration2 = end2 - start2;
		
		System.out.println("실행 시간 = > " + duration2);
		// 재귀 함수 factorial 수행 시간 측정
		
		
	}
	
}
