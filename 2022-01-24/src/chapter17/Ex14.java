package chapter17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 저장할 제네릭스타입 Customer의 이름으로 고객들의 정보를 구별
		Map<String, Customer> customerList = new HashMap<>();
		
		// 생성자에 맞게 인자를 넣어라고 컴파일오류남 -> Customer클래스가서 맞는 생성자생성
		Customer c1 = new Customer("010-1111-1111", "현금"); 
		Customer c2 = new Customer("010-2222-2222", "카드");
		Customer c3 = new Customer("010-3333-3333", "상품권");
		
		customerList.put("홍길동", c1);
		customerList.put("김철수", c2);
		customerList.put("고영희", c3);
		
		// map에 들어있는키를 set형태로 리턴해줌
		// 제네릭스타입이 키의 데이터타입이 String
		Set<String> keySet = customerList.keySet(); 
		// for문
		for(String key : keySet) {
			Customer nthCustomer = customerList.get(key);
			System.out.println("고객의 이름 : " + key);
			System.out.println("고객의 연락처 : " + nthCustomer.getTel());
			System.out.println("고객의 결제방법 : " + nthCustomer.getPaymentMethod());
		}
		
		// iterator
		
//		System.out.println("첫 번째 고객의 이름 : 홍길동");
//		System.out.println("첫 번째 고객의 연락처 : " + c1.getTel());
//		System.out.println("첫 번째 고객의 결제방법 : " + c1.getPaymentMethod());
		
		
		
		
		
//		// map이용하여 꺼내서 출력
//		Customer nthCustomer = customerList.get("홍길동");
//		System.out.println("1 번째 고객의 이름 : 홍길동");
//		System.out.println("1 번째 고객의 연락처 : " + nthCustomer.getTel());
//		System.out.println("1 번째 고객의 결제방법 : " + nthCustomer.getPaymentMethod());
//		
//		nthCustomer = customerList.get("김철수");
//		System.out.println("2 번째 고객의 이름 : 김철수");
//		System.out.println("2 번째 고객의 연락처 : " + nthCustomer.getTel());
//		System.out.println("2 번째 고객의 결제방법 : " + nthCustomer.getPaymentMethod());
//		
//		nthCustomer = customerList.get("고영희");
//		System.out.println("3 번째 고객의 이름 : 고영희");
//		System.out.println("3 번째 고객의 연락처 : " + nthCustomer.getTel());
//		System.out.println("3 번째 고객의 결제방법 : " + nthCustomer.getPaymentMethod());
//		

	}

}