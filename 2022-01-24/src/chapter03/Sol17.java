package chapter03;

public class Sol17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 1235;
		int il = number % 1000 % 100 % 10 / 1 ;
		
		System.out.println(il >= 5 ? "오전" : "오후");
	}

}
