package chapter04;

import java.util.Arrays;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] avgArr = {67, 81.3, 54.67, 64.67};
		
		char[] gradeArr = {'B', 'A', 'C', 'B'};
		
		// avgArr 배열 내 각 인덱스에 들어있는 데이터를 출력해라
		
		System.out.println(avgArr[0]);
		System.out.println(avgArr[1]);
		System.out.println(avgArr[2]);
		System.out.println(avgArr[3]);
		
		// 배열 안에는 데이터가 아니라 데이터들이 들어있으므로
		// 배열을 아래처럼 그냥 사용하면 안됨
		System.out.println(avgArr);
		
		System.out.println(gradeArr[0]);
		System.out.println(gradeArr[1]);
		System.out.println(gradeArr[2]);
		System.out.println(gradeArr[3]);
		
		// Arrays -> 라이브러리, API 등으로 불림 / 배열과 관련된 우리에게 필요한 기능들을 갖고 있음
		// Arrays 안에 들어있는 toString 기능 -> 지정한 대상(배열)을 문자열화 시켜주는 기능
		// 배열(avgArr)을 문자열로 바꿔줌 -> "[67, 81.3, 54.67, 64.67]"
		System.out.println(Arrays.toString(avgArr));
		
	}

}
