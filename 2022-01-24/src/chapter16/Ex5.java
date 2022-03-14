package chapter16;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box<Object> box1 = new Box<Object>();
		// 박스에 제네릭스을 지정해줘야하는데 안해줘서 노란색줄생김
		// 문법적으로 틀린것은 아님
		
		// 안됨
//		String box1_item = box1.getItem();
		String box1_item = box1.getItem("아이템1");
		// 문자열을 저장하면 문자열로, 숫자를 저장하면 숫자로
		// 데이터타입이 T로는 할수없어서 Object로 바뀜 
		// 데이터타입이 Object라는 건 어떤 값이든 다 적용할수있다
		Object box1_item = box1.getItem();
		
		
		
		Box<String> box2 = new Box<String>();
		box2.item = "아이템1";
		
		
		
		Box<Integer> box3 = new Box<Integer>();
		box3.item = new Integer(13);
		
		
		
	}

}
