package chapter05;

import java.util.Scanner;

public class Sol10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 사용자에게 입력을 받기 위한 scanf 객체 생성
				Scanner scanf = new Scanner(System.in);
				
				System.out.println("문제. 세상에서 가장 비싼 새는?");
				
				System.out.print("정답 -> ");
				// 사용자로부터 정답을 전달 받음
				String userAnswer = scanf.nextLine();// nextLine()은 Enter를 치기 전까지 쓴 문자열을 모두 리턴한다는 것
				
				// 퀴즈의 정답
				String correctAnswer = "백조";
				
				// 사용자가 입력한 정답과 퀴즈의 정답이 일치하다면 정답입니다. 출력
				if(correctAnswer.equals(userAnswer)) {
					System.out.println("정답입니다.");
				} else {
					System.out.println("틀렸습니다");
				}

//		왜 틀린거지?? -> if(correctAnswer.equals(userAndwer)) 이 부분에 correctAnswer = userAnswer이
//				각각의 메모리주소가 저장되어있기때문에 문자열의 값은 equal라는 메서드를 사용해서 treu or false를 출력시킴
	}

}