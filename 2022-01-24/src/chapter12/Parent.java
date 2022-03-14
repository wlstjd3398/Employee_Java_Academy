package chapter12;

public class Parent {

//	public Parent() {
//		System.out.println("Parent 클래스의 생성자");
//	}
	
	// 자식 클래스의 생성자에서 부모클래스의 생성자 중 매개변수가 있는 생성자를 호출하도록 자식 클래스의 생성자를 추가/수정 하세요
	public Parent(int n) {
		System.out.println("매개변수가 하나인 Parent 클래스의 생성자");
	}
	// 매개변수가 하나인 Parent 클래스의 생성자를 놔두고, Child에 public Child() {super(1); 이부분을 주석처리하면 extends부분에 컴파일 오류생김
	// -> 부모 클래스의 생성자가 매개변수가 있는 생성자만 있으니까
	// 이럴 경우에는 우리가 직접 자식 클래스의 생성자를 선언하고
	// 적절한 부모 클래스의 생성자를 호출하도록 코드를 짜야함
}
