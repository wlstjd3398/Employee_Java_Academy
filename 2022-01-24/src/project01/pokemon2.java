package project01;

import java.util.Scanner;

public class pokemon2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4.경품종류 -> html 화면구현
		
		// 5.경품체크박스 -> html 화면구현
		
		// 6.응모하기버튼	
		while(true) {
			System.out.println("=====추첨번호 확인 후 응모 시작=====");
			System.out.println("4가지 품목 중 한가지를 선택해 응모해주세요");
			Scanner scan = new Scanner(System.in);
			int enter = scan.nextInt(5);
			
			if(enter==1) {
				System.out.println("응모되었습니다. 결과보기를 눌러 날짜를 확인해주세요");
				break;
			}else if(enter==2){
				System.out.println("응모되었습니다. 결과보기를 눌러 날짜를 확인해주세요");
				break;
			}else if(enter==3) {
				System.out.println("응모되었습니다. 결과보기를 눌러 날짜를 확인해주세요");
				break;
			}else if(enter==4) {
				System.out.println("응모되었습니다. 결과보기를 눌러 날짜를 확인해주세요");
				break;
			}else if(enter==0){
				System.out.println("버튼을 하나 선택해 다시 응모해주세요");
			}else {
				System.out.println("버튼을 하나 선택해 다시 응모해주세요");
			}
			// 선택하지 않거나 중복 선택시 다시 응모하여 하나만 선택응모해주세요
			continue;
		}
		
		
	}

}