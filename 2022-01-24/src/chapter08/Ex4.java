package chapter08;

public class Ex4 {

	public static void main(String[] args) {
		Object5 obj = new Object5();
		
		System.out.println(obj.big(1, 2)); // 값자리에 sysout을 넣었다, big이 우선순위를 가지고가고 그 후에 sysout 실행됨
		
		int result = obj.big(-3, -5);
		System.out.println(result);
		
		// obj 객체가 갖고 있는 compare 메서드를 호출하고
		// compare 메서드가 반환하는 값을 적절한 타입의 변수에 저장해라
		// Ex4 -> Object5 -> Ex4
		String val = obj.compare(3);
		System.out.println(val);
		
		
		// Calculator 클래스 안에
		// 국어, 영어, 수학 점수를 전달 받아
		// 평균을 계산한 뒤
		// 평균을 반환하는 메서드를 선언해라
		Calculator calc = new Calculator();
		double grade = calc.calcuAvg(60, 70, 80);
		System.out.println(grade);
		
		
	}
}