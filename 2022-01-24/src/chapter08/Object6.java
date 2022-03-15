package chapter08;

import java.util.Arrays;

public class Object6 {
	
	void func(int num) {
		num = num + 1;
		System.out.println("num = " + num);
	}
	
	// func2메서드의 매개변수의 데이터 타입은? obj.func2(numArr)의 타입은 int
	void func2(int[] param) {
		param[0] = param[0] + 1;
		System.out.println(Arrays.toString(param));
	}
	// 바깥에도 영향을 미침(참조 데이터타입의 변수로 메모리주소가 복사되어 전달되기때문
	
	// func3메서드의 매개변수의 데이터타입은? Object7의 매개변수 타입
	void func3(Object7 param) {
		param.value = param.value + 1;
		System.out.println("param.value = " + param.value);
	}
	
	// func3 관련된 동작원리 파악해오기!!(Ex7, Object6, Object7)
	
	
	
	
}