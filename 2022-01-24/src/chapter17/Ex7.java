package chapter17;

import java.util.ArrayList;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("홍길동", "010-1473-3698", 32);
		Customer c2 = new Customer("고영희", "010-1598-7894", 55);
		
		ArrayList<Customer> customerList = new ArrayList<>();
		
		customerList.add(c1);
		customerList.add(c2);
		
		
		// 구매자의 목록에서 이름이 홍길동이고 연락처가 010-1473-3698이고 
		// 좌석번호가 32번인 구매자의 정보가 들어있는지 확인하는 프로그램을 개발해라
		// 들어있다면 true를 출력하고 들어있지 않다면 false를 출력해라
		// 참고로 contains 메서드 안쓰고 get과 equals
		
//		for(int i=0; i<customerList.size(); i++) {
//			Customer nthCustomer = customerList.get(i);
//		
//		// n번째 구매자의 정보 중 이름이 홍길동이고
//			if(nthCustomer.getName().equals("홍길동") 
//					&& nthCustomer.getTel().equals("010-1473-3698") 
//					&& nthCustomer.getSeat() == 32) {
//			
//				// n번째 구매자의 정보 중 연락처가 010-1473-3698이고
//				// n번째 구매자의 정보 중 좌석번호가 32이라면
//				// true를 출력
//				System.out.println(true);
//			}
//		}
		
		
		// 구매자의 목록에서 이름이 홍길동이고 연락처가 010-1473-3698이고 
		// 좌석번호가 32번인 구매자의 정보가 들어있는지 확인하는 프로그램을 개발해라
		// 들어있다면 true를 출력하고 들어있지 않다면 false를 출력해라
		// contains 사용
		
		// 찾고자하는 wanted 생성해서 비교
		Customer wanted = new Customer("홍길동", "010-1473-3698", 32);
		
		System.out.println(customerList.contains(wanted));
		// true가 출력돼야하는데 false가 나옴 -> 설명은 Ex8 
		
		// contains는 내부적으로 인자로 전달 받은 값과 이 리스트에 들어있는 모든 데이터를
		// 비교 연산해서 true가 나오면 true를 반환
		// 마지막까지 true가 나오지 않았다면 false를 반환
		// contains가 우리가 의도한대로 동작하도록 하려면 equals 메서드를 오버라이딩하면 됨
		// Customer 클래스 안에다가 equals를 오버라이딩 해야함
		
		
	}

}