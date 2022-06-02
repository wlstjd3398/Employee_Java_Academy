package chapter06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06.Calculator;
import chapter06.ImpleCalculator1;
import chapter06.aspect.CacheAspect;
import chapter06.aspect.ExecTimeAspect;

// 스프링은 AOP를 적용할 때 프록시 디자인 패턴을 사용해서 적용
// AOP가 적용된 핵심 기능을 가지고 있는 클래스 또는 인터페이스의 이름은 우리 모르게 $proxy~~ 바뀜 

// 스프링에서는 인터페이스를 많이 활용함
// AOP가 적용된 핵심 기능을 가지고 있는 인터페이스가 일반적임

// AOP가 적용된 핵심 기능을 가지고 있는 클래스를 빈으로 등록하고 싶으면
// @EnableAspectJAutoProxy(proxyTargetClass = true) 로 사용해야함
@Configuration
@EnableAspectJAutoProxy
public class AppContext {

	// 실행시간 측정
	@Bean
	public ExecTimeAspect execTimeAspect() {
		return new ExecTimeAspect();
	}
	
	// 캐시도 동작
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	// 핵심기능
	@Bean
	public Calculator calculator() {
		return new ImpleCalculator1();
	}
	
	
	
	
}
