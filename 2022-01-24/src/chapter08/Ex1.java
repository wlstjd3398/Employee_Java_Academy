package chapter08;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object1 obj1 = new Object1();
		
		// 메서드를 호출한다
		obj1.printLines();
		
//		System.out.println("----- ----- -----");
//		System.out.println("----- ----- -----");

		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 정보수정");
		System.out.println("4. 회원탈퇴");

		// 메서드를 호출한다
		obj1.printLines();
		
//		System.out.println("----- ----- -----");
//		System.out.println("----- ----- -----");

		// 메서드를 호출한다
		obj1.add();
		
		Object2 obj2 = new Object2();
		obj2.add();
		
	}

}