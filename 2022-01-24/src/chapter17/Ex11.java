package chapter17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Character> set = new HashSet<>();
		
		for(char ch='a'; ch<='z'; ch++) {
			set.add(ch);
		}
		
		
		// 향상된 for문
//		int count = 1;
//		
//		for(Character ch : set) { // set에서 차례대로 꺼낼 객체가 없을때까지 ch에 넣겠다
//			
//			if(count % 2==0) {
//				System.out.println(ch + ", ");
//			}else {
//				System.out.println("알파벳 짝수번째가 아닙니다");
//			}
//			count++;
//		}
		
		
		// for문 continue사용하는 방법도 해보기
//		int count = 1;
//		
//		for(Character ch : set) { // set에서 차례대로 꺼낼 객체가 없을때까지 ch에 넣겠다
//			
//			if(count % 2==0) {
//				System.out.println(ch + ", ");
//			}else {
//				System.out.println("알파벳 짝수번째가 아닙니다");
//			}
//			count++;
////			continue;
//		}
		
		
		// iterator 방법
		Iterator<Character> iterator = set.iterator();
		Character nthCharacter;
		
		while(iterator.hasNext()) {
			nthCharacter = iterator.next();
			System.out.println(nthCharacter);
		
		for() {
			
			
		}
		
			
		}
		
		
	}

}