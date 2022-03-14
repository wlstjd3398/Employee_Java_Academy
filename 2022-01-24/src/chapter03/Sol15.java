package chapter03;

public class Sol15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 1234;
		int cheon = number / 1000;
		int beak = number % 1000 / 100;
		int sip = number % 1000 % 100 / 10;
		int il = number % 1000 % 100 % 10 / 1;
		System.out.println(cheon + beak + sip + il);
		
	}

}
