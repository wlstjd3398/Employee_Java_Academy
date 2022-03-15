package chapter12;

public class Lion extends Animal{

	private String name;
	
//	public Lion(String name) {
//		this.name=name;
//	}
//
//	public String getName() {
//		return name;
//	}
	
	
	public Lion(String name) {
//		super(); 기본생성자가 호출되어 숨겨져있음
		super(name);
		
	}
	
	
}