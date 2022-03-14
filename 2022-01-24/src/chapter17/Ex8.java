package chapter17;

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("홍길동", "010-1234-5678", 1);
		Customer c2 = new Customer("홍길동", "010-1234-5678", 1);
		// c1에 정보가 들어있는게 아니라 정보가 들어있는 메모리주소가 들어있음
		
		// c1에 들어있는 정보와 c2에 들어있는 정보가 같나요?의 결과를 출력하는 코드를 만드세요
		// c1Name과 같이 정보를 꺼냄
		String c1Name = c1.getName();
		String c1Tel = c1.getTel();
		int c1Seat = c1.getSeat();
		
		String c2Name = c2.getName();
		String c2Tel = c2.getTel();
		int c2Seat = c2.getSeat();
		
		// 변수 안에는 값이 들어있으니까 바로 변수명1 == 변수명2 를 해서
		// 두 변수에 들어있는 값이 같은지 비교 할 수 있음
		// 객체 안에는 데이터가 모여서 정보를 이루고 있기 때문에
		// 바로 객체명1 == 객체명2 으로 두 객체가 같은지 비교할 수 없음
		// 객체 안에 있는 데이터를 하나씩 꺼내서 서로 비교를 해야함
		// 모든 데이터가 같다면 같다(true) 다르다면 다르다(false)로 동작하도록
		// 코드를 직접 짜야함
		if(c1Name.equals(c2Name) && c1Tel.equals(c2Tel) && c1Seat == c2Seat) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		
		
		// 기초 설명
//		int num1 = 1;
//		int num2 = 2;
//		
//		// num1에 들어있는 값과 num2에 들어있는 값이 같나요? 의 결과를 출력하는 코드를 만드세요
//		System.out.println(num1 == num2);
		
		
	}

}
