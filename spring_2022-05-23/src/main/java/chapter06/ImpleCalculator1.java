package chapter06;

public class ImpleCalculator1 implements Calculator{

	@Override
	public long factorial(long num) {
//		long start = System.currentTimeMillis();
		// 유닉스 타임스탬프 -> 밀리초로 나옴
		
		
		long result = 1;
		for(long i=1; i<=num; i++) {
			result *= i;
		}
		
//		long end = System.currentTimeMillis();
//		long duration = end - start;
		
//		System.out.println("결과를 구하기 까지 걸린 시간 => " + duration);
		
		return result;
	}
	
}
