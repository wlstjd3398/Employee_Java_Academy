package chapter06.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

// @Aspect 애노테이션이 적용된 클래스는
// Advice와 Pointcut을 함께 구현해야함
@Aspect
@Order(1)
public class ExecTimeAspect {
	
	// 정규표현식으로 pointcut 지정함
	// @Pointcut 애노테이션은 공통 기능을 적용할 대상을 설정하는 애노테이션
	// chapter06 패키지에 위치한 모든 클래스 중에서 접근제어자가 public인 모든 메서드가 실행될 때 동작할 공통 기능이다. 라고 설정
	// execution 나중에 알아보자(블로그에 스프링AOP 2/3 참고)
	@Pointcut("execution(public * chapter06.*.*(..))")
	private void publicTarget() {
		
		
	}
	
	// 공통기능 지정함
	// Around Advice : 핵심 기능이 실행되기 전/후(Around)에 사용할 공통 기능(Aspect)이다.
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// Pointcut에 명시한 메서드가 동작 하기 전 시간 측정
		long start = System.nanoTime();
		
		// try finally가 있으면 try에서 리턴되면서 finally을 실행해서 duration을 실행해줌
		try {
			// 다음 Pointcut이 동작하거나 핵심 기능이 동작함
			// 핵심 기능 동작전에 다른 동작들을 추가가능함
			Object result = joinPoint.proceed();
			// 핵심 기능이 return을 할 수도 있으니 핵심 기능이 return 하는 값이 있다면 return도 할수 있도록 한 것
			return result;
		} finally {
			// Pointcut에 명시한 메서드가 동작 한 후 시간 측정
			long finish = System.nanoTime();
			
			// 없어도 되는 코드지만 이런식으로 사용할수 있다는 보여줌
			Signature sig = joinPoint.getSignature();
			// getSignature() -> 핵심 기능(메서드)의 정보를 가지고 있는 객체를 반환
			// 자바의 시그니쳐 라는 용어 - 메서드 이름, 매개변수
			String simpleName = joinPoint.getTarget().getClass().getSimpleName();
			// getTarget() -> 핵심 기능을 가지고 있는 클래스 정보를 반환
			// getName() -> 핵심 기능의 이름을 반환
			String name = sig.getName();
			// getArgs() -> 매개변수로 전달한 값(인자) 목록
			String args = Arrays.toString(joinPoint.getArgs());
			// Pointcut에 명시한 메서드의 실행 시간
			long duration = finish - start;
			
			System.out.println(simpleName + "." + name + "("+ args + ") 실행시간 => "+ duration);
		}
	}
}
