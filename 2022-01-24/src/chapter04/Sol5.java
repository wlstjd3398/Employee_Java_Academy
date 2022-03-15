package chapter04;

import java.util.Arrays;

public class Sol5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {1, 2};
		int[] arr2 = arr1;
		
		System.out.println("기본");
		System.out.println("arr1 = " + Arrays.toString(arr1));
		
		int temp = arr2[0];		// - ( 1 )
		arr2[0] = arr2[1];			// - ( 2 )
		arr2[1] = temp;			// - ( 3 )
		
		System.out.println("순서바꾸기");
		System.out.println("arr1 = " + Arrays.toString(arr1));

	}

}
