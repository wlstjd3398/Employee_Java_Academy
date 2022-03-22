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

		// 저장된 추첨목록
		
		String[] arr1 = new String[2];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println("추첨번호를 입력하세요.");
			arr1[i] = scan.next();
			
			System.out.println("추첨번호가 목록에 추가되었습니다.");
		}
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println("저장된 추첨번호 = " + arr1[i]);
		}
		
		
		
		
		
	}

}