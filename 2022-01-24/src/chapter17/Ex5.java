package chapter17;

import java.util.ArrayList;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.println("비어있나요? " + list.isEmpty());
		// isEmpty 비어있나요? 네 -> true, 아니요 -> false 
		
		list.add(0);
		
		if(list.isEmpty()) { // 비어있다면 true로 실행, 비어있지 않다면 false로 실행X
			System.out.println("데이터가 없습니다.");
		}else {
			System.out.println("데이터가 있습니다.");
		}
		
		
	}

}
