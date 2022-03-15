package chapter03;

public class Sol13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Math.floor() : 소수점 이하를 버림한다.
//		Math.ceil() : 소수점 이하를 올림한다.
//		Math.round() : 소수점 이하를 반올림한다.
		
		double num1 = 0.16;
		double num2 = 0.2;
		double after = num1 / num2;
		System.out.println(Math.round(after * 10) / 10.0);
		
	}

}