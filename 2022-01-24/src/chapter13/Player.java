package chapter13;

// 추상클래스 : 부모클래스로 동작
// 추상클래스를 부모로 삼는 자식클래스는
// 추상클래스에 선언된 추상메서드를 반드시 구현해야함 -> 자식클래스에 컴파일오류생김

// XX 재생기 클래스의 부모 클래스 역할
// 음악 재생기, 동영상 재생기, ...

public abstract class Player {

	public abstract void play(int pos);
	
	public abstract void stop();
	// 재생기라면 play와 stop 기능이 있어야한다로 해석가능
	
	
	
	
}