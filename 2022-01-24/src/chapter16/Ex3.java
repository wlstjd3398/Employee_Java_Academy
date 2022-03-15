package chapter16;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer obj1 = 10;
		// 실제로는 아래처럼 구현되어있다는 것을 알고있어야함(오토박싱)
//		다음과 같이 Integer 타입의 객체 obj1에
//		기본 데이터 타입인 int형 데이터를 저장
//		변수부터 항상 얘기했던 것이
//		변수에 데이터를 저장할 때는 변수의 데이터 타입과 일치하는 데이터를 저장해야한다고 했음
//		이 코드는 obj1 객체의 타입과 obj1 객체에 저장하는 데이터의 타입이 서로 다르지만
//		오토 박싱 기능이 적용되서 정상적으로 동작하는 코드임
//		Integer 래퍼 클래스는 기본 데이터 타입인 int에 대응되는 참조 데이터 타입이기 때문에
//		int 타입의 정수를 Integer 타입의 객체에 저장할 때 오토 박싱이 적용되는 것


//		Integer obj1 = new Integer(10);
		
		
		int num = obj1;
		// 정수를 저장할수있는 데이터에 메모리주소(오토언박싱)
		// 오토언박싱때문에  int num = obj1; 
		// ->int num = obj1.intValue(); 자동으로 바뀜
		
//		이렇게 오토박싱 될수없음
//		Integer obj1 = 10.0;
//		Integer obj2 = "10";
		
	}

}