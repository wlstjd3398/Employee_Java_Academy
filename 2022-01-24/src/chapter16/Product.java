package chapter16;

public class Product {

	private String category;
	private int price;
	
	public Product(String category, int price) {
		this.category = category;
		this.price = price;
	}
// 멤버변수에 private 걸려있어서  get으로 반환해서 매개변수 형태로 호출됨 
	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}
	
	
	
}