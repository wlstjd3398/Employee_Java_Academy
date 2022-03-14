package chapter06;

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=1;
		while(num <= 3) {
			int num2 = 1;// while 안에서 선언한 변수는 3번 만들고, while끝을 가고 올라가면서 3번 사라짐
			
			System.out.println(num); // 1, 2, 3 출력은 while안
			
			num++;
			num2++;
		}
		System.out.println(num); // 4는 while 밖
		
	}

}
