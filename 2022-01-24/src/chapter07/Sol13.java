package chapter07;

public class Sol13 {

	public static void main(String[] args) {
		
	
	Student s1 = new Student();
	s1.name = "김철수";
	s1.ban = 1;
	s1.no = 11;
	s1.kor = 70;
	s1.eng = 80;
	s1.mat = 90;
	
	System.out.println("학생의 이름 = " + s1.name);
	System.out.println("학생의 반 = " + s1.ban);
	System.out.println("학생의 번호 = " + s1.no);
	System.out.println("학생의 국어 점수 = " + s1.kor);
	System.out.println("학생의 영어 점수 = " + s1.eng);
	System.out.println("학생의 수학 점수 = " + s1.mat);
	
	}
}