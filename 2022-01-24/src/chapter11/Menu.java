package chapter11;

public class Menu {

	String name; // 객체지향을 모르는 개발자도 객체지향을 사용하도록 멤버변수를 private를 사용해 객체지향 사용가능하도록 도움
	int price; // 객체지향을 모르는 개발자도 객체지향을 사용하도록 멤버변수를 private를 사용해 객체지향 사용가능하도록 도움 
	
//	반환타입 메서드이름(매개변수) {
//		소스코드
//	}
	
	// 나의 작성 순서
	// 메서드이름 나와있고 매개변수는 위와같이 정해져있음
	// name이 패키지외부 내부 확인하고 소스코드 입력함
	// 접근제어자 public default private에서 맞는 것을 사용해야함
	public void setName(String name) {
		this.name = name;
		
	}
	// setter(세터) 메서드
	// 1. set으로 시작하는 것의 이름은 set멤버변수의 이름으로 메서드이름을 만듬
	// 2. 이 메서드는 해당 멤버변수에 값을 저장하는 메서드
	
//		메뉴바에서 source - getter setter에서 생성할수도 있음
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public void PrintObjectInfo() {
		System.out.println("메뉴의 이름 = " + name);
		System.out.println("메뉴의 가격 = " + price);
	}
	
	
	// getter(게터) 메서드
	// 1. get멤버변수의 이름으로 메서드 이름을 만듬
	// 2. 이 메서드는 해당 멤버변수의 값을 반환하는 메서드
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	
}
