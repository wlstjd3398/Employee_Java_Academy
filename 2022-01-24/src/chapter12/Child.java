package chapter12;

public class Child extends Parent{

	// 상속 관계에서는 자식 클래스의 생성자 안에 첫번째 줄에
	// 부모 클래스의 생성자를 호출하는 코드가 자동으로 들어감
	public Child() {
		super(1); // 부모클래스의 매개변수가 없는 클래스 super();를 호출한다
//		this(1);
		
		// 부모 클래스의 생성자 호출
//		System.out.println("Child 클래스의 생성자");
	}
	
	// 자식 클래스의 생성자에서 부모클래스의 생성자 중 매개변수가 있는 생성자를 호출하도록 자식 클래스의 생성자를 추가/수정 하세요
	// -> 위 클래스에서 super() 안에 인자를 넣으면 실행됨
	
	
	// 아래 클래스는 위의 클래스 this(1);을 실행할때 사용됨 Child클래스안에서만 호출가능  
//	public Child(int n) {
//		System.out.println("매개변수가 하나인 생성자");
//		System.out.println("n = " + n);
//	}
	
}