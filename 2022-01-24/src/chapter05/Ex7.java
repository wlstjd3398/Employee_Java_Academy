package chapter05;

public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 철수가 조별과제 발표시간이 9시
		// 근데 8시이후이고, 돈이 삼만원이상있다면
		// "택시를 타고 학교간다" 를 출력하는 프로그램을 출력해라
		int hour = 8;
		int money = 30000;
		if(hour >= 8 && money >= 30000)
			System.out.println("택시를 타고 학교간다");
		
		// if 안의 if로 만들어서 사용가능(중첩if문)
//		if(hour >= 8) {
//			if(money >= 30000) {
//				System.out.println("택시를 타고 학교간다");
//			}
//		}
		
		
	}

}
