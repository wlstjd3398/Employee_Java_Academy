package chapter11;

//프로그래밍에서 * : 모든이라는 의미를 갖는 기호, asterisk라고 부름

import java.util.Random;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Random이라는 라이브러리를 import를 통해서 자바개발자가 만든 것을 불러오는것
		Random random = new Random();
		// chapter11에 없는 클래스를 사용하겠다 = import
		// 클래스를 사용하면 그 사용하는 코드가 속한 패키지 안에서 클래스를 찾음
		// 그러나 import가 있으면 import를 먼저 참고함
		
		Scanner scanf = new Scanner(System.in);
		
		// String은 import를 쓰지않고 어떻게 사용?
		// java.lang 패키지 안에 들어있는 모든 클래스(String 포함)는
		// 우리눈에 안보이지만 자동으로 import가 되어있음(import java.lang.*; ) -> 따로 추가를 안해도됨
		String str = "안녕하세요";
		
		
		
	}

}
