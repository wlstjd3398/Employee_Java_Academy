package chapter06;

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int num=1; num<=3; num++) {
			System.out.println(num);
			
			int num2 = 1; // for문의 초기식에서 선언한 변수는 사라지지않지만 for문 안의 변수는 사라짐
			
			System.out.println(num2);
			
			num2++; // 사라진채로 올라감
			
		}
		
		// for문 안에서 변수 선언했으니 밖에서는 사용못함
		
	}

}