package chapter11;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu menu1 = new Menu();
//		menu1.name = "짜장면"; // 프로시져지향=절차지향
		menu1.setName("짜장면"); // 객체지향
		
//		menu1.price = 4900; // 프로시져지향=절차지향
		menu1.setPrice(4900); // 객체지향
		
		Menu menu2 = new Menu();
//		menu2.name = "짬뽕"; // 프로시져지향=절차지향
		menu2.setName("짬뽕"); // 객체지향
		
//		menu2.price = 6000; // 프로시져지향=절차지향
		menu2.setPrice(6000); // 객체지향
		
//		System.out.println(menu1);
//		System.out.println(menu2);
		// chapter11 패키지의 안의 메모리주소가 나오게됨
		
		// 객체의 정보(객체가 갖고있는 데이터들)를 출력하기 위해서는?
		// 자바는 객체 지향 프로그래밍 언어
		// 객체지향 프로그램언어란?
		// 객체를 사용 할 때는 메서드(기능)을 먼저 생각해라
		
//		객체의 정보를 출력할 메서드를 먼저 생각,
//		접근제어자 반환타입 메서드이름(매개변수) {
//			소스코드
//		}
		menu1.PrintObjectInfo();
		menu2.PrintObjectInfo();
		
		
		// getter 메서드를 선언해라
		
		// 첫번째 메뉴의 이름을 가져와서 이 안에서 사용하고 싶음
		String firstMenuName = menu1.getName();
		
		// 첫번째 메뉴의 가격을 가져와서 이안에서 사용하고 싶음
		int firstMenuPrice = menu1.getPrice();
		
	}

}