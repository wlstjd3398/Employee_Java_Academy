package chapter05;

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		if(true) {
//			System.out.println("if문이");
//			System.out.println("treu일 때");
//			System.out.println("코드 실행");
//		} else {
//			System.out.println("if문이");
//			System.out.println("false일 때");
//			System.out.println("코드 실행");
//		}
		
		
		int num = 0;
		// num 변수에 들어있는 값이 0이라면 if의 코드블록 실행
		if(num == 0) {
			System.out.println("num 변수에 들어있는 값은 0입니다.");
		}else {
			// num 변수에 들어있는 값이 0이 아니라면
			// (num 변수에 들어있는 값이 음수 또는 양수라면)
			// () 위와 같이 조건을 붙여서 else를 생각하면 안됨!
			// 그렇지 않다면 이라고 생각 해야함
			System.out.println("num 변수에 들어있는 값이 0이 아닙니다.");	
		}
		
	}

}