package chapter03;

public class Sol18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int gae = 50;
		int box = gae / 12;
		int remain = ((gae % 12) >= 1 && (gae % 12) <= 11) ? 1 : 0;
		
		System.out.println(box + remain);
		
	}

}
