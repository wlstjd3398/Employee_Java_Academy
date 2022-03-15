package chapter16;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 10;
		// 기본 데이터타입은 형변환 해줘야함
		System.out.println((double) num1);
//		String str = "Hello";
		
		// 코드취소선
//		더이상 지원하지 않겠다는 의미로 써도되긴하나 앞으로 버전이 바뀌면서 어떻게 바뀔지 모름
//		오작동이 일어나도 책임지지 않겠다는 말
		Integer num2 = new Integer(10);
		// 래퍼 클래스는 객체가 있기에 형변환 하지말고
		// 객체이기에 메서드를 사용해야함
		System.out.println(num2.doubleValue());
		
	}

}