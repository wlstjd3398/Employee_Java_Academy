package chapter17;

import java.util.ArrayList;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 컬랙션 프레임워크 -> 자료 구조의 하나인 ArrayList
		// 배열 -> 자료 구조의 하나
		
		String[] strArr = new String[3];
		
		ArrayList<String> strList = new ArrayList<String>();
		// 문자열을 저장할 ArrayList클래스라서 package안에 
		// ArrayList가 없어서 import해줘야함
		
		strList.add("A");
		strList.add("B");
		System.out.println(strList);
		
		strList.add("D");
		strList.add(2, "C");
		System.out.println(strList);
		// C라는 문자를 2번인덱스 자리에(D자리) 새치기를 함 
		// -> C가 그 자리를 차지하고 D가 다음 인덱스로 이동함
		
		
		// 아래 add 메서드의 동작 원리를 분석하세요
		strList.add(0, "Z");
		System.out.println(strList);
		
		// 0번 인덱스로 리턴
		String firstString = strList.get(0);
		System.out.println("첫 번째 문자열은 " + firstString);
		
		String removeString = strList.remove(0);
		// 0번 인덱스를 삭제하려면  0번 다음 자리에서 앞으로 땡김 -> 마지막 인덱스공간을 지움
		System.out.println("삭제한 문자열은 " + removeString);
		System.out.println(strList);
		
	}

}
