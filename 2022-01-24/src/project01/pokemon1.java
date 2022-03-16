package project01;

import java.util.Scanner;

public class pokemon1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 전체 틀 -> html 화면구현
		
		// 기능 구성
		// 1.로고 -> html 화면구현
		
		// 2.추첨권확인
		// 3.진행가능여부멘트
		System.out.println("해당 스티커의 추첨번호를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String draw = scan.next();
		
		int num1 = draw.length();
		// 추첨권 확인 안되면 -> 다음 페이지 진입불가
		
		// 추첨권 자리수확인ok, 추첨권이 가짜확인 아직
		if(num1<=10 && num1>=0) {
			System.out.println("= = = = = = = = = = = =");
			System.out.println("올바른 추첨번호입니다. 경품을 선택해 응모해주세요.");
			// 다음 페이지
			
		}else {
			System.out.println("해당 추첨번호가 일치하지 않습니다.");
			// 추첨번호입력 블록 커서 재이동
			while() {
				
			}
			
			for() {
				
			}
		}
		
		
			
	}

}
