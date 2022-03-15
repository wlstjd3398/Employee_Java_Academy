package chapter04;

import java.util.Arrays;

public class Sol20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// char타입의 변수 하나와 배열 인덱스만 사용해서 알파벳 순을 오름차순정렬해라
		// 0 5 1 2 4 3
		// 0 1 2 3 4 5
		// a j q s t z
		char[] chArr = {'A', 'Z', 'J', 'Q', 'T', 'S'};
		
		System.out.println("<< 정렬 전 >>");
		System.out.println(Arrays.toString(chArr));
		
		// 정렬 코드
		char nthArr = chArr[5];
		chArr[5] = chArr[1];
		chArr[1] = chArr[2];
		chArr[2] = chArr[3];
		chArr[3] = nthArr;
		
		System.out.println("<< 정렬 후 >>");
		System.out.println(Arrays.toString(chArr));

	}

}