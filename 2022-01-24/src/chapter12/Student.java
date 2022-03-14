package chapter12;

public class Student extends Person{

	private String name;
	private int age;
	private double height;
	
	public void say() {
		System.out.println("말하다");
	}
	
	public void eat() {
		System.out.println("먹다");
	}
	
	public void study() {
		System.out.println("공부하다");
	}

	
	// getter setter 단축키 alt + shift + s -> r
	// 개발툴을 단축키로 쓰는 것도 실력!!
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}
	
}
