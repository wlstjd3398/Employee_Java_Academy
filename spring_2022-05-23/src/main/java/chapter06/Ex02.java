package chapter06;

public class Ex02 {

	public static void main(String[] args) {
		// 수행시간 측정과 팩토리얼 계산 같이하려고 이렇게 함
		
		ImpleCalculator1 ic1 = new ImpleCalculator1();
		
		ImpleCalculator2 ic2 = new ImpleCalculator2();
		
		ExecTimeCalculator etc = new ExecTimeCalculator(ic1);
		etc.factorial(1000);
		
		etc = new ExecTimeCalculator(ic2);
		etc.factorial(1000);
		
	}
	

	
	
}
