package chapter06;

public class ImpleCalculator2 implements Calculator{

	@Override
	public long factorial(long num) {
		if(num == 0) {
			return 1;
		}else {
			return num * factorial(num -1);
		}
		// 재귀함수(메서드) 호출
		
	}

}
