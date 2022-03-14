package chapter08;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object3 obj = new Object3();
		
		obj.printLines1();
		
		// 메서드를 호출할때 넣는 값을 인자 라고함
		obj.printLines2(3);
		obj.printLines2(-1);
		
		obj.printLines3(3.14);
		obj.printLines4(1, 2);
		
	}

}
