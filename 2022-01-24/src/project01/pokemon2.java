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

public class pokemon2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 7.결과보기버튼
		System.out.println("=====결과버튼 누른 후=====");
		// 해당 발표날짜에 일치하면 당첨여부와 핸드폰번호입력창 표시(작성 중)
		// 해당 발표날짜에 일치하지않으면 발표날짜 멘트 출력(작성 중)		
		 List<String> dateArray = new ArrayList<String>();
		 	dateArray.add("2022-03-18");
		 	dateArray.add("2022-03-19");
		 	dateArray.add("2022-03-20");
		 	dateArray.add("2022-03-21");
		 	dateArray.add("2022-03-22");
		 	dateArray.add("2022-03-23");
		 	dateArray.add("2022-03-24");
		 	

		 	//날짜문자열에서 정수로 변환 후 for문?
//		 	DateTimeFormatter d1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		 	LocalDateTime d2 = LocalDateTime.parse(dateArray, d1);
	      
	      
//	      System.out.println("날짜 결합 배열1 : " + dateArray);
	      Collections.sort(dateArray); // ArrayList에서 Collections.sort()로 날짜별 정렬 가능
//	      System.out.println("날짜 결합 배열2 : " + dateArray);
	      
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
//        System.out.println("현재 날짜 = " + strDate);  
        
//        System.out.println(dateArray.contains(strDate));
        
        boolean check = dateArray.contains(strDate);
        
        if(check==true) {
        	// 해당 날짜인 경우에는 당첨여부 먼저 표시
    		// 당첨인 경우 휴대폰번호 입력해야함
    		// 꽝인 경우 멘트만 출력
    		System.out.println("당신의 당첨여부는?");
    		Random random1 = new Random();
    		int yn = random1.nextInt(2);
    		 if(yn==1) {
    			 System.out.println("당첨입니다. 해당 휴대폰번호로 안내문자가"
    			 		+ " 오늘 중으로 갈예정입니다. 그러니 휴대폰번호를 입력해주세요.");
    			// 휴대폰번호
    			while(true) {
    				System.out.println("-를 포함한 13자리를 입력해주세요.");
    				Scanner scan2 = new Scanner(System.in);
    				String phoneNumber = scan2.next();
    				
    				int num1 = phoneNumber.length();
    				if(num1==13) {
    					System.out.println("올바른 휴대폰번호입니다.");
    					break;
    				}else {
    					System.out.println("휴대폰번호가 일치하지 않습니다. 다시 입력해주세요.");
    				}
    				continue;
    			}
    		 }else if(yn==0) {
    			 System.out.println("아쉽지만 꽝입니다. 다음 기회에..");
    		 }
    		 
        }else {
        	System.out.println("결과 발표 기간은 " + dateArray + "입니다.");
        }

		
	}

}