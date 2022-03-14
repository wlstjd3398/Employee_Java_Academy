package chapter04;

import java.util.Arrays;

public class Sol17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 10;
		int num2 = 20;
		
		int[] arr = {num1, num2};			// - ( 1 )
		
		num1 = arr[1];				// - ( 2 )
		num2 = arr[0];				// - ( 3 )
		
		int temp = num1;			// - ( 4 )
		num1 = num2;				// - ( 5 )
		num2 = temp;				// - ( 6 )
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);

	}

}
