package chapter05;

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 프로그램은 타이핑 하고 끝! 아님
		// 내가 의도한대로 동작하는지 여러번 테스트 해봐야함(게임 오픈베타, 클로즈베타처럼)
		
		// if 조건문 - 문제
		int score = 61;
		
		if(score >= 60) {
			System.out.println("통과");
			System.out.println("짝짝짝~ 축하합니다!");
		}
		
		if(score < 60) {
			System.out.println("재시험");
			System.out.println("다음주까지 다시 공부해오세요");
		}
	}

}