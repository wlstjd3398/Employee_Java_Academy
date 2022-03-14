package chapter05;

public class Sol6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int point = 65;
		point = point / 10;
		
		switch(point) {
			case 10:
				System.out.println("VVIP");
				break;
			case 9:
				System.out.println("VIP");
				break;
			case 8:
			case 7:
				System.out.println("우수");
				break;
			case 6:
				System.out.println("일반");
		}

		
		
	}

}
