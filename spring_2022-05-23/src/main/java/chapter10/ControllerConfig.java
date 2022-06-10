package chapter10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

	@Bean
	public RegistController registController () {
		return new RegistController();
	}
	
}
