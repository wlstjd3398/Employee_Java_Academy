package chapter14;

import java.util.Scanner;

public class Ex5 {

	// static : 객체 생성 없이 사용가능하게 클래스 만듬
	// 메서드 static 내에서는 static 멤버만 사용가능
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 문자열의 문자하나와 찾고자하는 문자하나와 비교해서 있으면 몇번인덱스인지, 없으면 찾지 못했습니다. 출력
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력 >> ");
//		String target = scan.nextLine();
		
		String target = null;
		
		System.out.println("찾고자 하는 문자 입력 >> ");
		char data = scan.next().charAt(0);
		try {
			int index = Util.findChar(target, data);
			if(index == -1) {
				System.out.println(data + "을(를) 찾지 못했습니다.");
			}else {
				System.out.println(data + "은(는) " + index + "번 인덱스에 들어있습니다.");
			}
		}catch(NullPointerException e) {
			System.out.println("target이 Null입니다. 확인해주세요.");
		}
		
		
	}

}
