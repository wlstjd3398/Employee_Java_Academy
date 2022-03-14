package chapter06;

import java.util.Scanner;

public class Sol11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("2이상의 정수를 입력하세요. 마지막 정수는?");
		int last = scan.nextInt();
		
		for(int n=2;n<=last;n++) {
			int count = 0; // 나누고 난 뒤 나누어지는 값을 센다
			for(int i=1;i<=n;i++) {
				if(n%i==0) { // 1과 자기자신만을 나누어지는 값을 소수라함
					// i에서 n을 나누어 나머지가 0인 값을 두번째일때 안 for문나와서 출력됨
					count++;
				}
			}
			if(count == 2) {
				System.out.print(n + " ");
			}
		}
	}
}
