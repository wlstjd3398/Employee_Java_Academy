package chapter08;

public class Calculator {

	
	// 메서드 호출하는 코드를 만나서 컴퓨터가 메서드 안으로 들어오게 되면
	// RAM 안에 메서드의 공간이 생김
	double calcuAvg(int a, int b, int c) {
		int total = a + b + c;
		double avg = (double) total / 3;
		
		return avg;
	}
	// 위 calcuAvg와 main 아래와 같이 책과 자료에는 한꺼번에 해놓았음
	
	
	void swap(int num1, int num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;
	}
	
	
	public static void main(String[] arg) {
		Calculator cal = new Calculator();
		
		cal.calcuAvg(10, 20, 30);
		
		int num1 = 10;
		int num2 = 20;
		
		cal.swap(num1, num2);
		
	}
	
}
