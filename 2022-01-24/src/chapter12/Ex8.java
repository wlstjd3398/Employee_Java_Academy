package chapter12;

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Apple타입, Banana타입, Onion타입을 basket에 담아야한다
//		Apple[] applebasket = new Apple[3];
//		
//		applebasket[0] = new Apple();
//		applebasket[1] = new Apple();
//		applebasket[2] = new Apple();
//		
//		Banana[] bananabasket = new Banana[3];
//		bananabasket[0] = new Banana();
//		bananabasket[1] = new Banana();
//		bananabasket[2] = new Banana();
//		
//		Onion[] onionbasket = new Onion[3];
//		onionbasket[0] = new Onion();
//		onionbasket[1] = new Onion();
//		onionbasket[2] = new Onion();
		
		
		Product[] basket = new Product[3];
		basket[0] = new Apple();
		basket[1] = new Banana();
		basket[2] = new Onion();
		
		// 과일은 과열진열대, 채소는 채소진열대만 진열하고, 바구니에 담는 프로그램 개발
		Fruit[] fruitShelf = new Fruit[3];
		fruitShelf[0] = new Apple();
		fruitShelf[1] = new Banana();
		//fruitShelf[2] = new Onion(); // 다형성에 의해 틀린 코드가 맞는것
		
		Vegetable[] VegetableShelf = new Vegetable[3];
		VegetableShelf[0] = new Onion();
		//VegetableShelf[1] = new Banana(); // 다형성에 의해 틀린 코드가 맞는 것
		
	
	}

}