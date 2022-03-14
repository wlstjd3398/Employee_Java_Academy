package chapter06;

import java.util.Arrays;
import java.util.Random;

public class Sol9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		int[] arrLotto = new int[6];
		
		for(int i = 0; i < 6; i++) {
			arrLotto[i] = random.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++){
				if(arrLotto[i] == arrLotto[j]) { // 앞의수와 뒤의수가 같으면 
					i--; // 횟수를 줄이고 안의 for문조건식이 만족못하니 위로 올라가  다시 추출하게하는 중복제거
					break;
				}
			}
			
		}
		
		System.out.println(Arrays.toString(arrLotto));
		
	}

}