package chapter05;

import java.util.Random;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Random 구체화시켜줘야함
		// Random 라이브러리 -> 난수 생성과 관련된 기능들을 갖고 있는 라이브러리
		// 난수 -> 일정한 범위 안의 숫자를 무작위로 선택한 수 또는 수열
		Random random = new Random();
		
		// 정수 중에서 난수
		int su = random.nextInt();
		System.out.println(su);
		
		// 다른 nextInt(범위)
		// 1 ~ 6 까지 있는 정육면체 주사위를 굴린다 3번
		int dice = random.nextInt(6) + 1;
		System.out.println("주사위를 굴려서 나온 수 " + dice);
		
		dice = random.nextInt(6) + 1;
		System.out.println("주사위를 굴려서 나온 수 " + dice);
		
		dice = random.nextInt(6) + 1;		
		System.out.println("주사위를 굴려서 나온 수 " + dice);
		
	}

}
