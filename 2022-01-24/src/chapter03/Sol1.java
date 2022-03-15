package chapter03;

public class Sol1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int hour = 3;
		int minute =5;
		int second = (hour*3600) + (minute*60);
		System.out.println("공부한 시간은 " + hour + "시간" + minute + "분으로");
		System.out.println("초로 변환하면 총 " + second + "초로 공부했습니다.");
	}

}