package chapter06;

import java.util.Scanner;

public class Sol10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("별을 몇번째 줄의 몇개를 출력하시겠어요?");
		int last = scan.nextInt();
		
		
		for(int i=0; i<last; i++) { // 첫번째행 i=0, 두번째행 i=1...
			for(int j=0; j<=i; j++) { // 첫번째별 j=0, 두번째별 j=1...
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		
		// 안의 for문을 j=0일때 한번실행하여 *출력, j=1되어 밖의 for문으로 감
		// 밖의 for문에서 i=1이 되어 안의 for문을 다시 들어와 j=0, j=1 다시 실행하면 **출력됨
		
	}

}
