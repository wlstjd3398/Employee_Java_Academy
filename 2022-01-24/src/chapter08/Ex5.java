package chapter08;

public class Ex5 {

		void method1() {
			System.out.println("인스턴스 메서드");
		}
		
		static void method2() {
			System.out.println("클래스 메서드");
		}
	
		public static void main(String[] args) {
			Ex5 ex = new Ex5();
			ex.method1();// 인스턴스 메서드
			ex.method2();// 클래스 메서드
		}

}