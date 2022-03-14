package chapter08;

public class Book {

	private int java;
	private double percent;
	
	void discount(int java, double percent) {
		System.out.println((int)(java * percent));
	}
	
}
