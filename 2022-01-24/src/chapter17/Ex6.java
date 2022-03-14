package chapter17;

import java.util.ArrayList;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.contains(1));
		// 이 리스트에 데이터가 들어있나요? -> 이 리스트에 1이 들어있나요?
		// -> 네 -> true, 아니요 -> false
		
		// contains는 내부적으로 인자로 전달 받은 값과 이 리스트에 들어있는 모든 데이터를
		// 비교 연산해서 true가 나오면 true를 반환
		// 마지막까지 true가 나오지 않았다면 false를 반환
		
		
	}

	
	
}
