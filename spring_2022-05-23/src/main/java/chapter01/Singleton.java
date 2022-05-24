package chapter01;

// 클래스에 싱글톤을 적용하려면
// 클래스의 인스턴스를 마음대로 생성할 수 없게 막아둬야함

public class Singleton {

	private static Singleton instance = null;
	
	// 생성자를 private 접근제어자로 사용하면 인스턴스를 생성할수없는 클래스가 됨
	private Singleton() {
		
		
	}
	
	// 아무나 접근할수있는 메서드
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
		
	}
	
}
