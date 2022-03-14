package chapter06;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numberList = {5, 4, 3, 2, 1};
//		System.out.println(numberList[0]);
//		System.out.println(numberList[1]);
//		System.out.println(numberList[2]);
//		System.out.println(numberList[3]);
//		System.out.println(numberList[4]);
		
		
		
		// for문 () 처음부터 작성할 필요 없다 할수 있는 것부터 시작해라
		for(int n=0; n<=numberList.length; n++) {
			System.out.println(numberList[n]);
		}
		
		// index의 수를 안세고 하는 방법 numberList.length; (길이 - 1까지만 사용함)
		
	}

}
