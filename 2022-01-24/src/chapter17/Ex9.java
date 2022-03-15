package chapter17;

import java.util.ArrayList;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("홍길동", "010-1234-5678", 1);
		Customer c2 = new Customer("홍길동", "010-1234-5678", 3);
		Customer c3 = new Customer("고영희", "010-1111-2222", 2);
		
		System.out.println("c1와 c2가 같나요? " + c1.equals(c2));
		
		
		
		ArrayList<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c3);
		
		
		System.out.println(list.contains(c2)); // 홍길동의 정보가 이 리스트에 들어있나요?
		// contains에 for반복문이 들어있음(ppt확인)
		
		
		
//		list.clear(); // 클리어를 통해 비워짐
//		System.out.println(list.isEmpty()); // 그래서 비워짐 -> true
		
		
		System.out.println("----- ----- -----");
		Customer removeCustomer = new Customer("고영희", "010-1111-2222", 2);
		System.out.println("삭제 전 -> " + list);
		
		list.remove(removeCustomer);
		System.out.println("삭제 후 -> " + list);
		
		
		if(list.remove(removeCustomer)) { 
			// 지운결과를 다시 지우니 지울 데이터가 list없다고 뜸
			System.out.println("데이터를 list에서 지웠습니다.");
		}else {
			System.out.println("지울 데이터가 list에 없습니다.");
		}
		
		
		
		
	}

}