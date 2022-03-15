package chapter16;

public class Box<T> {
//박스클래스 안에서 제네릭스를 적용시킨다
// 제네릭스 타입
	
	private int quantity;
	
	
	
	
//	private이여야하지만 generics 배우기위해 잠시만 public 씀
	public T item;
	
	// 데이터타입 자리에 제네릭스 타입을 사용한 게터, 세터 메서드를 직접 선언해라
	
	// 반환하는 item의 반환타입이 T
	 public T getItem() {
	
		return item;
	}
	
	 // 매개변수의 타입을 T
	 public void setItem(T item) {
			this.item = item;
			
		}
	 
}