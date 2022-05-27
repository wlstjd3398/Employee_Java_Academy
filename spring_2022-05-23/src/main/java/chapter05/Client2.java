package chapter05;

public class Client2 {

	private String host;

	public void setHost(String host) {
		this.host = host;
	}
	
	public void send() {
		System.out.println("send to " + host);
	}
	
	// 생성과 소멸에 관여하고싶은데 connect라는 이름으로 생성될때 관여하고싶다
	public void connect() {
		System.out.println("connect 메서드 호출");
	}
	
	// 생성과 소멸에 관여하고싶은데 close라는 이름으로 생성될때 관여하고싶다
	public void close() {
		System.out.println("close 메서드 호출");
	}
	// context에서 직접 등록을 해주고 빈 생성에 속성값을 넣어줌
	
}
