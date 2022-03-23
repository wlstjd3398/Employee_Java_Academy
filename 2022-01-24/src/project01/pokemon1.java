package project01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class pokemon1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("=====추첨번호로 추첨에 응모하는 프로그램을 시작하겠습니다.=====");
		System.out.println("포켓몬빵 로고 표시합니다.");
		
		
		while(true) {
		
			System.out.println("빵의 스티커 뒷면의 추첨번호를 입력해주세요");
			
			Scanner rightScan = new Scanner(System.in);
			String drawScan = rightScan.next();
			int limit = drawScan.length();
			
			System.out.println("추첨번호를 확인하겠습니다.");
			
			// 추첨번호를 목록에 차례대로 저장시켜서 노출시켜야함
			
			if(limit<=10 && limit>=8) {
				System.out.println("올바른 추첨번호입니다. 다음 추첨번호를 입력해주세요");
					String[] arr1 = new String[2];			
					for(int i=0; i<arr1.length; i++) {
						arr1[i] = drawScan;
						System.out.println("저장된 추첨목록의 추첨번호 = " + arr1[i]);
					}
				break;
			}else {
				System.out.println("해당 추첨번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		}
		
		// 완성하고나면 핸드폰번호도 해당 추첨번호 배열에 넣기
		
		
		System.out.println("= = = = = 응모를 시작합니다. = = = = =");
		
		
		while(true) {
			System.out.println("4가지 경품 중 한가지를 번호를 선택하여 응모해주세요");
			System.out.println("경품 1번(닌텐도 NDS)");
			System.out.println("경품 2번(포켓몬 완구)");
			System.out.println("경품 3번(포켓몬 영화관람권)");
			System.out.println("경품 4번(포켓몬 스티커 컬렉션 북)");
			Scanner enterScan = new Scanner(System.in);
			int enter = enterScan.nextInt(5);
			
			if(enter==1) {
				System.out.println("경품 1번(닌텐도 NDS)에 응모되었습니다. 결과보기를 눌러 당첨여부를 확인해주세요");
				break;
			}else if(enter==2){
				System.out.println("경품 2번(닌텐도 NDS)에 응모되었습니다. 결과보기를 눌러 당첨여부를 확인해주세요");
				break;
			}else if(enter==3) {
				System.out.println("경품 3번(닌텐도 NDS)에 응모되었습니다. 결과보기를 눌러 당첨여부를 확인해주세요");
				break;
			}else if(enter==4) {
				System.out.println("경품 4번(닌텐도 NDS)에 응모되었습니다. 결과보기를 눌러 당첨여부를 확인해주세요");
				break;
			}else if(enter==0){
				System.out.println("버튼을 하나 선택해 다시 응모해주세요");
			}else {
				System.out.println("버튼을 하나 선택해 다시 응모해주세요");
			}
			
		}
		
		
		System.out.println("= = = = = 결과보기 = = = = =");
		
		
        if(true) {
        	System.out.println("과연");
    		System.out.println("당첨여부는? ");
    		Random random1 = new Random();
    		int yn = random1.nextInt(2);
    		 if(yn==1) {
    			 System.out.println("당첨입니다. 해당 휴대폰번호로 안내문자가"
    			 		+ " 오늘 중으로 갈예정입니다. 그러니 휴대폰번호를 입력해주세요.");
    			 
    			// 휴대폰번호
    			while(true) {
    				System.out.println("-를 포함한 13자리를 입력해주세요.");
    				Scanner PhoneScan = new Scanner(System.in);
    				String phoneNumber = PhoneScan.next();
    				
    				int num3 = phoneNumber.length();
    				if(num3==13) {
    					System.out.println("올바른 휴대폰번호입니다. 완료되었습니다.");
    					break;
    				}else {
    					System.out.println("휴대폰번호가 일치하지 않습니다. 다시 입력해주세요.");
    				}
    			}
    		 }else if(yn==0) {
    			 System.out.println("아쉽지만 꽝입니다. 다음 기회에..");
    		 }
        }
        
        System.out.println("프로그램을 종료합니다.");
		
		
	}

}