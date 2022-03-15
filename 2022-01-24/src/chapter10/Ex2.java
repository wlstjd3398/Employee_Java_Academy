package chapter10;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 한 학생의 성적 정보를 저장하고
		// 그 학생의 평균을 구하는 프로그램을 개발하려고함
		Student st1 = new Student();
//		st1.kor = 1;
//		st1.eng = 2;
//		st1.mat = 3;
		st1.giveCharacteristicsToObjects(1, 2, 3);
		
		// 그 학생의 평균을 계산
//		int total = st1.kor + st1.eng + st1.mat;
//		st1.avg = (double) total / 3;
		st1.calcAvg();
		// Student 클래스에 평균생성하는 메서드를 위와 같이 식을 간단히 바꿀수있음
		
		// 그 학생의 평균도 성적 정보이니까 그 학생의 성적 정보 안에 같이 저장하고 싶음
		// 평균도 성적과 같은 공간(인스턴스)에 저장하도록 코드를 수정해라 -> Student double avg; 생성 후 위에 st1.avg = (double) total / 3;
		
		Student st2 = new Student();
//		st2.kor = 2;
//		st2.eng = 3;
//		st2.mat = 4;
		st2.giveCharacteristicsToObjects(2, 3, 4);
		
//		int total = st2.kor + st2.eng + st2.mat;
//		st2.avg = (double) total / 3;
		st2.calcAvg();
		
		
		Student st3 = new Student();
//		st3.kor = 3;
//		st3.eng = 4;
//		st3.mat = 5;
		st1.giveCharacteristicsToObjects(3, 4, 5);
		
//		int total = st3.kor + st3.eng + st3.mat;
//		st3.avg = (double) total / 3;
		st3.calcAvg();
		
		// st1, st2, st3 반복됨 -> 반복문(변수이름이 달라서 사용불가) or 메서드로 해결가능
		// 평균을 자주 사용할 예정이니 평균을 Student에 메서드선언 할 것
		
	}

}