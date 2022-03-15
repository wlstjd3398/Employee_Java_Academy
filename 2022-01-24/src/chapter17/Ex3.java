package chapter17;

import java.util.ArrayList;

public class Ex3 {
//	리팩토링이 중요 -> 내가 개발한 코드를 다시 한번 점검해서 개선하는 작업
	
	// 반환타입을 몰라서 일단 void, 매개변수도 아직몰라서 빈칸
	// return 없으니 void로 사용, customerList가 아래 메서드에 없음 그래서 매개변수에 구매자정보를 전달해줘야함
	public void printAllCustomer(ArrayList<Customer> customerList) {
		for(int i=0; i<customerList.size(); i++) {
			Customer nthCustomer = customerList.get(i);
			String nthCustomerName = nthCustomer.getName();
			String nthCustomerTel = nthCustomer.getTel();
			int nthCustomerSeat = nthCustomer.getSeat();
			
			System.out.println("<< " + (i+1) + "번째 구매자의 정보 >>");
			System.out.println("이름 : " + nthCustomerName);
			System.out.println("연락처 : " + nthCustomerTel);
			System.out.println("좌석번호 : " + nthCustomerSeat);
		}
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Ex3 ex3 = new Ex3();
		
		
		
		// KTX 승차권 관리 프로그램을 개발해라
		Customer c1 = new Customer("홍길동", "010-1473-3698", 32);
		Customer c2 = new Customer("고영희", "010-1598-7894", 55);
		
		
//		구매자의 정보인 Customer 클래스를 사용
		ArrayList<Customer> customerList = new ArrayList<>();
		
		// 인스턴스의 주소가 add가 된 것
		customerList.add(c1);
		customerList.add(c2);
		// 객체를 sysout하면 아래처럼 문자열을 출력 -> 오버라이드 해주면 해결
		System.out.println(c2.toString());
		
		
		
		// 메서드 호출
		ex3.printAllCustomer(customerList);
		
		
		
		// 첫번째 구매자의 정보에 접근 -> 너무 번거로움
//		String firstCustomerName = customerList.get(0).getName();
//		String firstCustomerTel = customerList.get(0).getTel();
//		int firstCustomerSeat = customerList.get(0).getSeat();
		
		// for문을 이용한 구매자정보
//		for(int i=0; i<customerList.size(); i++) {
//			Customer nthCustomer =customerList.get(i);
//			String nthCustomerName = nthCustomer.getName();
//			String nthCustomerTel = nthCustomer.getTel();
//			int nthCustomerSeat = nthCustomer.getSeat();
//			
//			System.out.println("<< " + (i+1) + "번째 구매자의 정보 >>");
//			System.out.println("이름 : " + nthCustomerName);
//			System.out.println("연락처 : " + nthCustomerTel);
//			System.out.println("좌석번호 : " + nthCustomerSeat);
//		}
		
		// 반복문을 사용해서 위처럼 변경가능
//		Customer nthCustomer =customerList.get(0);
//		String firstCustomerName = nthCustomer.getName();
//		String firstCustomerTel = nthCustomer.getTel();
//		int firstCustomerSeat = nthCustomer.getSeat();
//		
//		nthCustomer = customerList.get(1);
//		String SecondCustomerName = nthCustomer.getName();
//		String SecondCustomerTel = nthCustomer.getTel();
//		int SecondCustomerSeat = nthCustomer.getSeat();
		
//		System.out.println("firstCustomerName = " + firstCustomerName);
		
		
		// 첫번째 구매자의 정보가 누락
		Customer c3 = new Customer("김영수", "010-7536-9514", 17);
		customerList.add(0, c3);
		
		// 메서드 호출
		ex3.printAllCustomer(customerList);
		
		
//		
//		for(int i=0; i<customerList.size(); i++) {
//			Customer nthCustomer =customerList.get(i);
//			String nthCustomerName = nthCustomer.getName();
//			String nthCustomerTel = nthCustomer.getTel();
//			int nthCustomerSeat = nthCustomer.getSeat();
//			
//			System.out.println("<< " + (i+1) + "번째 구매자의 정보 >>");
//			System.out.println("이름 : " + nthCustomerName);
//			System.out.println("연락처 : " + nthCustomerTel);
//			System.out.println("좌석번호 : " + nthCustomerSeat);
//		}
		

		//홍길동 구매자 환불로 구매자정보 목록에서 제거
		customerList.remove(1);
		ex3.printAllCustomer(customerList);
		
		
		
		
		
		
		
		
	}

}