package chapter04;

public class Ex8 {

	public static void main(String[] args) {
		
		// 배열을 선언한 한 상태에서는 
		// 배열 안에 데이터 타입에 맞는 기본값이 저장되어있는 상태로 만들어짐
		// 정수의 기본값 : 0
		// 실수의 기본값 : 0.0
		// 문자의 기본값 : \0
		// 문자열의 기본값 : null
		// 논리의 기본값 : false
		
		int[] arr = new int[3];
		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
	
		int[] arr2 = arr;
		
	}
}