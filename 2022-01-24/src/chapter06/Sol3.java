package chapter06;

public class Sol3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sumHol=0;
		for(int hol=1; hol<=99; hol=hol+2) {
			sumHol = sumHol + hol;
		}
		System.out.println(sumHol);
		
		int sumJjak=-2;
		for(int jjak=-2; jjak>=-100; jjak=jjak-2) {
			sumJjak = sumJjak + jjak;
		}
		System.out.println(sumJjak);
		
		
		int result = sumHol + sumJjak;
		
		System.out.println(result);
		
		
	}

}
