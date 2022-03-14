package chapter04;

import java.util.Arrays;

public class Sol19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2차원 배열 charArr 하나만을 사용해서 인덱스번호만을 사용하여 
		// charArr 배열 내 데이터들을 90도 회전시켜 출력해라
		
		char[][] charArr = {
				{'A', 'B', 'C'},
				{'D', 'E', 'F'},
				{'G', 'H', 'I'}
		};
		
		char nthArr = charArr[0][0];
		charArr[0][0] = charArr[2][0];
		charArr[2][0] = charArr[2][2];
		charArr[2][2] = charArr[0][2];
		charArr[0][2] = nthArr;
		
		char nthArr1 = charArr[0][1];
		charArr[0][1] = charArr[1][0];
		charArr[1][0] = charArr[2][1];
		charArr[2][1] = charArr[1][2];
		charArr[1][2] = nthArr1;
		
		
		
		System.out.println(Arrays.deepToString(charArr));
	}

}
