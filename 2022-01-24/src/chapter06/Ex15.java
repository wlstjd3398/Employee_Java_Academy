package chapter06;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// str 문자열에서 0번째는 a, 4번째는 e
		String str = "apple";
		
		System.out.println("이 문자열의 길이는 5자입니다.");
		
		int strLength = str.length();
		System.out.println("이 문자열의 길이는 " + str.length() + "자입니다.");
		
		System.out.println("이 문자열의 길이는 " + strLength +"자입니다.");
		
		
		// 문자열에서 문자 추출
		char firstChar = str.charAt(0);
		System.out.println("str 문자열에서 0번째 인덱스의 문자(첫번째문자)는 " + firstChar);
		
		
		// 이 문자열의 첫 번째 문자부터 마지막 문자까지 하나씩 뽑아서 출력해라
		char secondChar = str.charAt(1);
		char thirdChar = str.charAt(2);
		char forthChar = str.charAt(3);
		char fifthChar = str.charAt(4);
		
		System.out.println(secondChar);
		System.out.println(thirdChar);
		System.out.println(forthChar);
		System.out.println(fifthChar);
		
		// charAt을 이용하여 하나씩 뽑아서 출력
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		System.out.println(str.charAt(4));
		
		
		// for문을 이용해서 문자열에서 문자를 추출
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		
		
		
	}

}