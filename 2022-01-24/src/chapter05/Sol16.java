package chapter05;

import java.util.Random;


public class Sol16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int pc = random.nextInt(50) + 1;
		
		int think = random.nextInt(50) + 1;
		think = random.nextInt(50) + 1;
		think = random.nextInt(50) + 1;
		think = random.nextInt(50) + 1;
		think = random.nextInt(50) + 1;
		
		
		if(pc < think) {
			System.out.println("Down");
			if(pc < think - 5 && pc > think + 5) {
				System.out.println("Almost Down");
			}
		}else if(pc > think){
			System.out.println("Up");
			if(pc > think - 5 && pc < think + 5) {
				System.out.println("Almost Up");
			}
		}
		
		
		if(pc == think) {
			System.out.println("Right!!");
		}else if(pc !=think) {
			System.out.println("내가 생각한 숫자는 " + "{1 ~ 50 사이의 수} 야");
		}
		
		
		
	}

}