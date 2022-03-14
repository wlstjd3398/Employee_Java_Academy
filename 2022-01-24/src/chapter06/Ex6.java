package chapter06;

import java.util.Random;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 목표 체중에 도달할 때까지 운동을 한다
		// while(나의체중weight이 목표체중goal에 도달했나요?)
		
		Random random = new Random();
		
		int weight = 100;
		int goal = 70;
		int loseWeight;
		
		while(goal <= weight) {
			System.out.println("운동을 한다");
			// 운동을 해서 빠질 몸무게
			loseWeight = random.nextInt(6);
			
			// 운동을 하고 난뒤 빠진 나의 체중을 계산
			weight = weight - loseWeight;
		
		}
		System.out.println("다이어트 성공! 이제 몸무게를 유지하세요");
		// 복습하면서 더보기 좋게 바꿔보기
		
	}

}
