package chapter04;

import java.util.Arrays;

public class Sol14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int length = 4;
		
		int[] intArray = new int[length];
		
		
		
		char[] alphabet1 = {'a', 'b', 'c', 'd', 'e'};
		char[] alphabet2 = new char[alphabet1.length];
		
		alphabet2[0] = 'A';
		alphabet2[1] = 'B';
		alphabet2[2] = 'C';
		alphabet2[3] = 'D';
		alphabet2[4] = 'E';
		
		System.out.println("alphabet1 => " + Arrays.toString(alphabet1));
		System.out.println("alphabet2 => " + Arrays.toString(alphabet2));


	}

}
