package chapter14;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 이 프로그램은 예외가 발생하는 프로그램입니다.
		// 예외가 언제 발생하는지 찾고
		// 예외가 발생하지 않도록 처리해봐라
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {3, 2, 1};
		
		System.out.println("인덱스 번호 >> ");
		int index = scan.nextInt();
		
//		if(index>=arr.length || index<0) {
//			System.out.println("찾을 수 없는 인덱스 번호입니다.");
//		}else {
//			System.out.println("arr[" + index + "] = " + arr[index]);
//		}
		
		
		// 선생님 방법
//		if(index<0) {
//			System.out.println("인덱스 번호가 음수일 수 없습니다.");
//		}else if(index >= arr.length) {
//			System.out.println("인덱스 번호는 0 ~ " + (arr.length-1) + " 사이만 사용 할 수 있습니다.");
//		}else {
//			System.out.println("arr[" + index + "] = " + arr[index]);
//		}
		
		
		try {
			System.out.println("arr[" + index + "] = " + arr[index]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("인덱스 번호가 잘못되었습니다.");
		}
		
		
		
	}

}