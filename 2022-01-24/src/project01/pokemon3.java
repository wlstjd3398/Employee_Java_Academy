package project01;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class pokemon3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 7.결과보기버튼
		System.out.println("결과버튼 누른 후");
//		Scanner scan1 = new Scanner(System.in);
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
//		String today = now.format(formatter);
//		System.out.println(today);
		
		SimpleDateFormat Format = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 MM분");
		Date time = new Date();
		String timedate = Format.format(time).toString();
		System.out.println(timedate);
		
		// 당첨여부
		// if()
		
		// 휴대폰번호
//		System.out.println("-를 포함한 13자리를 입력해주세요.");
//		Scanner scan2 = new Scanner(System.in);
//		String phoneNumber = scan2.next();
//		
//		int num1 = phoneNumber.length();
//		if(num1<=13 && num1>=0) {
//			System.out.println("올바른 휴대폰번호입니다.");
//		}
		
		
		
		
	}

}
