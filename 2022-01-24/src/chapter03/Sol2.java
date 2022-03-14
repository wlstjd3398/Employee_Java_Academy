package chapter03;

public class Sol2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pencils = 534;
		int student = 30;
		
		double pencilsPerStudent =(double) pencils / student;
		System.out.println("학생 한 명당 가질 수 있는 연필의 수는 " + pencilsPerStudent + "개입니다.");
		
		int pencilsLeft = pencils % student;
		System.out.println("연필을 나눠갖고 남은 연필의 수는 " + pencilsLeft + "개 입니다.");
	}

}
