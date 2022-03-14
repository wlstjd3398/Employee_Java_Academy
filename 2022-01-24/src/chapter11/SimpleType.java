package chapter11;

public class SimpleType {

	// 접근제어자 안쓰면 default로
	// 접근제어자 쓰면 public private처럼 붙임
	
	public int num1;
	int num2;
	private int num3;
	
	public void func1() {
		System.out.println("func1");
		System.out.println("num3 = " + num3);
	}
	
	void func2() {
		System.out.println("func2");
	}
	
	private void func3() {
		System.out.println("func3");
	}
	
}
