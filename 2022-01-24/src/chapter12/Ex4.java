package chapter12;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ElectricFan fan1 = new ElectricFan();
		// fan1.  이라는 것은 바로 위 객체의 타입 EletricFan에서 어떤 메서드에 접근할수있는지 보여줌
		
		WallMountedFan fan2 = new WallMountedFan();
		// fan2. 이라는 것은 바로 위 객체의 타입 WallMountedFan에서 어떤 메서드에 접근할수있는지 보여줌
		
		// 객체 타입과 인스턴스 타입을 같게 해줬었음
		// 다형성 = 객체와 인스턴스 이름 다르게 함
		// 부모 타입의 객체(ElectricFan)가 자식 타입(WallMountedFan)의 인스턴스를 저장하는 것
		
		ElectricFan fan3 = new WallMountedFan();
		// 선풍기를 하나 저장할수있는 것에 벽걸이선풍기를 저장했다
		// fan3. ElectricFan 객체 타입에서 인스턴스를 100퍼 활용못함 -> hangFan 사용 못함
		// 상속을 끊으면 이것도 문법적 오류생김
		
//		WallMountedFan fan4 = new ElectricFan();
		// 컴파일 오류 -> 자식(WallMountedFan)이 부모(ElectricFan)보다 더 많은 것을 알고 있음(ex.hangFan)
		// 다형성을 적용하려면 상속 관계에 있는 클래스들을 활용해야함
		// 다형성을 적용하려면 객체의 타입은 부모 클래스이어야하고
		// 인스턴스 타입은 자식 클래스 타입이어야함
		
	}

}
