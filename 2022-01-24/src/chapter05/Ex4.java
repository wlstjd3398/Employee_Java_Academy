package chapter05;

import java.util.Arrays;
import java.util.Random;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 ~ 45 사이의 숫자 6개가 한 게임, 로또 당첨 번호를 뽑는 프로그램을 개발해라
		Random random = new Random();
		
		int lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 1번재 숫자 = " + lotto);
		lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 2번재 숫자 = " + lotto);
		lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 3번재 숫자 = " + lotto);
		lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 4번재 숫자 = " + lotto);
		lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 5번재 숫자 = " + lotto);
		lotto = random.nextInt(45) + 1;
		System.out.println("1 ~ 45 사이의 숫자 6개 중 6번재 숫자 = " + lotto);
		
		// 배열을 사용한 로또번호 추첨
		int[] lottoNumbers = {
				random.nextInt(45) + 1,
				random.nextInt(45) + 1,
				random.nextInt(45) + 1,
				random.nextInt(45) + 1,
				random.nextInt(45) + 1,
				random.nextInt(45) + 1
		};
		System.out.println(Arrays.toString(lottoNumbers));
		
		
		
	}

}