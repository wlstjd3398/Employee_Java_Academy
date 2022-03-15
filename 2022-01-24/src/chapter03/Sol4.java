package chapter03;

public class Sol4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int birth = 900318;
		
		int day = birth % 100; // 생년월일 뒷 두자리는 태어난 일
		birth = birth / 100; // 생년월일 뒷 두자리를 사용했으므로 일을 제외
		System.out.println(day);
		System.out.println(birth);
		
		int month = birth % 100; // 일이 제외된 생년월에서 뒷 두자리는 테어난 월
		birth = birth / 100; // 생년월의 뒷 두자리를 사용했으므로 월을 제외
		System.out.println(month);
		System.out.println(birth);
		
		int year = birth; // 연도만 남았으므로 그대로 year 변수에 저장
		
		System.out.println("철수는 "+ year + "년 " + month + "월 "
				+ day + "일에 태어났습니다.");
	}

}