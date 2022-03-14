package chapter03;

public class Sol10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int value = 1;
		boolean ten = (value % 2 == 0 || value % 3 == 0 && value % 6 != 0 ) ? true : false;
		
		System.out.println(ten);
	}

}
