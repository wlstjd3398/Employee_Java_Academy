package chapter17;

import java.util.HashMap;
import java.util.Map;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Map은 제네릭스타입이 키와 값 두가지가 사용됨
		// 키 String, 값 Integer
		
		// 1학년 1반의 국어점수
		Map<String, Integer>  classOneKor = new HashMap<>();
		
		classOneKor.put("홍길동", 95); // 홍길동이라는 키에 값이 10이 저장됨
		classOneKor.put("김철수", 86); 
		classOneKor.put("고영희", 35);
		
		System.out.println(classOneKor);
		
		// 각 데이터대신 키가 있기에 get 사용시 키를 사용해서 값 불러옴
		int student1Kor = classOneKor.get("홍길동");
		System.out.println("홍길동의 국어점수 : " + student1Kor);
		
		// 위에 있던 홍길동키가 사라지고 73의 값으로 저장됨
		classOneKor.put("홍길동", 73); 
		
		// 이렇게 지우면 키까지 다 지워짐
		classOneKor.remove("김철수");
		System.out.println(classOneKor); 
		
		// 키를 알고있으면 데이터를 관리하기 쉬움 
		// 그러나 키를 모르면 데이터를 관리하기 어려움
		
		// list는 인덱스번호대로 순서대로 저장됨(끼워넣는것 아닌 이상)
		// map은 넣은 순서대로 저장되지않음
		
	}

}
