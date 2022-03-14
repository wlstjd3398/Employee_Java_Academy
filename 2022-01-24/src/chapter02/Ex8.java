package chapter02;

public class Ex8 {
	
	public static void main(String[] args) {
		
		String name = "홍길동";
		String job = "Programmer";
		
		// 데이터 타입이 String(문자열)인 변수만의 특징
		// - 변수 안에 문자열이 저장되는게 아닌 문자열이 저장된 메모리 주소가 저장됨
		// - sysout으로 String 타입의 변수를 사용하면
		// 지금까지 배운 논리로는 그 변수가 갖고 있는 메모리 주소가 출력되어야함
		// 그러나! 문자열은 예외적으로 그 변수가 가리키고 있는 문자열("홍길동" 또는 "Programmer")
		// 출력됨
		
		System.out.println(name);
		System.out.println(job);
		
	}
}

