package chapter13;

public class Calculator implements Calculatorable{

	@Override
	public int plus(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 + num2;
		return result;
	}

	@Override
	public int minus(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 - num2;
		return result;
	}

	@Override
	public int multiply(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 * num2;
		return result;
	}

	@Override
	public int division(int num1, int num2) {
		// TODO Auto-generated method stub
		int result = num1 / num2;
		return result;
	}

	
}
