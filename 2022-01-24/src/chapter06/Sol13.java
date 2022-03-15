package chapter06;

import java.util.Random;

public class Sol13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int dice1 = random.nextInt(6) + 1;;
		int dice2 = random.nextInt(6) + 1;;
		
		System.out.println(dice1 + " + " + dice2);
		
		int sumDice = dice1 + dice2;
		
		수의 합이 5가 나올때까지 계속 주사위 던지기
		
		while(true) {
			if(sumDice == 5) {
				System.out.println(dice1 + " + " + dice2 + "프로그램이 종료합니다.");
			}else {
				dice1 = random.nextInt(6) + 1;
				dice2 = random.nextInt(6) + 1;
			}
			break;
		}
			
			
		
		
		
	}

}