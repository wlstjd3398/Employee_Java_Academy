package chapter16;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Integer obj1 = new Integer(10);
//		Integer obj2 = new Integer("10");
		
		Integer obj1 = Integer.valueOf(10);
		Integer obj2 = Integer.valueOf("10");
		
		int obj1Int = obj1.intValue();
		System.out.println(obj1Int);
	}

}
