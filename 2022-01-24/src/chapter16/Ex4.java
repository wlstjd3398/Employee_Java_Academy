package chapter16;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer obj1 = 10; // 오토 박싱
		int num1 = obj1; // 오토 언박싱
		System.out.println("num1 = " +num1);
		
		Double obj2 = new Double(3.14); // 오토 박싱 전
		double num2 = obj2; // 오토 언박싱
		System.out.println("num2 = " + num2);
		
		Character obj3 = 'a'; // 오토 박싱
		char num3 = obj3.charValue(); // 오토 언박싱 전
		System.out.println("num3 = " + num3);
		
	}

}
