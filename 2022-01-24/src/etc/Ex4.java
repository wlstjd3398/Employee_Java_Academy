package etc;

import chapter11.Menu;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu menu1 = new Menu();
//		menu1. -> 다른 패키지에서 사용하려면 어디서든 사용가능한 Menu의 메서드 public 사용함(일반적으로 사용)
		
		menu1.setName("탕수육");
		menu1.setPrice(12000);
		
	}

}
