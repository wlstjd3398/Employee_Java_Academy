package chapter05;

import java.util.Random;

public class Sol15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int hour = random.nextInt(24); // 24미만의 수중에 랜덤으로 뽑아서 hour에 넣음 
		int sunny = random.nextInt(2);
		
		
		if(sunny == 0) {
			System.out.println("화창하다");
		}else if(sunny == 1) {
			System.out.println("화창하지 않다");
		}	
		System.out.println("지금 시간은 " + hour + "이고, " + "현재 날씨는 " + sunny + "입니다.");
		

		if(hour >= 6 && hour <= 9) {
			if(sunny == 0) {
				System.out.println("종달새가 노래합니다~");
			}
		}
		
		
		
	}

}
