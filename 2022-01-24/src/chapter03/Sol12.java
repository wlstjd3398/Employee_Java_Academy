package chapter03;

public class Sol12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int kor = 34;
		int eng = 67;
		int mat = 98;
		
		int sum = kor + eng + mat;
		double avg = sum / 3.0;		// - ( 1 )
		avg = avg * 100;			// - ( 2 )
		avg = (int) avg;			// - ( 3 )
		avg = avg / 100;			// - ( 4 )
		
		System.out.println("Ã¶¼öÀÇ ÃÑÁ¡ = " + sum + "Á¡ÀÔ´Ï´Ù.");
		System.out.println("Ã¶¼öÀÇ Æò±Õ = " + avg + "Á¡ÀÔ´Ï´Ù.");

	}

}
