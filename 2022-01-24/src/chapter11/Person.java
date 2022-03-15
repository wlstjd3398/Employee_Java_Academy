package chapter11;

public class Person {

	// 매개변숙가 다른 생성자 오버로딩
	public Person(int age) {
//		this.age=age;
		this(null, age, 0.0);
	}
	
	public Person(String name, int age) {
//		this.name = name;
//		this.age = age;
		this(name, age, 0.0);
	}
	
	public Person(String name, double height) {
		this(name, 0, height);
	}
	
	public Person(int age, double height) {
//		this.age = age;
//		this.height = height;
		this(null, age, height);
	}
	
	public Person(String name, int age, double height) {
		this.name=name;
		this.age=age;
		this.height=height;
	}
	
	
	private String name;
	private int age;
	private double height;
	
	
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