package chapter05;

import java.util.Random;
import java.util.Scanner;

public class Sol8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("원하는 구구단이 몇단인가요?");
		Scanner scanf = new Scanner(System.in);
		int insert = scanf.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.println(insert + " * " + i + " = " + (insert * i));
		}
				
				
				
				
//		int two = 2;
//		System.out.println(two + " * " + 1 + " = " + (two*1));
//		System.out.println(two + " * " + 2 + " = " + (two*2));
//		System.out.println(two + " * " + 3 + " = " + (two*3));
//		System.out.println(two + " * " + 4 + " = " + (two*4));
//		System.out.println(two + " * " + 5 + " = " + (two*5));
//		System.out.println(two + " * " + 6 + " = " + (two*6));
//		System.out.println(two + " * " + 7 + " = " + (two*7));
//		System.out.println(two + " * " + 8 + " = " + (two*8));
//		System.out.println(two + " * " + 9 + " = " + (two*9));
//		
//		int three = 3;
//		System.out.println(three + " * " + 1 + " = " + (three*1));
//		System.out.println(three + " * " + 2 + " = " + (three*2));
//		System.out.println(three + " * " + 3 + " = " + (three*3));
//		System.out.println(three + " * " + 4 + " = " + (three*4));
//		System.out.println(three + " * " + 5 + " = " + (three*5));
//		System.out.println(three + " * " + 6 + " = " + (three*6));
//		System.out.println(three + " * " + 7 + " = " + (three*7));
//		System.out.println(three + " * " + 8 + " = " + (three*8));
//		System.out.println(three + " * " + 9 + " = " + (three*9));
//		
//		int four = 4;
//		System.out.println(four + " * " + 1 + " = " + (four*1));
//		System.out.println(four + " * " + 2 + " = " + (four*2));
//		System.out.println(four + " * " + 3 + " = " + (four*3));
//		System.out.println(four + " * " + 4 + " = " + (four*4));
//		System.out.println(four + " * " + 5 + " = " + (four*5));
//		System.out.println(four + " * " + 6 + " = " + (four*6));
//		System.out.println(four + " * " + 7 + " = " + (four*7));
//		System.out.println(four + " * " + 8 + " = " + (four*8));
//		System.out.println(four + " * " + 9 + " = " + (four*9));
//		
//		int five = 5;
//		System.out.println(five + " * " + 1 + " = " + (five*1));
//		System.out.println(five + " * " + 2 + " = " + (five*2));
//		System.out.println(five + " * " + 3 + " = " + (five*3));
//		System.out.println(five + " * " + 4 + " = " + (five*4));
//		System.out.println(five + " * " + 5 + " = " + (five*5));
//		System.out.println(five + " * " + 6 + " = " + (five*6));
//		System.out.println(five + " * " + 7 + " = " + (five*7));
//		System.out.println(five + " * " + 8 + " = " + (five*8));
//		System.out.println(five + " * " + 9 + " = " + (five*9));
//		
//		int six = 6;
//		System.out.println(six + " * " + 1 + " = " + (six*1));
//		System.out.println(six + " * " + 2 + " = " + (six*2));
//		System.out.println(six + " * " + 3 + " = " + (six*3));
//		System.out.println(six + " * " + 4 + " = " + (six*4));
//		System.out.println(six + " * " + 5 + " = " + (six*5));
//		System.out.println(six + " * " + 6 + " = " + (six*6));
//		System.out.println(six + " * " + 7 + " = " + (six*7));
//		System.out.println(six + " * " + 8 + " = " + (six*8));
//		System.out.println(six + " * " + 9 + " = " + (six*9));
//		
//		int seven = 7;
//		System.out.println(seven + " * " + 1 + " = " + (seven*1));
//		System.out.println(seven + " * " + 2 + " = " + (seven*2));
//		System.out.println(seven + " * " + 3 + " = " + (seven*3));
//		System.out.println(seven + " * " + 4 + " = " + (seven*4));
//		System.out.println(seven + " * " + 5 + " = " + (seven*5));
//		System.out.println(seven + " * " + 6 + " = " + (seven*6));
//		System.out.println(seven + " * " + 7 + " = " + (seven*7));
//		System.out.println(seven + " * " + 8 + " = " + (seven*8));
//		System.out.println(seven + " * " + 9 + " = " + (seven*9));
//		
//		int eight = 8;
//		System.out.println(eight + " * " + 1 + " = " + (eight*1));
//		System.out.println(eight + " * " + 2 + " = " + (eight*2));
//		System.out.println(eight + " * " + 3 + " = " + (eight*3));
//		System.out.println(eight + " * " + 4 + " = " + (eight*4));
//		System.out.println(eight + " * " + 5 + " = " + (eight*5));
//		System.out.println(eight + " * " + 6 + " = " + (eight*6));
//		System.out.println(eight + " * " + 7 + " = " + (eight*7));
//		System.out.println(eight + " * " + 8 + " = " + (eight*8));
//		System.out.println(eight + " * " + 9 + " = " + (eight*9));
//		
//		int nine = 9;
//		System.out.println(nine + " * " + 1 + " = " + (nine*1));
//		System.out.println(nine + " * " + 2 + " = " + (nine*2));
//		System.out.println(nine + " * " + 3 + " = " + (nine*3));
//		System.out.println(nine + " * " + 4 + " = " + (nine*4));
//		System.out.println(nine + " * " + 5 + " = " + (nine*5));
//		System.out.println(nine + " * " + 6 + " = " + (nine*6));
//		System.out.println(nine + " * " + 7 + " = " + (nine*7));
//		System.out.println(nine + " * " + 8 + " = " + (nine*8));
//		System.out.println(nine + " * " + 9 + " = " + (nine*9));
		
		
	}

}
