package chapter16;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product com1 = new Product("computer", 1900000);
		
		Product com2 = new Product("computer", 1050000);
		
		Product tv1 = new Product("television", 63000);
		
		
		
		// Product 클래스와 Box 클래스를 사용하여"컴퓨터를 상자에 넣는다"
		//  "TV를 상자에 넣는다" 를 표현하세요.
		// ( 컴퓨터 두 대, TV 한 대이므로 상자는 총 3개가 필요합니다. )

		
		// 컴퓨터를 넣을 수 있는 상자를 생성
		Box<Product> box1 = new Box<Product>();
		// 상자에 컴퓨터를 넣는다
		box1.setItem(com1);
		// 컴퓨터를 넣을 수 있는 상자를 생성
		Box<Product> box2 = new Box<Product>();
		// 상자에 컴퓨터를 넣는다
		box2.setItem(com2);
		// tv를 넣을 수 있는 상자를 생성
		Box<Product> box3 = new Box<Product>();
		// 상자에 tv를 넣는다
		box3.setItem(tv1);
		
		
		
	}

}
