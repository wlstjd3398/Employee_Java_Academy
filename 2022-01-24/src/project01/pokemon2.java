package project01;

import java.util.Scanner;

public class pokemon2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4.경품종류 -> html 화면구현
		
		// 5.경품체크박스 -> html 화면구현
		
		// 6.응모하기버튼	
		Scanner scan = new Scanner(System.in);
		int enter = scan.nextInt(5);
		
		if(enter==1 | enter==2 | enter==3 | enter==4) {
			System.out.println("응모되었습니다. 결과보기를 눌러 날짜를 확인해주세요");	
		}else {
			System.out.println("버튼을 하나 선택해 응모해주세요");
		}
		
		
		
	}

}
