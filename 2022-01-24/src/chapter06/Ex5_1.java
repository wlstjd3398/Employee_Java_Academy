package chapter06;

import java.util.Random;

public class Ex5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 복권 1등에 당첨될때까지 복권을 반복적으로 산다(for)
		
		// 1 ~ 6등 까지 있는 복권 / 낙첨도 있음
		Random random = new Random();
		
		// 복권을 사서 당첨된 등수(1 ~ 7등 까지 있다고 봐야함)
		int rank = random.nextInt(7) + 1;
		
		// 1등이 아니라면 "복권을 산다"를 출력
		// 1등이 사자마자 당첨되면 바로 for문을 빠져나가서 아무것도 출력되지않음
		
		for(; rank!=1; ) {
			rank = random.nextInt(7) + 1;
			System.out.println("복권을 산다");
		}
		System.out.println("복권 당첨! 축하드립니다");
		
		
	}

}
