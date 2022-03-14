package chapter08;

public class Object1 {

	// void가 있는 자리가 반환타입 : 메서드가 동작하고 난 다음 되돌려받는 값의 타입
	// PrintLines 메서드이름 : 변수 이름을 짓는 규칙과 동일
	// () 매개변수 : 메서드가 동작하기 위해서 필요한 값의 개수와 타입
	// {} 코드블록 : 메서드에 저장할 소스 코드 / 메서드를 사용하면 이 안의 코드가 불러와짐
	
	void printLines() {
		System.out.println("----- ----- -----");
		System.out.println("----- ----- -----");
	}

	void add() {
		System.out.println("1 + 1 = " + (1 + 1));
	}
	
	
	
}
