package chapter10;

public class Car {

	String color;
	String brand;
	
	void giveCharacteristicsToObjects(String color, String brand) {
		this.color = color;
		this.brand = brand;
	}
	
	void run() {
		System.out.println("부릉");
	}
	
	void stop() {
		System.out.println("끼익~");
	}
	
}
