package chapter07;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone p1 = new Phone();
		// p1 객체 안에있는 maker는 멤버변수라고 부름
		p1.maker = "삼성";
		p1.price = 1300000;
		p1.displaySize = 170.3;
		p1.ram = 8;
		
		
		Phone p2 = new Phone();
		p2.maker = "삼성";
		p2.price = 2100000;
		p2.displaySize = 191.9;
		p2.ram = 12;
		
		Phone p3 = new Phone();
		p3.maker = "애플";
		p3.price = 2100000;
		p3.displaySize = 160.8;
		p3.ram = 6;
		
	}

}