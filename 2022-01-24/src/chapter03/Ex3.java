package chapter03;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 시험 성적에 따라 합격, 불합격을 알려주는 프로그램을 개발하려고함
		// 시험 성적은 0 ~ 100점 사이의 값
		// 시험 성적이 올바른 값인지 판별할때 비교, 논리 연산자를 활용함
		
		int score = 50;
		System.out.println(score >= 0);
		System.out.println(score <= 100);
		
		
		// && 연산을 활용해서 우리가 지정한 범위 안에 있는 값인지 그 여부를 확인 할수있음
		// (score >= 0) && ( score <= 100) -> score 변수의 값이 0이상이고 100이하인가요?
		// and 연산자 -> 문제나 회의를 통해서 프로그램을 개발할때 그리고, 이고 같은 and를 의미하는 단어자리에는
		//                 and 연산자가 들어감
		// or 연산자 -> 문제나 회의를 통해서 프로그램을 개발할때 이거나, 또는 or를 의미하는 단어자리에는
        //		          거의 대부분 or 연산자가 들어감
		// 0 <= 100
		System.out.println((score >=0) && (score <= 100));
		
		
	}

}
