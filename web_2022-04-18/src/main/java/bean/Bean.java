package bean;


// 자바빈즈에서 사용할 클래스는 반드시 getter, setter가 있어야함
public class Bean {

	private String name;
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
