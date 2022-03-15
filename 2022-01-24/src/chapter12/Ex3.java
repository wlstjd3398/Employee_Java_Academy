package chapter12;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 왜 Parent 클래스의 생성자 문구가 출력될까요?
		// 출력하는 코드가 실행되니까 -> 상속관계에서 자식 클래스의 생성자가 호출 되기 전에 부모 클래스의 생성자가 호출된다
//		Parent parent = new Parent();
		
		Child child = new Child();
		
	}

}