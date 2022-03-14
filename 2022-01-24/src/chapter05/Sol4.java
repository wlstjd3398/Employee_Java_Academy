package chapter05;

public class Sol4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double weight = 93.1;
		double height = 180.7;
		
		double BMI = (weight / (height * height)) * 10000;
		
		System.out.println("당신의 BMI 지수는 " + BMI + "입니다.");
		
		if(BMI >= 30) {
			System.out.println("고도 비만입니다.");
		} else if(BMI >= 25) {
			System.out.println("비만입니다.");
		} else if(BMI >= 23) {
			System.out.println("과제중 의심입니다.");
		} else if(BMI >= 18.5) {
			System.out.println("정상입니다.");
		} else if(BMI < 18.5) {
			System.out.println("저체중입니다.");
		}

	}

}
