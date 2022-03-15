package chapter12;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = null;
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		// 하나의 객체를 이용해서 여러개의 인스턴스로 다형성을 적용할수있다
		
		car = (Car) fe1; // 데이터타입을 Car와 같은 타입으로 형변환해줘야 저장가능
		fe2 = (FireEngine) car;
		// 자식 fe1가 car부모로 업캐스팅(형변환 연산자 생략가능)
		// 부모 car가 fe2자식으로 다운캐스팅(형변환 연산자 생략 불가능)
		
		// 변수에서의 예시
//		int num1 = 3;
//		double num2 = (double) num1;
//		
//		double num3 = 3.14;
//		int num4 = (int) num3;
		
//		// 업캐스팅
//		작은 범위에서 큰범위로 올라갈때, 형변환 연산자 생략가능
//		자손타입에서 조상타입으로 올라갈때
//		// 다운캐스팅
//		큰 범위에서 작은 범위로 내려갈때, 형변환 연산자 생략불가능
//		조상타입에서 자손타입으로 내려갈때

	}

}