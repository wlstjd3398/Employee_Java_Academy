package chapter05;

public class Sol2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 2;
		int num2 = 3;
		int num3 = 1;
		
		int max;
		if(num1 >= num2 && num1 >= num3) {
			max = num1;	
		}else if(num2 >= num1 && num2 >= num3) {
			max = num2;
		}else {
			max = num3;
		}
		System.out.println("세 수 중 가장 큰 수는 " + max + " 입니다.");
		
		
	}

}
