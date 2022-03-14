package chapter10;

// 클래스를 잘 만드는 방법
// 클래스를 사용해서 만들 객체를 생각해서
// 그 객체의 특징을 저장할 수 있게 멤버 변수를 선언하고
// 그 객체의 기능(행동)을 할 수 있게 메서드를 선언해야함

// 자동차 3대를 자바로 구현하려고함
// 첫번째 자동차
// - 색 : 빨간색
// - 브랜드 : 현대
// 두번째 자동차
// - 색 : 흰색
// - 브랜드 : 벤츠
// 세번째 자동차
// - 색 : 파란색
// - 브랜드 : BMW

// 3 자동차를 활용해서 레이싱 게임으로 개발하려고함
// 달리는 기능, 멈추는 기능, 드리프트 하는 기능 등이 필요함


public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car();
//		car1.color = "red";
//		car1.brand = "hyundai";
		car1.giveCharacteristicsToObjects("red", "hyundai");
		car1.run();
		car1.stop();
		
		Car car2 = new Car();
//		car2.color = "white";
//		car2.brand = "benz";
		car2.giveCharacteristicsToObjects("white", "benz");
		car2.run();
		car2.stop();
		
		Car car3 = new Car();
//		car3.color = "blue";
//		car3.brand = "BMW";
		car3.giveCharacteristicsToObjects("blue", "BMW");
		car3.run();
		car3.stop();
		
	}

}
