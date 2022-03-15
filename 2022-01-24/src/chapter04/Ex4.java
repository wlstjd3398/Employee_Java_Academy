package chapter04;

import java.util.Arrays;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] heightList = {163.9, 177.2, 170.3};
		
		// heightList에 학생들의 키를 저장
		// heightList에 학생들의 키 순서대로 오름차순 정렬해서 저장하고 싶었음
		// 그러나 실수로 키가 큰 학생의 데이터가 중간에 들어갔음
		
		double nthHeight = heightList[1];
		heightList[1] = heightList[2];
		heightList[2] = nthHeight;
		// 인덱스 1번을 nthHeight로, 인덱스2번을 인덱스1번자리로, nthHeight을 2번자리로
		
		// 메모리를 그려서 위 코드의 동작 원리를 파악하고
		// Array.toString을 사용해서 heightList 배열 내 데이터들을 출력해라
		
		System.out.println(Arrays.toString(heightList));
		
		System.out.println("배열의 길이 = " + heightList.length);
		
		// 배열의 인덱스번호를 벗어나서 접근하면 예외(Exception)이 발생함 -> 조심!
//		System.out.println(heightList[3]);
		
	}

}