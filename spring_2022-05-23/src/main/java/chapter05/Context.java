package chapter05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"chapter05"})
public class Context {

	// context에서 직접 등록을 해주고 빈 생성에 속성값을 넣어줌
	// 내가 지정한 메서드로 생성과 소멸에 관여할 때는
	// 생성, 소멸시 호출되는 메서드에 매개변수가 반드시 없어야함 (connect close) 
	@Bean(initMethod="connect", destroyMethod="close")
	@Scope("singleton")
	public Client2 client2() {
		Client2 client2 = new Client2();
		
		client2.setHost("localhost");
		
		return client2;
	}
	
}
