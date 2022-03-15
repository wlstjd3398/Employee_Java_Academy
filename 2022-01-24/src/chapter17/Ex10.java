package chapter17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// set은 equals와 hashcode를 오버라이딩해야한다
		Set<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(9);
		System.out.println("초기 : " + set);
		
		
		set.add(1); // 1이 저장되어있어서 안들어감(무시)
		System.out.println("1 저장 : " + set);
		
		
		if(set.add(3)) {
			System.out.println("3을 추가했음");
		}else {
			System.out.println("3을 추가하지 못했음");
		} // 이렇게 확인할 수 있음
		
		
		set.remove(1); // 1을 지워라가 아니라 타입을 Integer로 바꿔서 지우는것
		System.out.println("1 삭제 : " + set);
		
		
		// index번호가 없어서 get을 할수없음
//		set.get
		// 접근방법1
		for(Integer number : set) {// set에서 차례대로 꺼낼 객체가 없을때까지 number에 넣겠다
			System.out.println(number);
		}
		
		
		// 접근방법2
//		iterator() -> set안에 들어있는 전체 데이터들을 
//		iterator 자료구조에 담아서 iterator를 반환하는 메서드
//		iterator 자료구조 -> 파일 포인터(커서)와 데이터들을 갖고있는 구조
//		아래화살표모양 (파일 포인터 또는 커서라고 부름)
		// Integer가 들어있는 Iterator다 -> 제네릭스 추가
//		Iterator<Integer> iterator = set.iterator();
//		Integer nthInteger = iterator.next();
//		System.out.println(nthInteger);
		// 파일포인터를 한칸뒤로 옮기고 그자리에 있는 nthInteger로 리턴 
//		nthInteger = iterator.next();
//		System.out.println(nthInteger);
//		
//		nthInteger = iterator.next();
//		System.out.println(nthInteger);
//		
//		nthInteger = iterator.next();
//		System.out.println(nthInteger);
		// 더이상 next가 없어서 못함
		
		
		// while 반복문으로 바꾸세요
		// 꼭 순서대로 할 필요없음, 반복되는것부터 먼저 해도됨
		Iterator<Integer> iterator = set.iterator();
		Integer nthInteger;
		
//		int count = 1;
		
		// iterator.hasNext()
		// hasNext 현재 커서위치에서 다음으로 이동할수있는지 알려주는 메서드
		
		while(iterator.hasNext()) {
			nthInteger = iterator.next();
			System.out.println(nthInteger);
//			count++;
		}
		
		
	}

}