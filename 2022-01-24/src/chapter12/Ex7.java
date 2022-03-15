package chapter12;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 이 프로그램의 동작 원리를 파악하고
// 이 프로그램을 실행시켰을 때 발생하는 문제의 이유를 설명해라
		// -> fe1.water, fe2.water 메서드 이용 할 수 없다
		
		// 상속 관계이기 때문에 다형성을 적용할 수 있지만
		// 다형성의 규칙에 어긋나는 상황도 있음
		// -> 자바한테 논리적으로  검사해달라 요청하는게
		// instancof 연산자 사용
		// 객체를 지정한 타입으로 형변환 할 수 있는지 알려줌
		
		Car car = new Car();
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		
//		fe1 = (FireEngine) car;
//		fe2 = (FireEngine) fe1;
//		
//		fe1.water();
//		fe2.water();
		
		// fe1 = (FireEngine) Car; 이것을 물어보는것
		// car객체를 Car으로 형변환 할수있나요?
		// car객체를 Object(최상위 객체)로 형변환 할수있나요?
		System.out.println(car instanceof Car);
		System.out.println(car instanceof Object);
		
		if(car instanceof FireEngine) {
			fe1 = (FireEngine) car;
		}
		
		// fe1객체를 FireEngine으로 형변환 할수있나요?
		// fe1객체를 Car로 형변환 할수 있나요?
		// fe1객체를 Object(최상위객체)로 형변환 할수있나요?
		// -> 마지막은 Object obj = (Object) fe1; 이걸 물어보는것
		System.out.println(fe1 instanceof FireEngine);
		System.out.println(fe1 instanceof Car);
		System.out.println(fe1 instanceof Object);
		
	}

}