package chapter07;

public class Phone {

	// Phone이라는 클래스안에
	
	// 데이터타입이 Phone인 객체 안에는
	// 데이터타입이 String maker 변수가 들어있고
	// 데이터타입이 int인 price 변수가 들어있고
	// 데이터타입이 double인 displaySize 변수가 들어있고
	// 데이터타입이 int인 ram 변수가 들어있다
	
//	인스턴스 멤버 변수 : 우리가 지금 클래스 내 선언한 멤버 변수가 인스턴스 멤버 변수,
//	클래스의 인스턴스를 만들어야 접근 가능한 멤버 변수
	static String maker;
//	 final static String maker = "삼성";
	int price;
//	final int price; final이 붙은 멤버 변수는 final int price = 1200000; 이런식으로 써야함
//	final이 붙으면 초기값이 최종값이 되어 바뀌지 않음
	double displaySize;
	int ram;
	
}

//클래스 멤버 변수 : 클래스명을 사용해서 접근할 수 있는 멤버 변수,
//클래스 멤버 변수는 선언할 때 맨 앞에 static 키워드가 붙음

//인스턴스 멤버 변수는 클래스의 인스턴스를 만드는 시점에 생성됨
//클래스 멤버 변수는 프로그램이 실행되면서 만들어짐
	
	
	
