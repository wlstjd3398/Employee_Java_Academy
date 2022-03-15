package chapter06;

import java.util.Scanner;

public class Sol21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// trim() 함수는 문자열의 앞뒤 공백만  제거가능
		// replaceAll(" ","") 함수는 가운데 공백 제거가능
		
		Scanner scan = new Scanner(System.in);
		
		String s1 = "j a v a";
		System.out.println(s1);
		
//		s1.trim();
		 s1 = s1.replaceAll(" ", "");
		
		
		System.out.println(s1);
		
	}

}