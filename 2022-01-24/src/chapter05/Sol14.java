package chapter05;

import java.util.Random;

public class Sol14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		System.out.println("컴퓨터가 동전을 던집니다!");
		// 동전을 던져서 나온 면을 Boolean 타입의 데이터로 표현
		boolean coin = random.nextBoolean();
		
		System.out.println(coin);
		
		if(coin == true) {
			System.out.println("정답!");
		}else if(coin == false) {
			System.out.println("땡~!");
		}
		
		
	}

}