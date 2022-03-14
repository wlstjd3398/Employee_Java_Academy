package chapter04;

public class Sol15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] charArrays = new char[3][]; 		// - ( 1 )
		charArrays[0] = new char[1];			// - ( 2 )
		charArrays[1] = new char[2];			// - ( 3 )
		charArrays[2] = new char[3];			// - ( 4 )
		
		int charArrays0Length = charArrays[0].length;
		int charArrays1Length = charArrays[1].length;
		int charArrays2Length = charArrays[2].length;
		
		System.out.println("charArrays0Length = " + charArrays0Length);
		System.out.println("charArrays1Length = " + charArrays1Length);
		System.out.println("charArrays2Length = " + charArrays2Length);

	}

}
