package chapter05;

import java.util.Scanner;

public class Sol11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanf = new Scanner(System.in);
		
		System.out.print("연도를 입력해주세요 -->");
		int year = scanf.nextInt();
		
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("윤년인 연도");
		}else {
			System.out.println("윤년이 아닌 연도");
		}
		
	}

}
