package chapter05;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int week = 7;
		int dayOfMonth = 13;
		int dayOfWeek = dayOfMonth % week;
		System.out.print("2022년 8월 " + dayOfMonth + "일은 ");
		
		if(dayOfWeek == 0) {
			System.out.println("일요일");
		}else if(dayOfWeek == 1) {
			System.out.println("월요일");
		}else if(dayOfWeek == 2) {
			System.out.println("화요일");
		}else if(dayOfWeek == 3) {
			System.out.println("수요일");
		}else if(dayOfWeek == 4) {
			System.out.println("목요일");
		}else if(dayOfWeek == 5) {
			System.out.println("금요일");
		}else {
			System.out.println("토요일");
		}
		
		// 지금 여기 상황에서 else if(dayOfWeek == 6)을 안쓰고 else 써서 출력가능
		
	}

}