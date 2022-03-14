package chapter12;

// 사람들은 이름, 나이, 키를 갖고 있고
// 말하고 먹는 행동을 할 수 있다
// 사람의 특징

public class Person {
// 클래스명(자식클래스)가 Student(부모클래스)를 선택
// 물려받는 코드는 지울 수 있음
	
	private String name;
	private int age;
	private double height;
	
	public void say() {
		System.out.println("말하다");
	}
	
	public void eat() {
		System.out.println("먹다");
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
