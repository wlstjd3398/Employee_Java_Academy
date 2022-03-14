package chapter11;

public class Car {

	// 매개변수가 1개인 생성자
	public Car (String brand) {
//		this.brand = brand;
//		딱 한번 생성자 안에서 다른 생성자를 호출가능 -> 반복적으로 사용되는 코드 줄일수 있음
//		생성자 안에서 다른 생성자를 호출하는 코드는 반드시 첫 줄에 위치해야함
		this(brand, 0, null);
	}
	
	// 매개변수가 2개인 생성자
	public Car (String brand, int color) {
		this.brand=brand;
		this.color=color;
	}
	
	// 매개변수가 3개인 생성자
	public Car(String brand, int color, String type) {
		this.brand=brand; // 매개변수 brand를 멤버변수에 저장하도록 this.brand로
		this.color=color;
		this.type=type;
	}
	// 매개변수는 인스턴스를 만들때 인자를 전달
	
	// Car 클래스의 기본생성자를 선언해라
//	public Car() {
//		brand = "현대자동차";
//		color = 1;
//		type = "승용차";
//	}
	// -> 접근제어자가 public, 매개변수가 없고, 소스코드가 없는 생성자
	
	
	private String brand;
	private int color;
	private String type;
	
	
	// setter 해당 멤버변수에 값을 저장하는 메서드
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	// getter 해당 멤버 변수의 값을 변환하는 메서드
	public String getBrand() {
		return brand;
	}
	public int getColor() {
		return color;
	}
	public String getType() {
		return type;
	}
}
