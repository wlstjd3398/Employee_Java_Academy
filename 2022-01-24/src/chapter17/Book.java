package chapter17;

public class Book {

	private String title;
	private int price;
	
	// 생성자
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Book otherBook = (Book) obj;
		String otherTitle = otherBook.getTitle();
		int otherPrice = otherBook.getPrice();
		
		boolean titleSame = title.equals(otherTitle);
		boolean priceSame = price==otherPrice;
		
		return titleSame && priceSame;
	}


	// Hashcode 오버라이드는 암호학을 조금 알아야해서 좀 어려움
	@Override
	public int hashCode() {
		int hashValue = title.hashCode() + price;
		
		return hashValue;
	}



	@Override
	public String toString() {
		return title + "(" + price + "원)";
	}



	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}