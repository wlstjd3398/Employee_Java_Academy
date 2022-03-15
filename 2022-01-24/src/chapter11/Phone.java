package chapter11;

public class Phone {

	// 왼쪽의 Phone 클래스 선언과 오른쪽의 데이터를 참고해서
	// 두 핸드폰의 정보를 저장하세요
	
	private String maker;
	private int price;
	private double displaySize;
	private int ram;
	
	
	// private로 굳이 사용안해도 사용가능한데 접근제어자를 사용해서 컴파일오류가 나는 경우가 있음
	
	// setter 해당 멤버변수에 값을 저장하는 메서드
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	
	public String getMaker() {
		return maker;
	}
	
	public int getPrice() {
		return price;
	}
	public double getDisplaySize() {
		return displaySize;
	}
	public int getRam() {
		return ram;
	}
	
}