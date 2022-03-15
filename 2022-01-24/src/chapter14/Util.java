package chapter14;

public class Util {

	public static int findChar(String target, char findData) throws NullPointerException{
		// findChar 메서드가 실행하다가 NullPointerException이 발생하면 findChar로 던져주겠다
		
		// 문자열의 문자하나와 찾고자하는 문자하나와 비교해서 있으면 몇번인덱스인지, 없으면 찾지 못했습니다. 출력
		try {
			for(int i=0; i<target.length(); i++) {
				char nthChar = target.charAt(i);
				
				if(nthChar == findData) {
					return i;
				}
				
			}
		}catch(NullPointerException e) {
			System.out.println("target 매개변수는 Null 일 수 없습니다.");
		}
		return -1; // 문자열 안에 문자가 없다면 -1 반환 후 Ex5 index로 들어감
	
	}
	
}