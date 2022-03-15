package chapter17;

import java.util.ArrayList;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> intList = new ArrayList<Integer>();
		// 인스턴스의 제네릭스 를 생략가능 -> 객체의 제네릭스를 따라감(아래와 같이)
		// ArrayList<Integer> intList = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			intList.add(i);
		}
		System.out.println("intList = " + intList);
		
		
		// intList의 2번째, 9번째 데이터를 삭제해라
		intList.remove(1);
		intList.remove(8);
		System.out.println("intList = " + intList);
	
		
		// 반복문과 get메서드를 사용해서 intList의 첫번째 데이터부터 마지막데이터까지 차례대로 출력해라
		for(int i=0; i<=7; i++) {
			Integer number = intList.get(i);
			System.out.println(number);
		}
		// -> 문제가 있음 i<=10; 이 아니라 종료식이 더 많으면 그뒤의 수는 잘림
//		int size = intList.size(); // size() : 요소의 수를 알려준다
//		for(int i=0; i<size; i++) {
//			Integer number = intList.get(i);
//			System.out.println(number);
//		}
		// 향상된 for문 = inhanced for문
		for(int number : intList) { // intList에서 차례대로 number로 데이터를 저장 
			System.out.println(number);
		}
		
		
		
	}

}