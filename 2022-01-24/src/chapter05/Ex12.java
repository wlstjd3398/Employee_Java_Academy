package chapter05;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		
		System.out.println("당신의 몸무게를 입력해주세요 ->");
		double weight = scanf.nextInt();
		System.out.println("당신의 키를 입력해주세요 ->");
		double height = scanf.nextInt();
		
		double Bmi = (weight / (height * height)) * 10000;
		
		// 효율적인 프로그램이라는 건 무조건 연산횟수가 적은 프로그램이 아니라
		// 연산횟수도 적고 프로그램의 변경이 유연한(조금만 수정해도 전체를 아우를수 있는) 프로그램!
		
		System.out.println("당신의 Bmi는 " + Bmi + " 입니다." );
		
		if(Bmi < 18.5) {
			System.out.println("당신은 저체중입니다.");
		}else if(Bmi >= 18.5 && Bmi < 23) {
			System.out.println("당신은 정상입니다.");
		}else if(Bmi >= 23 && Bmi < 25) {
			System.out.println("당신은 과체중입니다.");
		}else if(Bmi >= 25 && Bmi < 30) {
			System.out.println("당신은 비만입니다. 운동과 식이조절이 필요합니다.");
		}else if(Bmi >= 30) {
			System.out.println("당신은 고도비만입니다. 운동과 식이 조절이 필요합니다.");
		}
		
		// 서비스를 만드는것이니까(유튜브, 카톡 ..) 조금 더 생각해서 더 편하게, 더 가독성이 좋게 만들어야 서로에게 좋다
		
	}

}
