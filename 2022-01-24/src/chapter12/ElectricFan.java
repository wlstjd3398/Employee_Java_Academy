package chapter12;

public class ElectricFan {

	private boolean power; // 전원 온/오프 여부
	private int fanStrength; // 바람의 세기
	private boolean rotation; // 회전 여부
	
	public void powerOnOff() {
		System.out.println("선풍기의 전원 온/오프");
	}
	
	public void pushFanStrength() {
		System.out.println("선풍기의 바람세기 변경");
	}
	
	public void rotationSwitch() {
		System.out.println("선풍기의 회전 여부 변경");
	}
	
}