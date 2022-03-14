package chapter07;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Phone.maker = "»ï¼º";
		
		Phone p1 = new Phone();
		
		Phone p2 = new Phone();
		
//		p1.maker = "»ï¼º";
		p1.price = 1200000;
		p1.displaySize = 6.5;
		p1.ram = 8;
		
//		p2.maker = "»ï¼º";
		p2.price = 1900000;
		p2.displaySize = 8.4;
		p2.ram = 12;
		
		
		System.out.println(p1.maker);
	}

}
