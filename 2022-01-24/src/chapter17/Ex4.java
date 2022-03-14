package chapter17;

import java.util.ArrayList;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(9);
		list.add(8);
		
		System.out.println("초기 : " + list);
		
		list.set(0, 7);
		System.out.println("0번 인덱스에 7 저장 : "+ list);
		
		int originValue = list.set(0,  10);
		System.out.println("0번 인덱스에 10 저장 : " + list);
		System.out.println("0번 인덱스에 들어있던 값 : " + originValue);
		
		
		
	}

}
